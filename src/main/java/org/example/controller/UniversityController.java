package org.example.controller;

import org.example.dto.request.ApiRequest;
import org.example.dto.response.ApiResponse;
import org.example.service.UniversityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/university")
public class UniversityController {
    @Autowired
    UniversityService universityService;

    public ApiResponse save(@RequestParam("logo") MultipartFile logo, @RequestParam("ugcLetter") MultipartFile ugcLetter, @RequestParam("apiRequest")ApiRequest apiRequest) throws IOException {
        return universityService.save(logo,ugcLetter,apiRequest);
    }
}
