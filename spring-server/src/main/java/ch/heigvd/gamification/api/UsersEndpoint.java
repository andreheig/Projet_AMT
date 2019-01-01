package ch.heigvd.gamification.api;

import ch.heigvd.gamification.api.dto.User;
import ch.heigvd.gamification.dao.ApplicationRepository;
import ch.heigvd.gamification.dao.EndUserRepository;
import ch.heigvd.gamification.model.Application;
import ch.heigvd.gamification.model.EndUser;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Olivier Liechti
 */
@RestController
public class UsersEndpoint implements UsersApi {

  private final ApplicationRepository applicationRepository;
  private final EndUserRepository endUserRepository;

  public UsersEndpoint(ApplicationRepository applicationRepository, EndUserRepository endUserRepository) {
    this.applicationRepository = applicationRepository;
    this.endUserRepository = endUserRepository;
  }

  @Override
  public ResponseEntity findUserById(@PathVariable("id") String userId) {
    if (userId == null) {
      return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).build();
    }
    EndUser endUser = endUserRepository.findByIdInGamifiedApplication(userId);
    User user = new User();
    user.setUserId(endUser.getIdInGamifiedApplication());
    user.setName(endUser.getName());
    user.setNumberOfEvents(endUser.getNumberOfEvents());
    for (Application app: endUser.getApplications()) {
      user.addApplicationsItem(app.getName());
    }
    return ResponseEntity.ok(user);
  }

}
