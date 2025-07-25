package com.scm.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.scm.entities.User;
import com.scm.forms.UserForm;
import com.scm.helpers.MessageType;
import com.scm.helpers.message;
import com.scm.services.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class PageController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String index() {
        return "redirect:/home";
    }

    @RequestMapping("/home")
    public String home(Model model) {
        System.out.println("Home page Controller");
        model.addAttribute("name", "Substring technologies");
        model.addAttribute("youtubeChannel", "Learn with Deepak");
        model.addAttribute("GithubRepository", "https://github.com/DeepakDeepak0/");
        return "home";
    }

    @RequestMapping("/about")
    public String aboutPage() {
        System.out.println("About Page");
        return "about";
    }

    @RequestMapping("/services")
    public String servicesPage() {
        System.out.println("Services page");
        return "services";
    }

    @GetMapping("/contact")
    public String contactPage() {
        System.out.println("Contact page");
        return "contact";
    }

    // this is showing login page
    @GetMapping("/login")
    public String login() {
        System.out.println("Login page");
        return "login";
    }

    // This is registration page
    @GetMapping("/register")
    public String register(Model model) {

        UserForm userForm = new UserForm();
        model.addAttribute("userForm", userForm);

        System.out.println("Register page");
        return "register";
    }

    // processing register
    @RequestMapping(value = "/do-register", method = RequestMethod.POST)
    public String processRegister(@Valid @ModelAttribute UserForm userForm, BindingResult rBindingResult,
            HttpSession session) {

        System.out.println("Processing registration ");

        // fetch form data
        System.out.println(userForm);

        // validate form data
        if (rBindingResult.hasErrors()) {
            return "register";
        }

        // save to database
        // Userform --> User
        // User user = User.builder()
        // .name(userForm.getName())
        // .email(userForm.getEmail())
        // .password(userForm.getPassword())
        // .about(userForm.getAbout())
        // .phoneNumber(userForm.getPhoneNumber())
        // .profilePic("https://learncodewithdurgesh.com/_next/image?url=%2F_next%2Fstatic%2Fmedia%2FsirPic.6f77df2a.png&w=3840&q=75")
        // .build();

        User user = new User();
        user.setName(userForm.getName());
        user.setEmail(userForm.getEmail());
        user.setPassword(userForm.getPassword());
        user.setAbout(userForm.getAbout());
        user.setPhoneNumber(userForm.getPhoneNumber());
        user.setEnabled(false);
        user.setProfilePic(
                "https://learncodewithdurgesh.com/_next/image?url=%2F_next%2Fstatic%2Fmedia%2FsirPic.6f77df2a.png&w=3840&q=75");

        userService.saveUser(user);
        System.out.println("user saved");

        // message Registration successful
        // add message here
        message messag = message.builder().content("Registration Successful").type(MessageType.green).build();
        session.setAttribute("message", messag);

        // redirect to login page

        return "redirect:/register";
    }

}
