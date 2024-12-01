package com.example.exampleProjectJavaSpringboot.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path = "/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping(path = "/add")
    public @ResponseBody String addNewUser (@RequestParam String first_name, @RequestParam String last_name) {
        User user = new User();

        user.setFirst_name(first_name);
        user.setLast_name(last_name);
        user.setCreatedAt();

        userRepository.save(user);
        return "saved";
    }

    @GetMapping(path = "/all")
    public @ResponseBody Iterable<User> getAllUsers() {
        return userRepository.findAll();
    }

    @GetMapping(path = "findById")
    public @ResponseBody Iterable<User> getUserById(@RequestParam Iterable<Integer> id) {
        return userRepository.findAllById(id);
    }
}
