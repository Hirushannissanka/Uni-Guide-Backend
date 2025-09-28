package org.example.service;

import org.example.dto.request.ApiRequest;
import org.example.dto.response.ApiResponse;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface UniversityService {
    public ApiResponse save(MultipartFile logo,MultipartFile lette,ApiRequest request) throws IOException;
}
