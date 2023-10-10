package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


@Controller
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/")
    public String getUsersForm(ModelMap model) {
        List<User> users = userService.getAllUsers();
        model.addAttribute("users", users);
        return "users";
    }

    @RequestMapping("/add")
    public String newUserForm(ModelMap model) {
        return "add";
    }

    @RequestMapping("/edit")
    public String editUserForm(ModelMap model, @RequestParam Long id) {
        User user = userService.getUser(id);
        model.put("user", user);
        return "edit";
    }

    @RequestMapping("/new")
    public String newUserForm(@ModelAttribute("user") User user) {
        userService.addUser(user);
        return "redirect:/";
    }

    @RequestMapping("/update")

    public String updateUserForm(@ModelAttribute("user") User user) {
        userService.updateUser(user);
        return "redirect:/";
    }

    @RequestMapping("/delete")
    public String deleteUserForm(@RequestParam Long id) {

        userService.deleteUser(id);
        return "redirect:/";
    }
}





