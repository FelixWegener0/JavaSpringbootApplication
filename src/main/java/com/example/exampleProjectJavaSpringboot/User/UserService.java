package com.example.exampleProjectJavaSpringboot.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public String createNewUser(String first_name, String last_name, String mobileAppToken) {
        User user = new User();

        user.setFirst_name(first_name);
        user.setLast_name(last_name);
        user.setMobileAppToken(mobileAppToken);
        user.setCreatedAt();

        userRepository.save(user);
        return "saved";
    }

    public String updateMobileAppToken(String token, Integer userId) {
        Optional<User> user = userRepository.findById(userId);

        user.ifPresentOrElse((value) -> {
            value.setMobileAppToken(token);
            userRepository.save(value);
            System.out.println("updated mobileAppToken");
        }, () -> {
            System.out.println("try to update mobileAppToken no user found");
        });

        return "updated";
    }

    public Iterable<User> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<User> getUserById(Integer id) {
        return userRepository.findById(id);
    }

}
