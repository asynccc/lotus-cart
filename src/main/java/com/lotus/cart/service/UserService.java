package com.lotus.cart.service;

import com.lotus.cart.model.entity.User;
import com.lotus.cart.model.request.user.UpdateUserRequest;
import com.lotus.cart.model.response.product.SearchUserProductResponse;
import com.lotus.cart.model.response.user.CreateUserResponse;
import com.lotus.cart.model.response.user.SearchUserResponse;
import com.lotus.cart.model.request.user.CreateUserRequest;
import com.lotus.cart.model.request.user.DeleteUserRequest;
import com.lotus.cart.model.response.user.UpdateUserResponse;
import com.lotus.cart.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Service
public class UserService {

    private UserRepository repository;

    /**
     * Create a user to repository
     *
     * @param request   user request
     * @return created user object
     */
    public CreateUserResponse create(CreateUserRequest request) {
        var user = repository.save(User.builder()
                        .name(request.getName())
                        .password(request.getPassword())
                        .email(request.getEmail())
                .build());

        return new CreateUserResponse(user.getId(), user.getName(), user.getEmail());
    }

    public SearchUserResponse search(String name) {
        var optUser = repository.findByName(name);

        if (optUser.isPresent()) {
            var user = optUser.get();

            return SearchUserResponse.builder()
                    .id(user.getId())
                    .name(user.getName())
                    .email(user.getEmail())
                    .build();
        }

        return null;
    }

    public List<SearchUserResponse> searchAll() {
        return repository.findAll().stream()
                .map(user -> SearchUserResponse.builder()
                        .id(user.getId())
                        .name(user.getName())
                        .build())
                .toList();
    }

    public void delete(DeleteUserRequest request) {
        repository.findByName(request.getName()).ifPresent(repository::delete);
    }

    public UpdateUserResponse update(UpdateUserRequest request) {
        var optUser = repository.findByName(request.getName());

        if (optUser.isPresent()) {
            var user = optUser.get();

            return UpdateUserResponse.builder()
                    .id(user.getId())
                    .name(user.getName())
                    .email(user.getEmail())
                    .products(user.getProducts())
                    .build();
        }

        return null;
    }
}
