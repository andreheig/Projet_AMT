package ch.heigvd.gamification.api;

import ch.heigvd.gamification.api.dto.Event;
import ch.heigvd.gamification.dao.ApplicationRepository;
import ch.heigvd.gamification.dao.EndUserRepository;
import ch.heigvd.gamification.model.Application;
import ch.heigvd.gamification.model.EndUser;
import ch.heigvd.gamification.services.EventProcessor;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EventsEndpoint implements EventsApi {

  @Autowired
  private ApplicationRepository applicationsRepository;
  @Autowired
  private EventProcessor eventProcessor;

  @Override
  public ResponseEntity reportEvent(@ApiParam(value = "The event that occured in the realm of the gamified application" ,required=true ) @RequestBody Event event) {
    System.out.println(event);
    String targetEndUserId = event.getUserId();
    Application targetApplication = applicationsRepository.findByName(event.getApplicationName());
    if (targetApplication == null || targetEndUserId == null) {
      return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).build();
    }
    eventProcessor.processEvent(targetApplication, event);
    return ResponseEntity.ok().build();
  }


}