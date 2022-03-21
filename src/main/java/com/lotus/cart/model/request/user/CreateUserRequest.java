package com.lotus.cart.model.request.user;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Data
@AllArgsConstructor
public class CreateUserRequest {

    @NotEmpty
    @Schema(name = "User name", example = "myusername")
    private String name;

    @NotEmpty
    @Schema(name = "User password", example = "mysecurepassword123")
    private String password;

    @Email
    @Schema(name = "User email", example = "user@hotmail.com")
    private String email;

}
