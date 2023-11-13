package com.youcode.sunquizz.User.Teacher;

import com.youcode.sunquizz.Quizz.Quizz;
import com.youcode.sunquizz.User.User;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class Teacher extends User {
    @Id
    private Integer id;
    private String Speciality;
    @OneToMany(mappedBy = "teacher", fetch = FetchType.LAZY)
    List<Quizz> quizzes;
}