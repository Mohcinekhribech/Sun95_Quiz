package com.youcode.sunquizz.domains.AssignQuizz;

import com.youcode.sunquizz.domains.Quizz.Quizz;
import com.youcode.sunquizz.domains.User.Student.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface AssignQuizzRepository extends JpaRepository<AssignQuizz,Integer> {
    List<AssignQuizz> findAllByQuizz(Quizz quizz);
    List<AssignQuizz> findAllByStudent(Student student);
}
