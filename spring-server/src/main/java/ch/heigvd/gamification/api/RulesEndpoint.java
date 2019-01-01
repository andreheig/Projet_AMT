package ch.heigvd.gamification.api;

import ch.heigvd.gamification.api.dto.ApplicationsBadgesSummary;
import ch.heigvd.gamification.api.dto.ApplicationsRulesSummary;
import ch.heigvd.gamification.api.dto.RegistrationBadge;
import ch.heigvd.gamification.api.dto.RegistrationRule;
import ch.heigvd.gamification.dao.ApplicationRepository;
import ch.heigvd.gamification.dao.EndUserRepository;
import ch.heigvd.gamification.dao.RuleRepository;
import ch.heigvd.gamification.model.Application;
import ch.heigvd.gamification.model.Rule;
import ch.heigvd.gamification.services.EventProcessor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
public class RulesEndpoint implements RulesApi {

  private final ApplicationRepository applicationsRepository;
  private final RuleRepository ruleRepository;
  private final EventProcessor eventProcessor;

  public RulesEndpoint(ApplicationRepository applicationsRepository, RuleRepository ruleRepository, EndUserRepository endUsersRepository, EventProcessor eventProcessor) {
    this.applicationsRepository = applicationsRepository;
    this.ruleRepository = ruleRepository;
    this.eventProcessor = eventProcessor;
  }

  @Override
  public ResponseEntity<List<ApplicationsRulesSummary>> findApplicationRules(String uuid){
    List<ApplicationsRulesSummary> result = new ArrayList<>();
    Application app = applicationsRepository.findByKeyUUID(uuid);
    // TODO: test à implémenter pour savoir si on a une application (sinon renvoi code http correspondant)
    if(app.equals(null)){
      return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
    }
    // TODO: test à implémenter pour savoir si on a une règle (sinon renvoi code http correspondant)
    for (Rule rule : app.getRules()){
      ApplicationsRulesSummary rs = new ApplicationsRulesSummary();
      rs.setRulesName(rule.getName());
      result.add(rs);
    }
    return ResponseEntity.ok(result);
  }

  @Override
  public ResponseEntity<Void> postRule(String uuid, @RequestBody RegistrationRule body) {
    Rule newRule = new Rule();
    // TODO: test à implémenter pour savoir si on a un nom (sinon renvoi code http correspondant)
    newRule.setName(body.getRuleName());
    Application applicationNewRule = applicationsRepository.findByKeyUUID(uuid);
    try {
      // TODO: test à implémenter pour savoir si on a une application (sinon renvoi code http correspondant)
      // TODO: test à implémenter pour savoir si le secret match celui de l'application (sinon renvoi code http correspondant)
      applicationNewRule.getRules().add(newRule);
      ruleRepository.save(newRule);
      applicationsRepository.save(applicationNewRule);
      return ResponseEntity.status(HttpStatus.CREATED).build();
    } catch (DataIntegrityViolationException e) {
      System.out.println(e.getMessage());
      System.out.println(e.getClass());
      return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).build();
    }
  }
}
