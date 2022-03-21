package com.lotus.cart.model.request.user;

import com.lotus.cart.model.entity.Product;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

@AllArgsConstructor
@Builder
@Getter
public class UpdateUserRequest {

    @NotBlank
    @Schema(description = "Name of user to be updated", example = "myusername")
    private String name;

    @Email
    @Schema(description = "User email to be updated", example = "myemail@email.com")
    private String email;

    @Size(min = 5, max = 16)
    @Schema(description = "User password to be updated", example = "mysecurepassword")
    private String password;

    @Schema(description = "User products to be updated")
    private List<Product> products;
}
