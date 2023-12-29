package com.youcode.sunquizz.domains.Level;

import com.youcode.sunquizz.domains.Question.Question;
import jakarta.persistence.*;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table
@Data
public class Level {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private int maxPoint;
    private int minPoint;
    @OneToMany(mappedBy = "level",cascade = { CascadeType.MERGE, CascadeType.REMOVE })
    private Set<Question> questions = new HashSet<>();
}