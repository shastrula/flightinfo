package com.aero.flights.flightinfo.web;

import com.aero.flights.flightinfo.entity.User;
import com.aero.flights.flightinfo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class UserController {

    private static final String DEFAULT_MAPPING = "/user";
    @Autowired
    private UserRepository userRepository;

    @GetMapping(DEFAULT_MAPPING + "/signup")
    public String showSignUpForm(User user) {
        return "user/add-user";
    }

    @PostMapping(DEFAULT_MAPPING + "/add")
    public String addUser(@Valid User user, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "user/add-user";
        }

        userRepository.save(user);
        model.addAttribute("users", userRepository.findAll());
        return "user/index";
    }

    @GetMapping(DEFAULT_MAPPING + "/edit/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
        User user = userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
        model.addAttribute("user", user);
        return "user/update-user";
    }

    @PostMapping(DEFAULT_MAPPING + "/update/{id}")
    public String updateUser(@PathVariable("id") long id, @Valid User user, BindingResult result, Model model) {
        if (result.hasErrors()) {
            user.setId(id);
            return "user/update-user";
        }

        userRepository.save(user);
        model.addAttribute("users", userRepository.findAll());
        return "user/index";
    }

    @GetMapping(DEFAULT_MAPPING + "/delete/{id}")
    public String deleteUser(@PathVariable("id") long id, Model model) {
        User user = userRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
        userRepository.delete(user);
        model.addAttribute("users", userRepository.findAll());
        return "user/index";
    }
}