package com.youcode.sunquizz.domains.Quizz;

import com.youcode.sunquizz.domains.User.Teacher.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuizzRepository extends JpaRepository<Quizz,Integer> {
    List<Quizz> findAllByTeacher(Teacher teacher);
}
