package com.scm.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.scm.services.UserService;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    private Logger logger = LoggerFactory.getLogger(UserController.class);

    // user dashboard
    @RequestMapping(value = "/dashboard", method = RequestMethod.GET)
    public String userDashboard() {
        System.out.println("User dashboard");
        return "user/dashboard";
    }

    // user profile Page
    @RequestMapping(value = "/profile", method = RequestMethod.GET)
    public String userProfile(Model model, Authentication authentication) {

        System.out.println("User Profile Page");
        return "user/profile";
    }

    // user add contacts page

    // user view contacts page

    // user edit contacts

    // user delete contacts

    // user search contact

}
