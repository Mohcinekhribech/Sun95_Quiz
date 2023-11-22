package com.youcode.sunquizz.Media;

import com.youcode.sunquizz.Question.Question;
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
    @OneToMany(mappedBy = "media")
    private Set<Question> questions = new HashSet<>();
}