package org.example.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UnivercityDTO {
    private String universityName;
    private String description;
    private String link;
    private byte[] logo;
    private byte[] ugcLetter;
}
