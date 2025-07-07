package com.scm.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.scm.entities.User;
import com.scm.helpers.Helper;
import com.scm.services.UserService;

@ControllerAdvice
public class RootController {

    @Autowired
    private UserService userService;

    private Logger logger = LoggerFactory.getLogger(UserController.class);

    @ModelAttribute
    private void addLoggedInUserInformation(Model model, Authentication authentication) {

        if (authentication == null)
            return;

        System.out.println("Adding logged in user information to the model");
        String username = Helper.getEmailOfLoggedInUser(authentication);
        logger.info("User logged in: {}", username);

        // database se data ko fetch : get user from db:
        User user = userService.getUserByEmail(username);
        System.out.println(user);

        if (user == null) {
            model.addAttribute("loggedInUser", null);

        } else {

            System.out.println(user.getName());
            System.out.println(user.getEmail());

            model.addAttribute("loggedInUser", user);
        }

    }
}
