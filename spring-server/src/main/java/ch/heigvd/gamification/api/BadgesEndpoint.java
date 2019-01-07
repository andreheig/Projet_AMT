package ch.heigvd.gamification.api;

import ch.heigvd.gamification.api.dto.ApplicationsBadgesSummary;
import ch.heigvd.gamification.api.dto.RegistrationBadge;
import ch.heigvd.gamification.api.dto.UpdateBadge;
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
    // TODO: test à implémenter pour savoir si on a une application (sinon renvoi code http correspondant) => André OK
    if (app == null) {
      return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
    }
    // TODO: test à implémenter pour savoir si on a un badge (sinon renvoi code http correspondant)?
    for (Badge badge : app.getBadges()) {
      ApplicationsBadgesSummary rs = new ApplicationsBadgesSummary();
      rs.setBadgesName(badge.getName());
      result.add(rs);
    }
    return ResponseEntity.ok(result);
  }

  @Override
  public ResponseEntity<Void> postBadge(String uuid, @RequestBody RegistrationBadge body) {
    Badge newBadge = new Badge();
    // TODO: test à implémenter pour savoir si on a un nom (sinon renvoi code http correspondant) => André OK
    if (body.getBadgeName().isEmpty()) {
      return ResponseEntity.status(HttpStatus.METHOD_NOT_ALLOWED).build();
    }
    newBadge.setName(body.getBadgeName());
    Application applicationNewBadge = applicationRepository.findByKeyUUID(uuid);
    try {
      // TODO: test à implémenter pour savoir si on a une application (sinon renvoi code http correspondant) => André OK
      // TODO: test à implémenter pour savoir si le secret match celui de l'application (sinon renvoi code http correspondant) => André OK
      if (applicationNewBadge == null) {
        return ResponseEntity.status(HttpStatus.METHOD_NOT_ALLOWED).build();
      }
      if (!applicationNewBadge.getSecretUUID().equalsIgnoreCase(body.getApplicationSecret())) {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
      }
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

  @Override
  public ResponseEntity<Void> updateBadge(String uuid, UpdateBadge body) {
    Application app = applicationRepository.findByKeyUUID(uuid);
    Badge updateBadge = badgeRepository.findByNameAndApplication(body.getOldBadgeName(), app);
    updateBadge.setName(body.getBadgeName());
    badgeRepository.save(updateBadge);
    return ResponseEntity.status(HttpStatus.OK).build();
  }
}
