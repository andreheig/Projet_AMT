package ch.heigvd.gamification.api;

import ch.heigvd.gamification.api.dto.ApplicationsBadgesSummary;
import ch.heigvd.gamification.api.dto.RegistrationBadges;
import ch.heigvd.gamification.dao.ApplicationRepository;
import ch.heigvd.gamification.dao.EndUserRepository;
import ch.heigvd.gamification.model.Application;
import ch.heigvd.gamification.services.EventProcessor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class BadgesEndpoint implements BadgesApi {

  private final ApplicationRepository applicationsRepository;
  private final EventProcessor eventProcessor;

  public BadgesEndpoint(ApplicationRepository applicationsRepository, EndUserRepository endUsersRepository, EventProcessor eventProcessor) {
    this.applicationsRepository = applicationsRepository;
    this.eventProcessor = eventProcessor;
  }


  @Override
  public ResponseEntity<List<ApplicationsBadgesSummary>> findApplicationBadgesByUuid(String uuid) {
    List<ApplicationsBadgesSummary> result = new ArrayList<>();
    Application applicationBadgeUpdate = null;
    for (Application application : applicationsRepository.findAll()) {
      if (application.getKeyUUID().equalsIgnoreCase(uuid)) {
        applicationBadgeUpdate = new Application();
        applicationBadgeUpdate.setAppId(application.getAppId());
        applicationBadgeUpdate.setName(application.getName());
        applicationBadgeUpdate.setKeyUUID(application.getKeyUUID());
        applicationBadgeUpdate.setSecretUUID(application.getSecretUUID());
      }
    }
    if(applicationBadgeUpdate != null) {

    }

    return ResponseEntity.ok(result);
  }

  @Override
  public ResponseEntity<Void> postBadge(String uuid, @RequestBody RegistrationBadges body) {
    return null;
  }
}
