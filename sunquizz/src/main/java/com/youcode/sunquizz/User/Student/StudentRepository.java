package com.youcode.sunquizz.User.Student;

import com.youcode.sunquizz.User.Teacher.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student,Integer> {
    List<Student> findAllByFirstNameOrLastName(String firstName, String lastName);
}
