package com.youcode.sunquizz.domains.AssignQuizz;

import com.youcode.sunquizz.domains.Quizz.Quizz;
import com.youcode.sunquizz.domains.User.Student.Student;
import com.youcode.sunquizz.domains.Validation.Validation;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class AssignQuizz {
    @Id
    private Integer id;
    private Integer chance;
    private LocalDate startDate;
    private LocalDate endDate;
    @Nullable
    private Integer score;
    @Nullable
    private boolean result;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "quizz_id")
    private Quizz quizz;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "student_id")
    private Student student;
    @ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinTable(
            name = "Student_answers_on_a_test",
            joinColumns = @JoinColumn(name = "assignquizz_id"),
            inverseJoinColumns = @JoinColumn(name = "validation_id"))
    private List<Validation> validations = new ArrayList<>();
}
