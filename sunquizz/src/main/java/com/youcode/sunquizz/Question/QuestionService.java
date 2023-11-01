package com.youcode.sunquizz.Question;

import com.youcode.sunquizz.Level.Level;
import com.youcode.sunquizz.Question.Question;
import com.youcode.sunquizz.Question.QuestionRepository;
import com.youcode.sunquizz.Subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuestionService {
    QuestionRepository questionRepository;
    @Autowired
    public QuestionService(QuestionRepository questionRepository)
    {
        this.questionRepository = questionRepository;
    }
    public Question getQuestion(Integer id)
    {
        Optional<Question> question = questionRepository.findById(id);
        if (question.isPresent()) {
            return question.get();
        }
        return null;
    }
    public  List<Question> getQuestionByLevel(Integer id)
    {
        Level level = new Level();
        level.setId(id);
        return questionRepository.findAllByLevel(level);
    }
    public  List<Question> getQuestionBySubject(Integer id)
    {
        Subject subject = new Subject();
        subject.setId(id);
        return questionRepository.findAllBySubject(subject);
    }
    public List<Question> getQuestions()
    {
        return questionRepository.findAll();
    }
    public Question createQuestion(Question question)
    {
        return questionRepository.save(question);
    }
    public Question updateQuestion(Question question,Integer id)
    {
        Optional<Question> existQuestion = questionRepository.findById(id);
        if(existQuestion.isPresent()) {
            question.setId(existQuestion.get().getId());
            return questionRepository.save(question);
        }
        return null;
    }
    public Integer deleteQuestion(Integer id)
    {
        Optional<Question> question = questionRepository.findById(id);
        if(question.isPresent()) {
            questionRepository.delete(question.get());
            return 1;
        }else return 0;
    }
}
