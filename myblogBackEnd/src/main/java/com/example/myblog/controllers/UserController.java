package com.example.myblog.controllers;

import com.example.myblog.models.User;
import com.example.myblog.repos.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Null;

@Controller
@RequestMapping(path="/api")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    @PostMapping(path="/user/add")
    public @ResponseBody String addNewUser (@RequestParam String userName
            , @RequestParam String passWord) {

        User newUser = new User();
        newUser.setUserName(userName);
        newUser.setPassWord(encoder.encode(passWord));
        newUser.setRole("ROLE_USER");
        userRepository.save(newUser);
        return "User " + newUser.getUserName() + " registered";
    }

    @PostMapping(path="/user/setRole")
    public @ResponseBody String setUserRole(@RequestParam String userName,
                                            @RequestParam String userRole) {

        User user = userRepository.findUserByUserName(userName);
        user.setRole(userRole);
        userRepository.save(user);
        return "UserRole update success";
    }

    @GetMapping(path="/user/all")
    public @ResponseBody Iterable<User> getAllUsers() {
        // This returns a JSON or XML with the users
        return userRepository.findAll();
    }

    @GetMapping(path="/user/find")
    public @ResponseBody Boolean isUserExist(@RequestParam String userName) {
        return userRepository.findUserByUserName(userName) != null;
    }

}
