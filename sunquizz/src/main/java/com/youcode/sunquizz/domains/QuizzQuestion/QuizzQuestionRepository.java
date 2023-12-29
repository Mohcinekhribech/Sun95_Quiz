package com.youcode.sunquizz.domains.QuizzQuestion;

import com.youcode.sunquizz.domains.Quizz.Quizz;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuizzQuestionRepository extends JpaRepository<QuizzQuestion,Integer> {
    List<QuizzQuestion> findAllByQuizz(Quizz quizz);
}