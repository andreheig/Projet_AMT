package ch.heigvd.gamification.api;

import ch.heigvd.gamification.api.dto.ApplicationsBadgesSummary;
import ch.heigvd.gamification.api.dto.RegistrationBadges;
import ch.heigvd.gamification.api.dto.RegistrationRule;
import ch.heigvd.gamification.dao.ApplicationRepository;
import ch.heigvd.gamification.dao.EndUserRepository;
import ch.heigvd.gamification.services.EventProcessor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
public class RulesEndpoint implements RulesApi {

  private final ApplicationRepository applicationsRepository;
  private final EventProcessor eventProcessor;

  public RulesEndpoint(ApplicationRepository applicationsRepository, EndUserRepository endUsersRepository, EventProcessor eventProcessor) {
    this.applicationsRepository = applicationsRepository;
    this.eventProcessor = eventProcessor;
  }

  @Override
  public ResponseEntity<Void> postRule(String idApplication, String uuid, @Valid RegistrationRule body) {
    return null;
  }
}
