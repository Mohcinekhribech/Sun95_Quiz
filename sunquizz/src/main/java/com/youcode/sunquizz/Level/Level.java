package com.youcode.sunquizz.Level;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonMerge;
import com.youcode.sunquizz.Question.Question;
import jakarta.persistence.*;
import lombok.Data;

import java.util.HashSet;
import java.util.List;
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
    @OneToMany(mappedBy = "level")
    private Set<Question> questions = new HashSet<>();
}