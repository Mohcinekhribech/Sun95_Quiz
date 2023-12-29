package com.youcode.sunquizz.domains.User.Teacher;

import com.youcode.sunquizz.domains.Quizz.Quizz;
import com.youcode.sunquizz.Security.User.User;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
public class Teacher extends User {
    private String Speciality;
    @OneToMany(mappedBy = "teacher", fetch = FetchType.LAZY)
    List<Quizz> quizzes;
}