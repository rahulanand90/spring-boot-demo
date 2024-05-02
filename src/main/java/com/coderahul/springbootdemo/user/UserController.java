package com.coderahul.springbootdemo.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    private final UserRepository userRepository;

    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping(path = "/addUser")
    public @ResponseBody User addNewUser(@RequestParam String name, @RequestParam String email){
        User user = new User();
        user.setEmail(email);
        user.setName(name);
        userRepository.save(user);
        return user;
    }
}
