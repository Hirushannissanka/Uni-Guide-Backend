package org.example.service;

import org.example.dto.request.ApiRequest;
import org.example.dto.response.ApiResponse;

public interface UserService {
    public ApiResponse signUp(ApiRequest request);
}
