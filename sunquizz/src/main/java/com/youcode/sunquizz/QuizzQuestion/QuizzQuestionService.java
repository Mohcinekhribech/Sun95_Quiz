package com.youcode.sunquizz.QuizzQuestion;

import com.youcode.sunquizz.Quizz.Quizz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuizzQuestionService {
    QuizzQuestionRepository quizzQuestionRepository;
    @Autowired
    public QuizzQuestionService(QuizzQuestionRepository quizzQuestionRepository)
    {
        this.quizzQuestionRepository = quizzQuestionRepository;
    }
    public List<QuizzQuestion> getQuestionsByQuizz(Integer id)
    {
        Quizz quizz = new Quizz();
        quizz.setId(id);
        return quizzQuestionRepository.findAllByQuizz(quizz);
    }
    public QuizzQuestion createQuizzQuestion(QuizzQuestion quizzQuestion)
    {
        return quizzQuestionRepository.save(quizzQuestion);
    }
    public QuizzQuestion updateQuizzQuestion(QuizzQuestion quizzQuestion,Integer id)
    {
        Optional<QuizzQuestion> existQuizzQuestion = quizzQuestionRepository.findById(id);
        if(existQuizzQuestion.isPresent()) {
            quizzQuestion.setId(existQuizzQuestion.get().getId());
            return quizzQuestionRepository.save(quizzQuestion);
        }
        return null;
    }
    public Integer deleteQuizzQuestion(Integer id)
    {
        Optional<QuizzQuestion> quizzQuestion = quizzQuestionRepository.findById(id);
        if(quizzQuestion.isPresent()) {
            quizzQuestionRepository.delete(quizzQuestion.get());
            return 1;
        }else return 0;
    }
}
