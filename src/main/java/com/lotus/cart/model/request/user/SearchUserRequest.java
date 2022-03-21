package com.lotus.cart.model.request.user;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@AllArgsConstructor
@Data
public class SearchUserRequest {

    private long id;

    @NotBlank
    @Schema(name = "Username to search", example = "myusername")
    private String name;

}
