package ch.heigvd.gamification.api;

import ch.heigvd.gamification.api.dto.RegistrationRule;

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

@Api(value = "rules", description = "the rules API")
public interface RulesApi {

    @ApiOperation(value = "", notes = "add new rule", response = Void.class, tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 201, message = "Register a new rule", response = Void.class) })
    @RequestMapping(value = "/rules/{uuid}",
        consumes = { "application/json" },
        method = RequestMethod.POST)
    ResponseEntity<Void> postRule(
@ApiParam(value = "uuid identifiant l'application" ,required=true ) @RequestHeader(value="id-Application", required=true) String idApplication


,
@ApiParam(value = "uuid of the application to add rule",required=true ) @PathVariable("uuid") String uuid


,

@ApiParam(value = "The rule for an application's badges" ,required=true ) @RequestBody RegistrationRule body

);

}
