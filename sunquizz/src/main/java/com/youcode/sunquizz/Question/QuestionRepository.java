package com.youcode.sunquizz.Question;

import com.youcode.sunquizz.Level.Level;
import com.youcode.sunquizz.Subject.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuestionRepository extends JpaRepository<Question,Integer> {
    List<Question> findAllByLevel(Level level);
    List<Question> findAllBySubject(Subject subject);
}
