package com.example.coffeeshop.service;

import com.example.coffeeshop.model.entity.User;
import com.example.coffeeshop.model.service.UserServiceModel;
import com.example.coffeeshop.model.view.UserViewModel;

import java.util.List;

public interface UserService {


    // If method is void it's not needed mapping to UserServiceModel.class when we implement the method.
    UserServiceModel registerUser(UserServiceModel userServiceModel);

    UserServiceModel findByUsername(String username);

    void loginUser(Long id, String username);

    User findById(Long id);

    List<UserViewModel> findAllUserAndCountOfOrdersOrderByCountDesc();
}
