package ch.heigvd.gamification.api;

import ch.heigvd.gamification.api.dto.ApplicationsBadgesSummary;
import ch.heigvd.gamification.api.dto.RegistrationBadge;
import ch.heigvd.gamification.api.dto.UpdateBadge;

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

@Api(value = "badges", description = "the badges API")
public interface BadgesApi {

    @ApiOperation(value = "", notes = "Retrieve badges by application uuid", response = ApplicationsBadgesSummary.class, responseContainer = "List", tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "List all badges applications", response = ApplicationsBadgesSummary.class),
        @ApiResponse(code = 404, message = "Application not found", response = ApplicationsBadgesSummary.class),
        @ApiResponse(code = 405, message = "Invalid input", response = ApplicationsBadgesSummary.class) })
    @RequestMapping(value = "/badges/{uuid}",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<List<ApplicationsBadgesSummary>> findApplicationBadges(
@ApiParam(value = "uuid de l'application à trouver",required=true ) @PathVariable("uuid") String uuid


);


    @ApiOperation(value = "", notes = "add new badge", response = Void.class, tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 201, message = "Register a new badge", response = Void.class),
        @ApiResponse(code = 405, message = "Invalid input", response = Void.class) })
    @RequestMapping(value = "/badges/{uuid}",
        consumes = { "application/json" },
        method = RequestMethod.POST)
    ResponseEntity<Void> postBadge(
@ApiParam(value = "uuid of the application to fetch",required=true ) @PathVariable("uuid") String uuid


,

@ApiParam(value = "The info required to register an application's badge" ,required=true ) @RequestBody RegistrationBadge body

);


    @ApiOperation(value = "", notes = "update a badge", response = Void.class, tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 201, message = "Update a badge", response = Void.class),
        @ApiResponse(code = 405, message = "Invalid input", response = Void.class) })
    @RequestMapping(value = "/badges/{uuid}",
        consumes = { "application/json" },
        method = RequestMethod.PUT)
    ResponseEntity<Void> updateBadge(
@ApiParam(value = "uuid of the application to fetch",required=true ) @PathVariable("uuid") String uuid


,

@ApiParam(value = "The info required to update an application's badge" ,required=true ) @RequestBody UpdateBadge body

);

}
