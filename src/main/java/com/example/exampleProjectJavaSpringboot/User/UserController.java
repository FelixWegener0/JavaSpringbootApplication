package com.example.exampleProjectJavaSpringboot.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping(path = "/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping(path = "/add")
    public @ResponseBody String addNewUser (@RequestParam String first_name, @RequestParam String last_name, @RequestParam String mobileAppToken) {
        return userService.createNewUser(first_name, last_name, mobileAppToken);
    }

    @PostMapping(path = "/updateMobileAppToken")
    public @ResponseBody String updateUserAppToken(@RequestParam String token, @RequestParam Integer id) {
        return userService.updateMobileAppToken(token, id);
    }

    @GetMapping(path = "/all")
    public @ResponseBody Iterable<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping(path = "/findById")
    public @ResponseBody Optional<User> getUserById(@RequestParam Integer id) {
        return userService.getUserById(id);
    }
}
