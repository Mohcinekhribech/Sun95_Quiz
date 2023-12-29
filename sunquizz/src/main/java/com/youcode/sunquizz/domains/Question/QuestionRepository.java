package com.youcode.sunquizz.domains.Question;

import com.youcode.sunquizz.domains.Level.Level;
import com.youcode.sunquizz.domains.Subject.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuestionRepository extends JpaRepository<Question,Integer> {
    List<Question> findAllByLevel(Level level);
    List<Question> findAllBySubject(Subject subject);
}
