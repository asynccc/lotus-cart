package com.lotus.cart.model.response.user;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class CreateUserResponse {

    @Schema(title = "User id", description = "User id given from creation response", example = "1")
    private long id;

    @Schema(title = "User name", description = "User name given from creation response", example = "username")
    private String name;

    @Schema(title = "User email", description = "User email given from creation response", example = "user@email.com")
    private String email;

}
