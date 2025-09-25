package org.example.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.dto.request.ApiRequest;
import org.example.dto.response.ApiResponse;
import org.example.entity.User;
import org.example.repository.UserRepository;
import org.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    ObjectMapper objectMapper;

    BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
    @Override
    public ApiResponse signUp(ApiRequest request) {
        ApiResponse response = new ApiResponse();
        System.out.println(request.toString());
        //validating
        if (request==null||request.getUserDTO()==null) {
            response.setMessage("request is null");
            return response;
        }
        if (request.getUserDTO().getEmail()==null||
                request.getUserDTO().getPassword()==null||request.getUserDTO().getUserName()==null) {
            response.setMessage("user details are null");
            return response;
        }
        User user =objectMapper.convertValue(request.getUserDTO(),User.class);
        System.out.println(user.toString());
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        User savedUser = userRepository.save(user);
        //response.setUser(savedUser);  find beter way to send as response
        response.setMessage("success");


        return  response;
    }

    @Override
    public ApiResponse signIn(ApiRequest request) {
        ApiResponse response = new ApiResponse();
        if (request==null||request.getUserDTO()==null) {
            response.setMessage("request is null");
            return response;
        }
        if(request.getUserDTO().getEmail()==null||request.getUserDTO().getPassword()==null) {
            response.setMessage("user details are null");
            return response;
        }
        Optional<User> userOptional = userRepository.findByEmail(request.getUserDTO().getEmail());
        if (userOptional.isEmpty()) {
            response.setMessage("user not found");
            return response;
        }
        User user = userOptional.get();
        if(!bCryptPasswordEncoder.matches(request.getUserDTO().getPassword(),user.getPassword())) {
            response.setMessage("password does not match");
            return response;
        }
        response.setMessage("success sign in");
        return  response;
    }
}
