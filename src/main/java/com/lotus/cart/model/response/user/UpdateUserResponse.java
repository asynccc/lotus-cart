package com.lotus.cart.model.response.user;

import com.lotus.cart.model.entity.Product;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;

import java.util.List;

@AllArgsConstructor
@Builder
public class UpdateUserResponse {

    @Schema(title = "User id", description = "User id given from update response", example = "1")
    private long id;

    @Schema(title = "User name", description = "User name given from update response", example = "username")
    private String name;

    @Schema(title = "User email", description = "User email given from update response", example = "user@email.com")
    private String email;

    @Schema(title = "User products", description = "User products given from update response")
    private List<Product> products;

}
