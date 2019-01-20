package ch.heigvd.gamification.services;

import ch.heigvd.gamification.api.dto.Event;
import ch.heigvd.gamification.dao.*;
import ch.heigvd.gamification.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class EventProcessor {

  @Autowired
  private EndUserRepository endUsersRepository;
  @Autowired
  private ScaleRepository scaleRepository;
  @Autowired
  private UserScaleRepository userScaleRepository;
  @Autowired
  private UserBadgeRepository userBadgeRepository;
  @Autowired
  private PointRuleRepository pointRuleRepository;
  @Autowired
  private PointRuleParamRepository pointRuleParamRepository;
  @Autowired
  private BadgeThresholdRuleRepository badgeThresholdRuleRepository;


  @Async
  @Transactional
  public void processEvent(Application app, Event event) {
    EndUser user = findOrCreateUser(app, event);
    boolean werePointsAwarded = processPointRules(app, user, event);
    if(werePointsAwarded) {
      processBadgeThresholdRules(app, user, event);
    }
  }

  private EndUser findOrCreateUser(Application app, Event event) {
    EndUser user = endUsersRepository.findByAppNameAndIdInGamifiedApplication(app.getName(), event.getUserId());
    if (user == null) {
      user = new EndUser();
      user.setApp(app);
      user.setIdInGamifiedApplication(event.getUserId());
      user.setNumberOfEvents(0);
      for(Scale scale : scaleRepository.findByApp(app)){

      }
      endUsersRepository.save(user);
    }
    user.setNumberOfEvents(user.getNumberOfEvents() + 1);
    endUsersRepository.save(user);
    return user;
  }

  /**
   * Goes through all the app's point rules to find one applicable to the current event. Updates
   * the corresponding scale of the corresponding user accordingly.
   * @return true if a rule was found and applied
   * @see PointRule
   */
  private boolean processPointRules(Application app, EndUser user, Event event) {
    List<PointRule> rules = pointRuleRepository.findByApp(app);
    boolean wasRuleApplied = false;
    for(PointRule rule : rules) {
      if(rule.getEventType().equals(event.getType())) {
        wasRuleApplied = true;

        // Find the corresponding scale
        Scale scale = scaleRepository.findByNameAndApp(rule.getScale().getName(), app);

        // Find user's score in that scale, if non-existent then create
        UserScale userScale = userScaleRepository.findByUserAndScale(user, scale);
        if(userScale == null) {
          userScale = new UserScale();
          userScale.setUser(user);
          userScale.setScale(scale);
          userScale.setNbPoints(0);
        }

        int nbPointsAwarded = processRulePointParams(rule, event);
        userScale.setNbPoints(userScale.getNbPoints() + nbPointsAwarded);
        userScaleRepository.save(userScale);
      }
    }
    return wasRuleApplied;
  }

  /** If event has params, goes through all params of this rule to find a matching parameter
   * @return the default nbPoints for this rule, or if the event has a property with a name and value
   * matching a RuleParam, then the nbPoints of this RuleParam
   */
  private int processRulePointParams(PointRule rule, Event event) {
    int nbPoints = rule.getDefaultNbPoints();
    if(event.getProperties() != null) {
      for(PointRuleParam ruleParam : pointRuleParamRepository.findByPointRule(rule)) {

        String eventParamValue = event.getProperties().get(ruleParam.getParamName());
        if(eventParamValue != null && eventParamValue.equals(ruleParam.getParamValue())) {
          nbPoints = ruleParam.getNbPoints();
          break;
        }
      }
    }
    return nbPoints;
  }

  /**
   * Goes through all the app's badge threshold rules to find if the user has exceeded a threshold.
   * Awards the corresponding badge if this is the case.
   * @see BadgeThresholdRule
   */
  private void processBadgeThresholdRules(Application app, EndUser user, Event event) {
    List<BadgeThresholdRule>  rules = badgeThresholdRuleRepository.findByApp(app);
      for (BadgeThresholdRule rule : rules) {
        UserScale userScale = userScaleRepository.findByUserAndScale(user, rule.getScale());
        if (userScale != null) {
          if (userScale.getNbPoints() >= rule.getThreshold()) {
            UserBadge userBadge = new UserBadge();
            userBadge.setUser(user);
            userBadge.setBadge(rule.getBadge());
            userBadge.setDateAwarded(new Date());
            userBadgeRepository.save(userBadge);
          }
        }
      }
  }
}
