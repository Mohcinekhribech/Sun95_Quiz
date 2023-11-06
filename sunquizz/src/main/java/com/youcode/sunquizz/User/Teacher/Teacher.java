package com.youcode.sunquizz.User.Teacher;

import com.youcode.sunquizz.User.User;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Teacher extends User {
    @Id
    private Integer id;
    private String Speciality;
}
