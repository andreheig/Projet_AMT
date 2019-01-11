package ch.heigvd.gamification.api;

import ch.heigvd.gamification.api.dto.User;

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

@Api(value = "users", description = "the users API")
public interface UsersApi {

    @ApiOperation(value = "", notes = "Retrieve one user by id", response = User.class, tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Returns the specified user state", response = User.class),
        @ApiResponse(code = 404, message = "UserId not found", response = User.class),
        @ApiResponse(code = 405, message = "Invalid input", response = User.class) })
    @RequestMapping(value = "/users/{id}",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<User> findUserById(
@ApiParam(value = "token that identifies the application sending the request" ,required=true ) @RequestHeader(value="X-Gamification-Token", required=true) String xGamificationToken


,
@ApiParam(value = "id of the user to fetch",required=true ) @PathVariable("id") String id


);

}
