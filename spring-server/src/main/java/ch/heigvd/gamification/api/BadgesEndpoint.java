package ch.heigvd.gamification.api;

import ch.heigvd.gamification.api.dto.ApplicationsBadgesSummary;
import ch.heigvd.gamification.api.dto.Event;
import ch.heigvd.gamification.api.dto.RegistrationBadges;
import ch.heigvd.gamification.dao.ApplicationRepository;
import ch.heigvd.gamification.dao.EndUserRepository;
import ch.heigvd.gamification.model.Application;
import ch.heigvd.gamification.services.EventProcessor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
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
  public ResponseEntity<List<ApplicationsBadgesSummary>> findApplicationBadgesByUuid(String idApplication, String uuid) {
    return null;
  }

  @Override
  public ResponseEntity<Void> postBadge(String idApplication, String uuid, @RequestBody RegistrationBadges body) {
    return null;
  }
}
