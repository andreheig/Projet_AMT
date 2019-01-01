package ch.heigvd.gamification.api;

import ch.heigvd.gamification.api.dto.ApplicationsScalesSummary;
import ch.heigvd.gamification.api.dto.RegistrationScale;
import ch.heigvd.gamification.dao.ApplicationRepository;
import ch.heigvd.gamification.dao.BadgeRepository;
import ch.heigvd.gamification.dao.ScaleRepository;
import ch.heigvd.gamification.model.Application;
import ch.heigvd.gamification.model.Badge;
import ch.heigvd.gamification.model.Scale;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ScalesEndpoint implements ScalesApi {

  private final ScaleRepository scaleRepository;
  private final ApplicationRepository applicationRepository;

  public ScalesEndpoint(ScaleRepository scaleRepository, ApplicationRepository applicationrepository) {
    this.scaleRepository = scaleRepository;
    this.applicationRepository = applicationrepository;
  }


  @Override
  public ResponseEntity<List<ApplicationsScalesSummary>> findApplicationScales(String uuid) {
    List<ApplicationsScalesSummary> result = new ArrayList<>();
    Application app = applicationRepository.findByKeyUUID(uuid);
    // TODO: test à implémenter pour savoir si on a une application (sinon renvoi code http correspondant)
    if(app.equals(null)){
      return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
    }
    // TODO: test à implémenter pour savoir si on a un badge (sinon renvoi code http correspondant)
    for (Scale scale : app.getScales()){
      ApplicationsScalesSummary rs = new ApplicationsScalesSummary();
      rs.setScaleName(scale.getName());
      rs.setScaleMax((int)scale.getMax());
      result.add(rs);
    }
    return ResponseEntity.ok(result);
  }

  @Override
  public ResponseEntity<Void> postScale(String uuid, @RequestBody RegistrationScale body) {
    Scale newScale = new Scale();
    // TODO: test à implémenter pour savoir si on a un nom (sinon renvoi code http correspondant)
    newScale.setName(body.getScaleName());
    newScale.setMax(body.getScaleMax());
    Application applicationNewScale = applicationRepository.findByKeyUUID(uuid);
    try {
      // TODO: test à implémenter pour savoir si on a une application (sinon renvoi code http correspondant)
      // TODO: test à implémenter pour savoir si le secret match celui de l'application (sinon renvoi code http correspondant)
      applicationNewScale.getScales().add(newScale);
      scaleRepository.save(newScale);
      applicationRepository.save(applicationNewScale);
      return ResponseEntity.status(HttpStatus.CREATED).build();
    } catch (DataIntegrityViolationException e) {
      System.out.println(e.getMessage());
      System.out.println(e.getClass());
      return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).build();
    }
  }
}
