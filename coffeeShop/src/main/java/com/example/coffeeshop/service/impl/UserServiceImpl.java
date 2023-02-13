package com.example.coffeeshop.service.impl;

import com.example.coffeeshop.model.entity.User;
import com.example.coffeeshop.model.service.UserServiceModel;
import com.example.coffeeshop.model.view.UserViewModel;
import com.example.coffeeshop.repository.UserRepository;
import com.example.coffeeshop.service.UserService;
import com.example.coffeeshop.util.CurrentUser;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private Logger LOGGER = LoggerFactory.getLogger(UserService.class);

    private final ModelMapper modelMapper;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final CurrentUser currentUser;



    public UserServiceImpl(ModelMapper modelMapper, UserRepository userRepository, PasswordEncoder passwordEncoder, CurrentUser currentUser) {
        this.modelMapper = modelMapper;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.currentUser = currentUser;

    }


    // If method is void it's not needed mapping to UserServiceModel.class
    @Override
    public UserServiceModel registerUser(UserServiceModel userServiceModel) {
        User user = modelMapper.map(userServiceModel, User.class);


        user.setPassword(passwordEncoder.encode(userServiceModel.getPassword()));

        return modelMapper.map(userRepository.save(user), UserServiceModel.class);
    }

    @Override
    public UserServiceModel findByUsername(String username) {

        return userRepository.findByUsername(username)
                .map(user -> modelMapper.map(user, UserServiceModel.class))
                .orElse(null);

    }

    @Override
    public void loginUser(Long id, String username) {

        currentUser.setId(id);
        currentUser.setUsername(username);



    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id)
                .orElse(null);
    }

    @Override
    public List<UserViewModel> findAllUserAndCountOfOrdersOrderByCountDesc() {
        return userRepository.findAllByOrdersCountDesc()
                .stream()
                .map(user -> {
                    UserViewModel userViewModel = new UserViewModel();
                    userViewModel.setUsername(user.getUsername());
                    userViewModel.setCountOfOrders(user.getOrders().size());

                    return userViewModel;
                })
                .collect(Collectors.toList());
    }

}
