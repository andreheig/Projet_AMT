package ch.heigvd.gamification.api;

import ch.heigvd.gamification.api.dto.ApplicationsBadgesSummary;
import ch.heigvd.gamification.api.dto.RegistrationBadges;
import ch.heigvd.gamification.dao.ApplicationRepository;
import ch.heigvd.gamification.dao.BadgeRepository;
import ch.heigvd.gamification.dao.EndUserRepository;
import ch.heigvd.gamification.model.Application;
import ch.heigvd.gamification.model.Badge;
import ch.heigvd.gamification.services.EventProcessor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class BadgesEndpoint implements BadgesApi {

  private final BadgeRepository badgeRepository;
  private final ApplicationRepository applicationRepository;

  public BadgesEndpoint(BadgeRepository badgeRepository, ApplicationRepository applicationrepository) {
    this.badgeRepository = badgeRepository;
    this.applicationRepository = applicationrepository;
  }


  @Override
  public ResponseEntity<List<ApplicationsBadgesSummary>> findApplicationBadges(String uuid) {
    List<ApplicationsBadgesSummary> result = new ArrayList<>();
    Application app = applicationRepository.findByKeyUUID(uuid);
    if(app.equals(null)){
      return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
    }
    for (Badge badge : app.getBadges()){
      //System.out.println(applicationRepository.findByKeyUUID(uuid).getName());
      ApplicationsBadgesSummary rs = new ApplicationsBadgesSummary();
      rs.setBadgesName(badge.getName());
      //System.out.println(badge.getName());
      result.add(rs);
    }
    return ResponseEntity.ok(result);
  }

  @Override
  public ResponseEntity<Void> postBadge(String uuid, @RequestBody RegistrationBadges body) {
    Badge newBadge = new Badge();
    newBadge.setName(body.getBadgeName());
    Application applicationNewBadge = applicationRepository.findByKeyUUID(uuid);
    try {
      //applicationNewBadge.setBadge(newBadge);
      applicationNewBadge.getBadges().add(newBadge);
      badgeRepository.save(newBadge);
      applicationRepository.save(applicationNewBadge);
      return ResponseEntity.status(HttpStatus.CREATED).build();
    } catch (DataIntegrityViolationException e) {
      System.out.println(e.getMessage());
      System.out.println(e.getClass());
      return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).build();
    }
  }
}
