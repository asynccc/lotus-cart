package com.lotus.cart.controller;

import com.lotus.cart.model.request.user.DeleteUserRequest;
import com.lotus.cart.model.request.user.UpdateUserRequest;
import com.lotus.cart.model.response.user.CreateUserResponse;
import com.lotus.cart.model.response.user.SearchUserResponse;
import com.lotus.cart.model.request.user.CreateUserRequest;
import com.lotus.cart.model.response.user.UpdateUserResponse;
import com.lotus.cart.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.Info;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("api/v1/user")
@Api(tags = "User Controller", produces = "application/json", consumes = "application/json")
public class UserController {

    private final UserService service;

    /**
     * Sends a request to create a new user
     *
     * @param createUserRequest   request
     * @return success response
     */
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "User successfully created"),
            @ApiResponse(responseCode = "400", description = "Invalid data sent")
    })
    @Operation(summary = "Create a new user", description = "Create a new user to the system")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CreateUserResponse create(@RequestBody @Valid
                                         @Parameter(name = "User Request", description = "Data to be sent")
                                         CreateUserRequest createUserRequest) {
        return service.create(createUserRequest);
    }

    /**
     * Get a user by providing a name
     *
     * @param name   user name request param
     * @return search response
     */
    @ApiResponses(value = {
            @ApiResponse(responseCode = "302", description = "User successfully found"),
            @ApiResponse(responseCode = "404", description = "User not found"),
            @ApiResponse(responseCode = "400", description = "Request param 'name' not found")
    })
    @Operation(summary = "Search for a existent user")
    @GetMapping("/find")
    public ResponseEntity<SearchUserResponse> get(@RequestParam String name) {
        var response = service.search(name);

        if (response != null) {
            return new ResponseEntity<>(response, HttpStatus.FOUND);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * Get all created users
     *
     * @return all created users
     */
    @ApiResponses(
            @ApiResponse(responseCode = "200", description = "Show all users")
    )
    @Operation(summary = "Show all users")
    @GetMapping("/")
    @ResponseStatus(HttpStatus.OK)
    public List<SearchUserResponse> getAll() {
        return service.searchAll();
    }

    /**
     * Delete a existent user
     *
     * @param deleteRequest   delete request json
     */
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "User successfully deleted"),
            @ApiResponse(responseCode = "401", description = "No permission to delete a user"),
            @ApiResponse(responseCode = "404", description = "User not found")
        }
    )
    @Operation(description = "Delete a existent user")
    @DeleteMapping("/delete")
    @ResponseStatus(HttpStatus.OK)
    public void delete(DeleteUserRequest deleteRequest) {
        service.delete(deleteRequest);
    }

    /**
     * Update a existent user
     *
     * @param updateRequest   update request json
     * @return user update response
     */
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "User successfully updated"),
            @ApiResponse(responseCode = "404", description = "User not found"),
            @ApiResponse(responseCode = "401", description = "Insufficient permissions")
    })
    @Operation(description = "Update a existent user")
    @PostMapping("/update")
    @ResponseStatus(HttpStatus.OK)
    public UpdateUserResponse update(UpdateUserRequest updateRequest) {
        return service.update(updateRequest);
    }
}
