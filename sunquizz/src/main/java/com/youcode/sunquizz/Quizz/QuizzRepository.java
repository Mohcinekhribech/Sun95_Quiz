package com.youcode.sunquizz.Quizz;

import com.youcode.sunquizz.User.Teacher.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuizzRepository extends JpaRepository<Quizz,Integer> {
    List<Quizz> findAllByTeacher(Teacher teacher);
}
