package com.youcode.sunquizz.Validation;

import com.youcode.sunquizz.Question.Question;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ValidationRepository extends JpaRepository<Validation,Integer> {
    List<Validation> findAllByQuestion(Question question);
}
