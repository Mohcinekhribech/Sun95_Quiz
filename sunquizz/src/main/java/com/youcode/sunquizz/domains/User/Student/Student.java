package com.youcode.sunquizz.domains.User.Student;

import com.youcode.sunquizz.domains.AssignQuizz.AssignQuizz;
import com.youcode.sunquizz.Security.User.User;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDate;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@Table(name = "student")
public class Student extends User {
    private LocalDate registrationDate;
    @OneToMany(mappedBy = "student", fetch = FetchType.LAZY)
    private List<AssignQuizz> assignQuizzes;
}