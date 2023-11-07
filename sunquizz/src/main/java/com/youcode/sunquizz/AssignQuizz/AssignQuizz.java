package com.youcode.sunquizz.AssignQuizz;

import com.youcode.sunquizz.Quizz.Quizz;
import com.youcode.sunquizz.User.Student.Student;
import com.youcode.sunquizz.User.Teacher.Teacher;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

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
}
