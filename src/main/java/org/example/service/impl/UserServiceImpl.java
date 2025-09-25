package org.example.service.impl;

import org.example.dto.request.ApiRequest;
import org.example.dto.response.ApiResponse;
import org.example.service.UserService;

public class UserServiceImpl implements UserService {
    @Override
    public ApiResponse signUp(ApiRequest request) {
        ApiResponse response = new ApiResponse();

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

            return null;
    }
}
