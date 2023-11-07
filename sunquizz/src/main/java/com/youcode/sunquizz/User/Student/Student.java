package com.youcode.sunquizz.User.Student;

import com.youcode.sunquizz.AssignQuizz.AssignQuizz;
import com.youcode.sunquizz.User.User;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data
public class Student extends User {
    @Id
    private Integer id;
    private LocalDate registrationDate;
    @OneToMany(mappedBy = "student", fetch = FetchType.LAZY)
    private List<AssignQuizz> assignQuizzes;
}