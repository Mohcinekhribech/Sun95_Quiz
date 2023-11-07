package com.youcode.sunquizz.Quizz;

import com.youcode.sunquizz.AssignQuizz.AssignQuizz;
import com.youcode.sunquizz.User.Teacher.Teacher;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalTime;
import java.util.List;

@Entity
@Data
public class Quizz {
    @Id
    private Integer id;
    private Integer passScore;
    private Integer chances;
    private String comment;
    private LocalTime duration;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "teacher_id")
    private Teacher teacher;
    @OneToMany(mappedBy = "quizz", fetch = FetchType.LAZY)
    private List<AssignQuizz> assignQuizzes;
}
