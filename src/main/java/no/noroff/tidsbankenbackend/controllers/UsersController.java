package no.noroff.tidsbankenbackend.controllers;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import no.noroff.tidsbankenbackend.mappers.UsersMapper;
import no.noroff.tidsbankenbackend.model.Users;
import no.noroff.tidsbankenbackend.model.dto.users.UsersGetDTO;
import no.noroff.tidsbankenbackend.model.dto.users.UsersPostDTO;
import no.noroff.tidsbankenbackend.model.dto.users.UsersPutDTO;
import no.noroff.tidsbankenbackend.services.users.UsersService;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;

@RestController
@RequestMapping("api/v1/users")
public class UsersController {
    private final UsersService usersService;
    private final UsersMapper usersMapper;

    public UsersController(UsersService usersService, UsersMapper usersMapper) {
        this.usersService = usersService;
        this.usersMapper = usersMapper;
    }

    @GetMapping
    @Operation(summary = "Get all users")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Success",
                    content = {
                            @Content(mediaType = "application/json",
                                    array = @ArraySchema(
                                            schema = @Schema(
                                                    implementation = UsersGetDTO.class
                                            )
                                    )
                            )
                    }
            )
    })
    public ResponseEntity findAll() {
        return ResponseEntity.ok(
                usersMapper.usersToUsersGetDto(
                        usersService.findAll()
                )
        );
    }

    @GetMapping("{id}")
    @Operation(summary = "Get user by ID")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Success",
                    content = {
                            @Content(mediaType = "application/json",
                                    schema = @Schema(
                                            implementation = UsersGetDTO.class
                                    )
                            )
                    }
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Not Found",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(
                                    implementation = ProblemDetail.class)
                    )
            )
    })
    public ResponseEntity findById(@PathVariable int id) {
        UsersGetDTO usersGetDTO = usersMapper.usersToUsersGetDto(
                usersService.findById(id)
        );
        return ResponseEntity.ok(usersGetDTO);
    }

    @PostMapping
    @Operation(summary = "Create new user")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "201",
                    description = "Created",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = ProblemDetail.class)
                    )
            )
    })
    public ResponseEntity add(@RequestBody UsersPostDTO usersPostDTO) throws URISyntaxException {
        Users user = usersMapper.usersPostDtoToUsers(usersPostDTO);
        usersService.add(user);
        URI uri = new URI("api/v1/users/" + 1);
        return ResponseEntity.created(uri).build();
    }

    @PutMapping("{id}")
    @Operation(summary = "Update existing user")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "204",
                    description = "Success",
                    content = @Content
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Bad Request",
                    content = @Content
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Not Found",
                    content = @Content
            )
    })
    public ResponseEntity update(
            @RequestBody UsersPutDTO usersPutDTO,
            @PathVariable int id
    ) {
        if (id != usersPutDTO.getId()) {
            return ResponseEntity.badRequest().build();
        }
        usersService.update(usersMapper.usersPutDtoToUsers(usersPutDTO));
        return ResponseEntity.noContent().build();
    }

    public ResponseEntity deleteById(@RequestParam int id) {
        UsersGetDTO deletedUser = usersMapper.usersToUsersGetDto(
                usersService.findById(id)
        );
        usersService.deleteById(id);
        return ResponseEntity.ok((deletedUser));
    }
}
