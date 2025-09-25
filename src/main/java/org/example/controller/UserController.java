package org.example.controller;

import org.example.dto.request.ApiRequest;
import org.example.dto.response.ApiResponse;
import org.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/sign-up")
    public ApiResponse signUp(@RequestBody ApiRequest request){
        return userService.signUp(request);
    }

    @PostMapping("/sign-in")
    public ApiResponse signIn(@RequestBody ApiRequest request){
        return userService.signIn(request);
    }

}
