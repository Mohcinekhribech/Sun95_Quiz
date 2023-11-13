package com.youcode.sunquizz.User.Student;

import com.youcode.sunquizz.User.Teacher.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface StudentRepository extends JpaRepository<Student,Integer> {
    List<Student> findAllByFirstName(String firstName);
}