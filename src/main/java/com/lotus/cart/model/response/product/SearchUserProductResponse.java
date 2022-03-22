package com.lotus.cart.model.response.product;

import com.lotus.cart.model.entity.Product;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;

@AllArgsConstructor
@Builder
public class SearchUserProductResponse {

    @Schema(title = "User id", description = "User id given from creation response", example = "1")
    private long id;

    @Schema(title = "User name", description = "User name given from creation response", example = "username")
    private String name;

    @Schema(title = "User email", description = "User email given from creation response", example = "user@email.com")
    private String email;

}
