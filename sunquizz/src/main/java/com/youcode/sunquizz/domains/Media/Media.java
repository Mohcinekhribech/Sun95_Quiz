package com.youcode.sunquizz.domains.Media;

import com.youcode.sunquizz.domains.Question.Question;
import jakarta.persistence.*;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data
public class Media {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private MediaType type;
    private String link;
    private String description;
    @OneToMany(mappedBy = "media",cascade = { CascadeType.MERGE, CascadeType.REMOVE })
    private Set<Question> questions = new HashSet<>();
}