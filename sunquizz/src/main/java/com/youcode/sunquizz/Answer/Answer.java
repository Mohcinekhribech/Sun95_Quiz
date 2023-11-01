package com.youcode.sunquizz.Answer;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table
@Data
public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String text;
}
