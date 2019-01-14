package ch.heigvd.gamification.api;

import ch.heigvd.gamification.api.dto.User;
import ch.heigvd.gamification.dao.ApplicationRepository;
import ch.heigvd.gamification.dao.EndUserRepository;
import ch.heigvd.gamification.model.Application;
import ch.heigvd.gamification.model.EndUser;
import io.swagger.annotations.ApiParam;
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
  public ResponseEntity findUserById(@ApiParam(value = "token that identifies the application sending the request" ,required=true )
                                       @RequestHeader(value="X-Gamification-Token", required=true) String xGamificationToken,
                                       @ApiParam(value = "id of the user to fetch",required=true ) @PathVariable("id") String id) {
    String targetApplicationName = xGamificationToken;
    Application targetApplication = applicationRepository.findByName(targetApplicationName);
    if (targetApplication == null || id == null) {
      return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).build();
    }
    EndUser endUser = endUserRepository.findByAppNameAndIdInGamifiedApplication(targetApplicationName, id);
    User user = new User();
    user.setUserId(endUser.getIdInGamifiedApplication());
    user.setNumberOfEvents(endUser.getNumberOfEvents());
    return ResponseEntity.ok(user);
  }

}
