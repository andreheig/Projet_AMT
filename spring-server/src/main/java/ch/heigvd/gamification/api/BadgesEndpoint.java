package ch.heigvd.gamification.api;

import ch.heigvd.gamification.api.dto.ApplicationsBadgesSummary;
import ch.heigvd.gamification.api.dto.RegistrationBadge;
import ch.heigvd.gamification.api.dto.UpdateBadge;
import ch.heigvd.gamification.dao.ApplicationRepository;
import ch.heigvd.gamification.dao.BadgeRepository;
import ch.heigvd.gamification.model.Application;
import ch.heigvd.gamification.model.Badge;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class BadgesEndpoint implements ch.heigvd.gamification.api.BadgesApi {

  @Autowired
  private BadgeRepository badgeRepository;
  @Autowired
  private ApplicationRepository applicationRepository;

  @Override
  public ResponseEntity<List<ApplicationsBadgesSummary>> findApplicationBadges(@ApiParam(value = "uuid de l'application à trouver",required=true ) @PathVariable("uuid") String uuid){
    List<ApplicationsBadgesSummary> result = new ArrayList<>();
    Application app = applicationRepository.findByKeyUUID(uuid);
    // TODO: test à implémenter pour savoir si on a une application (sinon renvoi code http correspondant) => André OK
    if (app == null) {
      return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
    }
    // TODO: test à implémenter pour savoir si on a un badge (sinon renvoi code http correspondant)?
    for (Badge badge : badgeRepository.findByApp(app)) {
      ApplicationsBadgesSummary rs = new ApplicationsBadgesSummary();
      rs.setBadgesName(badge.getName());
      result.add(rs);
    }
    return ResponseEntity.ok(result);
  }

  @Override
  public ResponseEntity<Void> postBadge(@ApiParam(value = "uuid of the application to fetch",required=true ) @PathVariable("uuid") String uuid,
                                        @ApiParam(value = "The info required to register an application's badge" ,required=true ) @RequestBody RegistrationBadge body) {
    Badge newBadge = new Badge();
    // TODO: test à implémenter pour savoir si on a un nom (sinon renvoi code http correspondant) => André OK
    if (body.getBadgeName().isEmpty()) {
      return ResponseEntity.status(HttpStatus.METHOD_NOT_ALLOWED).build();
    }

    newBadge.setName(body.getBadgeName());
    Application applicationNewBadge = applicationRepository.findByKeyUUID(uuid);
    try {

      // TODO: test à implémenter pour savoir si on a une application (sinon renvoi code http correspondant) => André OK
      if (false || applicationNewBadge == null) {
        return ResponseEntity.status(HttpStatus.METHOD_NOT_ALLOWED).build();
      }

      // TODO: test à implémenter pour savoir si le secret match celui de l'application (sinon renvoi code http correspondant) => André OK
      if (!applicationNewBadge.getSecretUUID().equalsIgnoreCase(body.getApplicationSecret())) {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
      }

      // TODO: on check si le badge existe déjà dans l'aplication
      if(checkDuplicate(applicationNewBadge, newBadge) == HttpStatus.UNPROCESSABLE_ENTITY){
        return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).build();
      }
      newBadge.setApp(applicationNewBadge);
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
  public ResponseEntity<Void> updateBadge(@ApiParam(value = "uuid of the application to fetch",required=true ) @PathVariable("uuid") String uuid,
                                          @ApiParam(value = "The info required to update an application's badge" ,required=true ) @RequestBody UpdateBadge body) {
    Application app = applicationRepository.findByKeyUUID(uuid);
    Badge updateBadge = badgeRepository.findByNameAndApp(body.getOldBadgeName(), app);
    updateBadge.setName(body.getBadgeName());
    if(checkDuplicate(app, updateBadge) == HttpStatus.UNPROCESSABLE_ENTITY){
      return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).build();
    }
    badgeRepository.save(updateBadge);
    return ResponseEntity.status(HttpStatus.OK).build();
  }

  private HttpStatus checkDuplicate(Application application, Badge badgeToCheck){
    // TODO: on check si le badge existe déjà dans l'aplication
    if(application.getBadges().size() != 0) {
      for (Badge badge : application.getBadges()) {
        if (badge.getName().equalsIgnoreCase(badgeToCheck.getName())) {
          return HttpStatus.UNPROCESSABLE_ENTITY;
        }
      }
    }
    return HttpStatus.OK;
  }
}
