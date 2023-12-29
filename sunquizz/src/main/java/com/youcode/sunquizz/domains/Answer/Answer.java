package com.youcode.sunquizz.domains.Answer;

import com.youcode.sunquizz.domains.Validation.Validation;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table
@Data
public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String text;
    @OneToMany(mappedBy = "answer",fetch = FetchType.LAZY,cascade = { CascadeType.MERGE, CascadeType.REMOVE })
    private List<Validation> validations;
}