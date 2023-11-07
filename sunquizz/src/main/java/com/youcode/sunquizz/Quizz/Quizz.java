package com.youcode.sunquizz.Quizz;

import com.youcode.sunquizz.User.Teacher.Teacher;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalTime;

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
}
