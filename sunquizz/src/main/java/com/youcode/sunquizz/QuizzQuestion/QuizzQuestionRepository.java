package com.youcode.sunquizz.QuizzQuestion;

import com.youcode.sunquizz.Quizz.Quizz;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuizzQuestionRepository extends JpaRepository<QuizzQuestion,Integer> {
    List<QuizzQuestion> findAllByQuizz(Quizz quizz);
}