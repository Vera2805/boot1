package com.example.demo.service;

import com.example.demo.model.User;


import java.util.List;

public interface UserService {

    User getUser(Long id);

    void addUser(User user);

    void deleteUser(Long id);

    List<User> getAllUsers();

    void updateUser(User user);


}
