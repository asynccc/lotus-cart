package com.lotus.cart.model.request.user;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.validation.constraints.NotBlank;

@AllArgsConstructor
@Getter
public class DeleteUserRequest {

    private long id;

    @NotBlank
    @Schema(name = "Name of user being deleted", example = "myusername")
    private String name;

}
