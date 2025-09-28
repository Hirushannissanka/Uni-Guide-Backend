package org.example.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.dto.UnivercityDTO;
import org.example.dto.UniversityStatus;
import org.example.dto.request.ApiRequest;
import org.example.dto.response.ApiResponse;
import org.example.entity.University;
import org.example.entity.User;
import org.example.repository.UniversityRepository;
import org.example.repository.UserRepository;
import org.example.service.UniversityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

@Service
public class UnivercityServiceImpl implements UniversityService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    ObjectMapper objectMapper;

    @Autowired
    UniversityRepository universityRepository;

    @Override
    public ApiResponse save(MultipartFile logo,MultipartFile letter,ApiRequest request) throws IOException {
        ApiResponse response = new ApiResponse();
        if (request==null||request.getUnivercityDTO()==null||request.getUserId()==null){
            response.setMessage("request is null");
            return response;
        }
        if(request.getUnivercityDTO().getUniversityName()==null||request.getUnivercityDTO().getUniversityName()==""){
            response.setMessage("university datails are missing");
            return response;
        }
        UnivercityDTO univercityDTO = request.getUnivercityDTO();
        univercityDTO.setLogo(logo.getBytes());
        univercityDTO.setUgcLetter(letter.getBytes());

        Optional<User> optionalUser= userRepository.findById(request.getUserId());
        if (optionalUser.isEmpty()) {
            response.setMessage("user not found");
            return response;
        }

        University university = objectMapper.convertValue(univercityDTO,University.class);
        university.setUser(optionalUser.get());
        university.setUniversityStatus(UniversityStatus.PENDING);

        University savedUniversity=universityRepository.save(university);
        response.setMessage(savedUniversity.getUniversityName()+"has been saved successfully");
        return response;

    }
}
