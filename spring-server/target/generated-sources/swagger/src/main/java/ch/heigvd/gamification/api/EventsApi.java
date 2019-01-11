package ch.heigvd.gamification.api;

import ch.heigvd.gamification.api.dto.Event;

import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2019-01-11T23:16:27.537+01:00")

@Api(value = "events", description = "the events API")
public interface EventsApi {

    @ApiOperation(value = "", notes = "Report that a new event has happened in the gamified application", response = Event.class, tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 202, message = "The platform has accepted the event and will process it (asynchronously)", response = Event.class),
        @ApiResponse(code = 405, message = "Invalid input", response = Event.class) })
    @RequestMapping(value = "/events",
        consumes = { "application/json" },
        method = RequestMethod.POST)
    ResponseEntity<Event> reportEvent(

@ApiParam(value = "The event that occured in the realm of the gamified application" ,required=true ) @RequestBody Event event

);

}
