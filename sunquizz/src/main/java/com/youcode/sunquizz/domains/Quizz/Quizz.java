package com.youcode.sunquizz.domains.Quizz;

import com.youcode.sunquizz.domains.AssignQuizz.AssignQuizz;
import com.youcode.sunquizz.domains.QuizzQuestion.QuizzQuestion;
import com.youcode.sunquizz.domains.User.Teacher.Teacher;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalTime;
import java.util.List;

@Entity
@Data
public class Quizz {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
    @OneToMany(mappedBy = "quizz", fetch = FetchType.LAZY,cascade = { CascadeType.MERGE, CascadeType.REMOVE })
    private List<QuizzQuestion> quizzQuestions;
}
