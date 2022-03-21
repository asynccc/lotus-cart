package com.lotus.cart.model.response.user;

import com.lotus.cart.model.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Builder;

import java.util.List;

@AllArgsConstructor
@Builder
public class UpdateUserResponse {

    private long id;

    private String name;
    private String email;
    private List<Product> products;

}
