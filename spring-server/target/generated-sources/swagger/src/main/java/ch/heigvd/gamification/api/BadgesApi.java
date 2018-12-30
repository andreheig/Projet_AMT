package ch.heigvd.gamification.api;

import ch.heigvd.gamification.api.dto.ApplicationsBadgesSummary;
import ch.heigvd.gamification.api.dto.RegistrationBadges;

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

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2018-12-18T12:20:18.370+01:00")

@Api(value = "badges", description = "the badges API")
public interface BadgesApi {

    @ApiOperation(value = "", notes = "Retrieve one application by uuid", response = ApplicationsBadgesSummary.class, responseContainer = "List", tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "List all badges applications", response = ApplicationsBadgesSummary.class) })
    @RequestMapping(value = "/badges/{uuid}",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<List<ApplicationsBadgesSummary>> findApplicationBadgesByUuid(
@ApiParam(value = "uuid identifiant l'application" ,required=true ) @RequestHeader(value="id-Application", required=true) String idApplication


,
@ApiParam(value = "uuid of the application to fetch",required=true ) @PathVariable("uuid") String uuid


);


    @ApiOperation(value = "", notes = "add new badges", response = Void.class, tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 201, message = "Register a new badges", response = Void.class) })
    @RequestMapping(value = "/badges/{uuid}",
        consumes = { "application/json" },
        method = RequestMethod.POST)
    ResponseEntity<Void> postBadge(
@ApiParam(value = "uuid identifiant l'application" ,required=true ) @RequestHeader(value="id-Application", required=true) String idApplication


,
@ApiParam(value = "uuid of the application to fetch",required=true ) @PathVariable("uuid") String uuid


,

@ApiParam(value = "The info required to register an application's badges" ,required=true ) @RequestBody RegistrationBadges body

);

}
