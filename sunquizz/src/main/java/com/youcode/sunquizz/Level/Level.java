package com.youcode.sunquizz.Level;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.youcode.sunquizz.Question.Question;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table
@Data
public class Level {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int maxPoint;
    private int minPoint;
    @OneToMany(mappedBy = "level")
    private List<Question> questions;
}
