package ch.heigvd.gamification.api;

import ch.heigvd.gamification.api.dto.ApplicationsBadgesSummary;
import ch.heigvd.gamification.api.dto.ApplicationsScalesSummary;
import ch.heigvd.gamification.api.dto.User;
import ch.heigvd.gamification.dao.ApplicationRepository;
import ch.heigvd.gamification.dao.EndUserRepository;
import ch.heigvd.gamification.dao.UserBadgeRepository;
import ch.heigvd.gamification.dao.UserScaleRepository;
import ch.heigvd.gamification.model.Application;
import ch.heigvd.gamification.model.EndUser;
import ch.heigvd.gamification.model.UserBadge;
import ch.heigvd.gamification.model.UserScale;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UsersEndpoint implements UsersApi {

  @Autowired
  private ApplicationRepository applicationRepository;
  @Autowired
  private EndUserRepository endUserRepository;
  @Autowired
  private UserBadgeRepository userBadgeRepository;
  @Autowired
  private UserScaleRepository userScaleRepository;

  @Override
  public ResponseEntity findUserById(@ApiParam(value = "token that identifies the application sending the request" ,required=true )
                                       @RequestHeader(value="X-Gamification-Token", required=true) String xGamificationToken,
                                       @ApiParam(value = "id of the user to fetch",required=true ) @PathVariable("id") String id) {
    String targetApplicationName = xGamificationToken;
    Application targetApplication = applicationRepository.findByName(targetApplicationName);
    if (targetApplication == null || id == null) {
      return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).build();
    }
    EndUser endUser = endUserRepository.findByAppNameAndIdInGamifiedApplication(targetApplicationName, id);
    User user = new User();
    user.setUserId(endUser.getIdInGamifiedApplication());
    user.setNumberOfEvents(endUser.getNumberOfEvents());
    user.setName(endUser.getName());

    List<ApplicationsBadgesSummary> badges = new ArrayList<>();
    for(UserBadge badge: userBadgeRepository.findByUserIdInGamifiedApplication(id)){
      ApplicationsBadgesSummary b = new ApplicationsBadgesSummary();
      b.setBadgesName(badge.getBadge().getName());
      badges.add(b);
    }

    List<ApplicationsScalesSummary> scales = new ArrayList<>();
    for(UserScale scale : userScaleRepository.findByUser(endUser)){
      ApplicationsScalesSummary s = new ApplicationsScalesSummary();
      s.setScaleName(scale.getScale().getName());
      s.setScaleMax(scale.getNbPoints());
      scales.add(s);
    }

    user.setBadges(badges);
    user.setScales(scales);

    return ResponseEntity.ok(user);
  }
}
