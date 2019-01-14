package ch.heigvd.gamification.api;

import ch.heigvd.gamification.api.dto.*;
import ch.heigvd.gamification.dao.ApplicationRepository;
import ch.heigvd.gamification.dao.EndUserRepository;
import ch.heigvd.gamification.dao.PointRuleRepository;
import ch.heigvd.gamification.dao.ScaleRepository;
import ch.heigvd.gamification.model.Application;
import ch.heigvd.gamification.model.PointRule;
import ch.heigvd.gamification.model.PointRuleParam;
import ch.heigvd.gamification.services.EventProcessor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class RulesEndpoint implements RulesApi {

  private final ApplicationRepository applicationsRepository;
  private final PointRuleRepository pointRuleRepository;
  private final ScaleRepository scaleRepository;
  private final EventProcessor eventProcessor;

  public RulesEndpoint(ApplicationRepository applicationsRepository,
                       PointRuleRepository pointRuleRepository,
                       EndUserRepository endUsersRepository,
                       ScaleRepository scaleRepository,
                       EventProcessor eventProcessor) {
    this.applicationsRepository = applicationsRepository;
    this.pointRuleRepository = pointRuleRepository;
    this.scaleRepository = scaleRepository;
    this.eventProcessor = eventProcessor;
  }

  @Override
  public ResponseEntity<Void> createPointRule(String uuid, PointRuleDto body) {
    // TODO: test à implémenter pour savoir si on a un nom (sinon renvoi code http correspondant) => André OK
    if(body.getName().isEmpty() || uuid.isEmpty()){
      return ResponseEntity.status(HttpStatus.METHOD_NOT_ALLOWED).build();
    }

    Application app = applicationsRepository.findByKeyUUID(uuid);
    try {
      // TODO: test à implémenter pour savoir si on a une application (sinon renvoi code http correspondant) => André OK
      // TODO: test à implémenter pour savoir si le secret match celui de l'application (sinon renvoi code http correspondant) => André OK
      if(app == null){
        return ResponseEntity.status(HttpStatus.METHOD_NOT_ALLOWED).build();
      }
      if(!app.getSecretUUID().equalsIgnoreCase(body.getApplicationSecret())){
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
      }

      PointRule newRule = dtoToModel(body, app);
      app.getPointRules().add(newRule);
      pointRuleRepository.save(newRule);
      applicationsRepository.save(app);
      return ResponseEntity.status(HttpStatus.CREATED).build();

    } catch (DataIntegrityViolationException e) {
      System.out.println(e.getMessage());
      System.out.println(e.getClass());
      return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).build();
    }
  }

  @Override
  public ResponseEntity<List<PointRuleDto>> findPointRules(String uuid) {
    List<PointRuleDto> result = new ArrayList<>();
    // TODO: test pour savoir si le uuid est correct?
    Application app = applicationsRepository.findByKeyUUID(uuid);
    // TODO: test à implémenter pour savoir si on a une application (sinon renvoi code http correspondant)
    if(app == null){
      return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
    }
    // TODO: test à implémenter pour savoir si on a une règle ?
    for (PointRule rule : app.getPointRules()) {
      result.add(modelToDto(rule));
    }
    return ResponseEntity.ok(result);
  }

  @Override
  public ResponseEntity<Void> updatePointRule(String uuid, PointRuleUpdateDto body) {
    Application app = applicationsRepository.findByKeyUUID(uuid);
    PointRule updatedRule = pointRuleRepository.findByNameAndApp(body.getOldName(), app);
    updatedRule.setName(body.getNewName());
    updatedRule.setEventType(body.getNewEventType());
    updatedRule.setScale(scaleRepository.findByNameAndApp(body.getNewScale(), app));
    updatedRule.setDefaultNbPoints(body.getNewDefaultNbPoints());
    List<PointRuleParam> params = new ArrayList<>();
    for(PointRuleParamDto paramDto: body.getNewPointRuleParams()) {
      params.add(dtoToModel(paramDto));
    }
    updatedRule.setPointRuleParams(params);
    pointRuleRepository.save(updatedRule);
    return ResponseEntity.status(HttpStatus.OK).build();
  }

  @Override
  public ResponseEntity<Void> createBadgeThresholdRule(String uuid, BadgeThresholdRuleDto body) {
    return null;
  }

  @Override
  public ResponseEntity<List<BadgeThresholdRuleDto>> findBadgeThresholdRules(String uuid) {
    return null;
  }

  @Override
  public ResponseEntity<Void> updateBadgeThresholdRule(String uuid, BadgeThresholdRuleUpdateDto body) {
    return null;
  }

  @Override
  public ResponseEntity<Void> createBadgeTimeRangeRule(String uuid, BadgeTimeRangeRuleDto body) {
    return null;
  }

  @Override
  public ResponseEntity<List<BadgeTimeRangeRuleDto>> findBadgeTimeRangeRules(String uuid) {
    return null;
  }

  @Override
  public ResponseEntity<Void> updateBadgeTimeRangeRule(String uuid, BadgeTimeRangeRuleUpdateDto body) {
    return null;
  }

  /** Converts a <code>PointRule</code> to a <code>PointRuleDto</code>*/
  public PointRuleDto modelToDto(PointRule rule) {
    PointRuleDto ruleDto = new PointRuleDto();
    ruleDto.setName(rule.getName());
    ruleDto.setEventType(rule.getEventType());
    ruleDto.setScale(rule.getScale().toString());
    ruleDto.setDefaultNbPoints(rule.getDefaultNbPoints());

    List<PointRuleParamDto> ruleParamsDto= new ArrayList<>();
    for(PointRuleParam param : rule.getPointRuleParams()) {
      PointRuleParamDto paramDto = modelToDto(param);
      ruleParamsDto.add(paramDto);
    }
    return ruleDto;
  }

  /** Converts a <code>PointRuleParam</code> to a <code>PointRuleParamDto</code>*/
  public PointRuleParamDto modelToDto(PointRuleParam param) {
    PointRuleParamDto paramDto = new PointRuleParamDto();
    paramDto.setParamName(param.getParamName());
    paramDto.setParamValue(param.getParamValue());
    paramDto.setNbPoints(param.getNbPoints());
    return paramDto;
  }

  /** Converts a <code>PointRuleDto</code> to a <code>PointRule</code>*/
  public PointRule dtoToModel(PointRuleDto ruleDto, Application app) {
    PointRule rule = new PointRule();
    rule.setName(ruleDto.getName());
    rule.setEventType(ruleDto.getEventType());
    rule.setScale(scaleRepository.findByNameAndApp(ruleDto.getScale(), app));
    rule.setDefaultNbPoints(ruleDto.getDefaultNbPoints());

    List<PointRuleParam> ruleParams= new ArrayList<>();
    for(PointRuleParamDto paramDto : ruleDto.getPointRuleParams()) {
      PointRuleParam param = dtoToModel(paramDto);
      param.setPointRule(rule);
      ruleParams.add(param);
    }
    return rule;
  }

  /** Converts a <code>PointRuleParamDto</code> to a <code>PointRuleParam</code>*/
  public PointRuleParam dtoToModel(PointRuleParamDto paramDto) {
    PointRuleParam param = new PointRuleParam();
    param.setParamName(paramDto.getParamName());
    param.setParamValue(paramDto.getParamValue());
    param.setNbPoints(paramDto.getNbPoints());
    return param;
  }
}
