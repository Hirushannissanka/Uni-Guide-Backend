package org.example.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.dto.UniversityStatus;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "university")

public class University {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int universityId;
    private String universityName;
    private String description;
    private String link;
    private UniversityStatus universityStatus;
    @Lob
    @Column(name = "logo", columnDefinition = "LONGBLOB")
    private byte[] logo;

    @Lob
    @Column(name = "ugcLetter", columnDefinition = "LONGBLOB")
    private byte[] ugcLetter;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
