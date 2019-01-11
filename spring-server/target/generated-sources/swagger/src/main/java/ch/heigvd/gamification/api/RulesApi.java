package ch.heigvd.gamification.api;

import ch.heigvd.gamification.api.dto.ApplicationsRulesSummary;
import ch.heigvd.gamification.api.dto.RegistrationRule;
import ch.heigvd.gamification.api.dto.UpdateRule;

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

@Api(value = "rules", description = "the rules API")
public interface RulesApi {

    @ApiOperation(value = "", notes = "Retrieve rules by application uuid", response = ApplicationsRulesSummary.class, responseContainer = "List", tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "List all rules applications", response = ApplicationsRulesSummary.class),
        @ApiResponse(code = 404, message = "Application not found", response = ApplicationsRulesSummary.class) })
    @RequestMapping(value = "/rules/{uuid}",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<List<ApplicationsRulesSummary>> findApplicationRules(
@ApiParam(value = "uuid de l'application à trouver",required=true ) @PathVariable("uuid") String uuid


);


    @ApiOperation(value = "", notes = "add new rule", response = Void.class, tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 201, message = "Register a new rule", response = Void.class),
        @ApiResponse(code = 405, message = "Invalid input", response = Void.class) })
    @RequestMapping(value = "/rules/{uuid}",
        consumes = { "application/json" },
        method = RequestMethod.POST)
    ResponseEntity<Void> postRule(
@ApiParam(value = "uuid of the application to add rule",required=true ) @PathVariable("uuid") String uuid


,

@ApiParam(value = "The rule for an application's badges" ,required=true ) @RequestBody RegistrationRule body

);


    @ApiOperation(value = "", notes = "update a rule", response = Void.class, tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Update rule", response = Void.class),
        @ApiResponse(code = 405, message = "Invalid input", response = Void.class) })
    @RequestMapping(value = "/rules/{uuid}",
        consumes = { "application/json" },
        method = RequestMethod.PUT)
    ResponseEntity<Void> updateRule(
@ApiParam(value = "uuid of the application to update rule",required=true ) @PathVariable("uuid") String uuid


,

@ApiParam(value = "The rule for an application's badges" ,required=true ) @RequestBody UpdateRule body

);

}
