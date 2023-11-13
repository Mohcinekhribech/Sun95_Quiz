package com.youcode.sunquizz.Subject;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table
@Data
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;
    @Nullable
    @ManyToOne
    @JoinColumn(name = "parent_id")
    private Subject parentSubject;
    @JsonIgnore
    @OneToMany(mappedBy = "parentSubject", fetch = FetchType.LAZY)
    private List<Subject> subjects;
}
