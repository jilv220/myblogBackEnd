package com.example.myblog.controllers;

import com.example.myblog.api.CommonResult;
import com.example.myblog.repos.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class LoginController {

    @Autowired
    UserRepository userRepository;

    @RequestMapping(value = "/api/login", method = RequestMethod.POST)
    public CommonResult login(@RequestParam String userName, @RequestParam String passWord) {

        if (userRepository.findUserByUserName(userName) == null) {
            return CommonResult.failed();
        } else if (userRepository.findUserByUserName(userName).getPassWord()
                .equals(passWord)) {
            return CommonResult.success("success");
        } else {
            return CommonResult.validateFailed();
        }
    }


}
