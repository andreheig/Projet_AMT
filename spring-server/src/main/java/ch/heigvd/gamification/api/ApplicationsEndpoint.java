package ch.heigvd.gamification.api;

import ch.heigvd.gamification.api.dto.ApplicationRegistration;
import ch.heigvd.gamification.api.dto.ApplicationSummary;
import ch.heigvd.gamification.api.dto.ApplicationUpdate;
import ch.heigvd.gamification.dao.ApplicationRepository;
import ch.heigvd.gamification.model.Application;
import java.util.ArrayList;
import java.util.List;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Olivier Liechti
 */
@RestController
public class ApplicationsEndpoint implements ApplicationsApi {

  private ApplicationRepository applicationsRepository;

  public ApplicationsEndpoint(ApplicationRepository applicationsRepository) {
    this.applicationsRepository = applicationsRepository;
  }

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

  public ResponseEntity<Void> postApplication(@RequestBody ApplicationRegistration registration) {
    Application newApplication = new Application();
    // TODO: test à implémenter pour savoir si on a les champs correct (sinon renvoi code http correspondant)
    newApplication.setName(registration.getApplicationName());
    String keyUUID = registration.getApplicationKeyUUID();
    newApplication.setKeyUUID(keyUUID);
    String secretUUID = registration.getApplicationSecretUUID();
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
