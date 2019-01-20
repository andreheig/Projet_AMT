package ch.heigvd.gamification.api;

import ch.heigvd.gamification.api.dto.Credentials;
import ch.heigvd.gamification.api.dto.Token;
import ch.heigvd.gamification.dao.ApplicationRepository;
import ch.heigvd.gamification.model.Application;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthEndpoint implements AuthApi {

  @Autowired
  private ApplicationRepository applicationsRepository;

  @Override
  public ResponseEntity authenticateApplicationAndGetToken(@RequestBody Credentials body) {
    String applicationName = body.getApplicationName();
    String password = body.getPassword();
    Application application = applicationsRepository.findByName(applicationName); // We are not authenticating yet!
    if (application != null) {
      Token token = new Token();
      token.setApplicationName(application.getName());
      return ResponseEntity.ok(token);
    } else {
      return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }
  }

}
