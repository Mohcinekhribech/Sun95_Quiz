package com.youcode.sunquizz.domains.Subject;

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
    @OneToMany(mappedBy = "parentSubject", fetch = FetchType.LAZY,cascade = { CascadeType.MERGE, CascadeType.REMOVE })
    private List<Subject> childSubjects;
}
