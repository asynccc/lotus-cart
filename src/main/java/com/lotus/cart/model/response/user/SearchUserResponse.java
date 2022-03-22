package com.lotus.cart.model.response.user;

import com.lotus.cart.model.entity.Product;
import com.lotus.cart.model.response.product.SearchUserProductResponse;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@AllArgsConstructor
@Builder
@Data
public class SearchUserResponse {

    @Schema(title = "User id", description = "User id given from search response", example = "1")
    private long id;

    @Schema(title = "User name", description = "User name given from search response", example = "username")
    private String name;

    @Schema(title = "User name", description = "User name given from search response", example = "username@hotmail.com")
    private String email;

    @Schema(title = "User products", description = "User products collection given from search response")
    private List<SearchUserProductResponse> products;

}
