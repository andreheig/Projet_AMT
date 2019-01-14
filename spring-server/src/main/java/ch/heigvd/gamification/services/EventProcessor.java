package ch.heigvd.gamification.services;

import ch.heigvd.gamification.api.dto.Event;
import ch.heigvd.gamification.dao.EndUserRepository;
import ch.heigvd.gamification.dao.PointRuleRepository;
import ch.heigvd.gamification.dao.ScaleRepository;
import ch.heigvd.gamification.dao.UserScaleRepository;
import ch.heigvd.gamification.model.*;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 *
 * @author Olivier Liechti
 */
@Service
public class EventProcessor {

  private final EndUserRepository endUsersRepository;
  private final ScaleRepository scaleRepository;
  private final UserScaleRepository userScaleRepository;
  private final PointRuleRepository pointRuleRepository;


  public EventProcessor(EndUserRepository endUsersRepository,
                        ScaleRepository scaleRepository,
                        UserScaleRepository userScaleRepository,
                        PointRuleRepository pointRuleRepository) {
    this.endUsersRepository = endUsersRepository;
    this.scaleRepository = scaleRepository;
    this.userScaleRepository = userScaleRepository;
    this.pointRuleRepository = pointRuleRepository;
  }

  @Async
  @Transactional
  public void processEvent(Application app, Event event) {
    EndUser targetEndUser = endUsersRepository.findByAppNameAndIdInGamifiedApplication(app.getName(), event.getUserId());
    if (targetEndUser == null) {
      targetEndUser = new EndUser();
      targetEndUser.setApp(app);
      targetEndUser.setIdInGamifiedApplication(event.getUserId());
      targetEndUser.setNumberOfEvents(1);
      endUsersRepository.save(targetEndUser);
    } else {
      targetEndUser.setNumberOfEvents(targetEndUser.getNumberOfEvents()+1);
    }

    List<PointRule> pointRules = pointRuleRepository.findByApp(app);
    for(PointRule rule : pointRules) {
      if(rule.getEventType().equals(event.getType())) {
        /*Scale scale = scaleRepository.findByNameAndApp(rule.getScale(), app);
        UserScale userScale = userScaleRepository.findByUserAndScale(targetEndUser, scale);
        userScale.setNbPoints(userScale.getNbPoints() + rule.getDefaultNbPoints());*/
      }
    }

  }

}
