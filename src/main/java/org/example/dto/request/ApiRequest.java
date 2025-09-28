package org.example.dto.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.dto.UnivercityDTO;
import org.example.dto.UserDTO;

@AllArgsConstructor
@NoArgsConstructor
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiRequest {
    private UserDTO userDTO;
    private UnivercityDTO univercityDTO;
    private Integer userId;
}
