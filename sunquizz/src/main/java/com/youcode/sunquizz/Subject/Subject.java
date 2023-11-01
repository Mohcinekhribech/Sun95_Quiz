package com.youcode.sunquizz.Subject;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table
@Data
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;
}
