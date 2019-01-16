package ch.heigvd.gamification.api;

import ch.heigvd.gamification.api.dto.*;
import ch.heigvd.gamification.dao.*;
import ch.heigvd.gamification.model.*;
import ch.heigvd.gamification.services.EventProcessor;
import io.swagger.annotations.ApiParam;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class RulesEndpoint implements RulesApi {

  private final ApplicationRepository applicationsRepository;
  private final PointRuleRepository pointRuleRepository;
  private final ScaleRepository scaleRepository;
  private final EventProcessor eventProcessor;
  private final BadgeRepository badgeRepository;
  private final BadgeThresholdRuleRepository badgeThresholdRuleRepository;

  public RulesEndpoint(ApplicationRepository applicationsRepository,
                       PointRuleRepository pointRuleRepository,
                       EndUserRepository endUsersRepository,
                       ScaleRepository scaleRepository,
                       BadgeRepository badgeRepository,
                       EventProcessor eventProcessor,
                       BadgeThresholdRuleRepository badgeThresholdRuleRepository) {
    this.applicationsRepository = applicationsRepository;
    this.pointRuleRepository = pointRuleRepository;
    this.scaleRepository = scaleRepository;
    this.eventProcessor = eventProcessor;
    this.badgeRepository = badgeRepository;
    this.badgeThresholdRuleRepository = badgeThresholdRuleRepository;
  }

  @Override
  public ResponseEntity<Void> createPointRule(
          @ApiParam(value = "uuid of the application to add rule",required=true ) @PathVariable("uuid") String uuid,
          @ApiParam(value = "The rule for an application" ,required=true ) @RequestBody PointRuleDto body ) {
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
  public ResponseEntity<List<PointRuleDto>> findPointRules(
          @ApiParam(value = "uuid de l'application à trouver",required=true ) @PathVariable("uuid") String uuid ) {
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
  public ResponseEntity<Void> updatePointRule(
          @ApiParam(value = "uuid of the application to update rule",required=true ) @PathVariable("uuid") String uuid,
          @ApiParam(value = "The rule for an application" ,required=true ) @RequestBody PointRuleUpdateDto body) {
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
  public ResponseEntity<Void> createBadgeThresholdRule(
          @ApiParam(value = "uuid of the application to add rule",required=true ) @PathVariable("uuid") String uuid,
          @ApiParam(value = "The rule for an application" ,required=true ) @RequestBody BadgeThresholdRuleDto body ) {
    Application app = applicationsRepository.findByKeyUUID(uuid);
    // on ne trouve pas l'application
    if(app == null){
      return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
    // Le secret n'est pas le même
    if(!app.getSecretUUID().equalsIgnoreCase(body.getApplicationSecret())){
      return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }
    // On ne trouve pas le badge dans l'application
    for (Badge badge:app.getBadges()) {
     if (badge.getName().equalsIgnoreCase(body.getBadge())){
       // on a le même nom de badge
       for(Scale scale: app.getScales()){
         if(scale.getName().equalsIgnoreCase(body.getScale())){
           // on a un bon nom de scale
            BadgeThresholdRule newBadgeThresholdRule = new BadgeThresholdRule();
            newBadgeThresholdRule.setApp(app);
            newBadgeThresholdRule.setBadge(badge);
            newBadgeThresholdRule.setName(body.getName());
            newBadgeThresholdRule.setScale(scale);
            newBadgeThresholdRule.setThreshold(body.getThreshold());
            badgeThresholdRuleRepository.save(newBadgeThresholdRule);
            applicationsRepository.save(app);
           return ResponseEntity.status(HttpStatus.CREATED).build();
         }
       }
     }

    }
    return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
  }

  @Override
  public ResponseEntity<List<BadgeThresholdRuleDto>> findBadgeThresholdRules(
          @ApiParam(value = "uuid de l'application à trouver",required=true ) @PathVariable("uuid") String uuid ) {
    Application app = applicationsRepository.findByKeyUUID(uuid);
    // on ne trouve pas l'application
    if(app == null){
      return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
    List<BadgeThresholdRuleDto> result = new ArrayList<>();
    for(BadgeThresholdRule rule: badgeThresholdRuleRepository.findByApp(app)){
      BadgeThresholdRuleDto rs = new BadgeThresholdRuleDto();
      rs.setName(rule.getName());
      rs.setBadge(rule.getBadge().getName());
      rs.setScale(rule.getScale().getName());
      rs.setThreshold(rule.getThreshold());
      result.add(rs);
    }
    return ResponseEntity.ok(result);
  }

  @Override
  public ResponseEntity<Void> updateBadgeThresholdRule(
          @ApiParam(value = "uuid of the application to update rule",required=true ) @PathVariable("uuid") String uuid,
          @ApiParam(value = "The rule for an application" ,required=true ) @RequestBody BadgeThresholdRuleUpdateDto body ) {
    return null;
  }

  @Override
  public ResponseEntity<Void> createBadgeTimeRangeRule(
          @ApiParam(value = "uuid of the application to add rule",required=true ) @PathVariable("uuid") String uuid,
          @ApiParam(value = "The rule for an application" ,required=true ) @RequestBody BadgeTimeRangeRuleDto body ) {
    return null;
  }

  @Override
  public ResponseEntity<List<BadgeTimeRangeRuleDto>> findBadgeTimeRangeRules(
          @ApiParam(value = "uuid de l'application à trouver",required=true ) @PathVariable("uuid") String uuid) {
    return null;
  }

  @Override
  public ResponseEntity<Void> updateBadgeTimeRangeRule(
          @ApiParam(value = "uuid of the application to update rule",required=true ) @PathVariable("uuid") String uuid,
          @ApiParam(value = "The rule for an application" ,required=true ) @RequestBody BadgeTimeRangeRuleUpdateDto body) {
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
