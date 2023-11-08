package com.youcode.sunquizz.StudentAnswer;

import com.youcode.sunquizz.AssignQuizz.AssignQuizz;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentAnswerRepository extends JpaRepository<StudentAnswer,Integer> {
    List<StudentAnswer> findAllByAssignQuizz(AssignQuizz assignQuizz);
}