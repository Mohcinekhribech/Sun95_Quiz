package com.youcode.sunquizz.Answer;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.youcode.sunquizz.Question.Question;
import com.youcode.sunquizz.Validation.Validation;
import jakarta.persistence.*;
import lombok.Data;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table
@Data
public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String text;
    @OneToMany(mappedBy = "answer", fetch = FetchType.LAZY)
    private List<Validation> validations;
}