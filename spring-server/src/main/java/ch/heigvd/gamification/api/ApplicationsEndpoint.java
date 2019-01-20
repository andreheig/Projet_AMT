package ch.heigvd.gamification.api;

import ch.heigvd.gamification.api.dto.ApplicationRegistration;
import ch.heigvd.gamification.api.dto.ApplicationSummary;
import ch.heigvd.gamification.api.dto.ApplicationUpdate;
import ch.heigvd.gamification.dao.ApplicationRepository;
import ch.heigvd.gamification.model.Application;
import java.util.ArrayList;
import java.util.List;

import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApplicationsEndpoint implements ApplicationsApi {

  @Autowired
  private ApplicationRepository applicationsRepository;


  public ResponseEntity<List<ApplicationSummary>> getAllApplications() {
    List<ApplicationSummary> result = new ArrayList<>();
    for (Application application : applicationsRepository.findAll()) {
      ApplicationSummary rs = new ApplicationSummary();
      rs.setApplicationName(application.getName());
      rs.setApplicationKey(application.getKeyUUID());
      result.add(rs);
    }
    return ResponseEntity.ok(result);
  }

  ;

  public ResponseEntity<Void> postApplication(@ApiParam(value = "The info required to register an application" ,required=true ) @RequestBody ApplicationRegistration body) {
    Application newApplication = new Application();
    // TODO: test à implémenter pour savoir si on a les champs correct (sinon renvoi code http correspondant)
    newApplication.setName(body.getApplicationName());
    String keyUUID = body.getApplicationKeyUUID();
    newApplication.setKeyUUID(keyUUID);
    String secretUUID = body.getApplicationSecretUUID();
    newApplication.setSecretUUID(secretUUID);
    try {
      applicationsRepository.save(newApplication);
      return ResponseEntity.status(HttpStatus.CREATED).build();
    } catch (DataIntegrityViolationException e) {
      System.out.println(e.getMessage());
      System.out.println(e.getClass());
      return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).build();
    }
  }

  public ResponseEntity<Void> updateApplication(@RequestBody ApplicationUpdate update) {
    // TODO: valider champs
    Application updatedApplication = applicationsRepository.findByKeyUUID(update.getApplicationKey());
    updatedApplication.setName(update.getApplicationNewName());
    applicationsRepository.save(updatedApplication);
    return ResponseEntity.status(HttpStatus.OK).build();
  }

}
