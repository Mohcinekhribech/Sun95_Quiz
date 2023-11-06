package com.youcode.sunquizz.User.Student;

import com.youcode.sunquizz.User.User;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
public class Student extends User {
    @Id
    private Integer id;
    private LocalDate registrationDate;
}