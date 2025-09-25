package org.example.dto.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

@Data
public class Response {

    private String message;
    @JsonIgnore
    private String statusCode;
    @JsonIgnore
    private String statusDesc;

}
