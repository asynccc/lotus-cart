package com.lotus.cart.model.response.user;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class CreateUserResponse {

    private long id;
    private String name;
    private String email;

}
