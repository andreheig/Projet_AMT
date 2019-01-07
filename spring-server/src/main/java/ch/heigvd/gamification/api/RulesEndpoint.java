package ch.heigvd.gamification.api;

import ch.heigvd.gamification.api.dto.*;
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
    // TODO: test pour savoir si le uuid est correct?
    Application app = applicationsRepository.findByKeyUUID(uuid);
    // TODO: test à implémenter pour savoir si on a une application (sinon renvoi code http correspondant)
    if(app == null){
      return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
    }
    // TODO: test à implémenter pour savoir si on a une règle ?
    for (Rule rule : app.getRules()){
      ApplicationsRulesSummary rs = new ApplicationsRulesSummary();
      rs.setRulesName(rule.getName());
      rs.setRuleType(rule.getType());
      rs.setNumberOfPoint(Integer.toString(rule.getNumberOfPoint()));
      result.add(rs);
    }
    return ResponseEntity.ok(result);
  }

  @Override
  public ResponseEntity<Void> postRule(String uuid, @RequestBody RegistrationRule body) {
    Rule newRule = new Rule();
    // TODO: test à implémenter pour savoir si on a un nom (sinon renvoi code http correspondant) => André OK
    if(body.getRuleName().isEmpty() || body.getRuleType().isEmpty() || uuid.isEmpty()){
      return ResponseEntity.status(HttpStatus.METHOD_NOT_ALLOWED).build();
    }
    newRule.setName(body.getRuleName());
    newRule.setType(body.getRuleType());
    newRule.setNumberOfPoint(body.getNumberOfPoint());
    Application applicationNewRule = applicationsRepository.findByKeyUUID(uuid);
    try {
      // TODO: test à implémenter pour savoir si on a une application (sinon renvoi code http correspondant) => André OK
      // TODO: test à implémenter pour savoir si le secret match celui de l'application (sinon renvoi code http correspondant) => André OK
      if(applicationNewRule == null){
        return ResponseEntity.status(HttpStatus.METHOD_NOT_ALLOWED).build();
      }
      if(!applicationNewRule.getSecretUUID().equalsIgnoreCase(body.getApplicationSecret())){
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
      }
      applicationNewRule.getRules().add(newRule);
      ruleRepository.save(newRule);
      //applicationsRepository.save(applicationNewRule);
      return ResponseEntity.status(HttpStatus.CREATED).build();
    } catch (DataIntegrityViolationException e) {
      System.out.println(e.getMessage());
      System.out.println(e.getClass());
      return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).build();
    }
  }

  @Override
  public ResponseEntity<Void> updateRule(String uuid, UpdateRule body) {
    Application app = applicationsRepository.findByKeyUUID(uuid);
    Rule updateRule = ruleRepository.findByNameAndApplication(body.getOldRuleName(), app);
    updateRule.setName(body.getRuleName());
    updateRule.setType(body.getRuleType());
    updateRule.setNumberOfPoint(body.getNumberOfPoint());
    ruleRepository.save(updateRule);
    return ResponseEntity.status(HttpStatus.OK).build();
  }
}
