package com.youcode.sunquizz.domains.QuizzQuestion;

import com.youcode.sunquizz.domains.Question.Question;
import com.youcode.sunquizz.domains.Question.QuestionRepository;
import com.youcode.sunquizz.domains.Quizz.Quizz;
import com.youcode.sunquizz.domains.Quizz.QuizzRepository;
import com.youcode.sunquizz.domains.QuizzQuestion.DTOs.QuizzQuestionReq;
import com.youcode.sunquizz.domains.QuizzQuestion.DTOs.QuizzQuestionResp;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class QuizzQuestionService {
    QuizzQuestionRepository quizzQuestionRepository;
    @Autowired
    QuizzRepository quizzRepository;
    @Autowired
    QuestionRepository questionRepository;
    @Autowired
    ModelMapper modelMapper;
    Optional<Quizz> quizz;
    Optional<Question> question;
    @Autowired
    public QuizzQuestionService(QuizzQuestionRepository quizzQuestionRepository)
    {
        this.quizzQuestionRepository = quizzQuestionRepository;
    }
    public List<QuizzQuestionResp> getQuestionsByQuizz(Integer id)
    {
        Quizz quizz = new Quizz();
        quizz.setId(id);
        return quizzQuestionRepository.findAllByQuizz(quizz).stream().map(quizzQuestion -> modelMapper.map(quizzQuestion,QuizzQuestionResp.class)).collect(Collectors.toList());
    }
    public QuizzQuestionResp createQuizzQuestion(QuizzQuestionReq quizzQuestion)
    {
        QuizzQuestion quizzQuestionE = modelMapper.map(quizzQuestion,QuizzQuestion.class);
        quizz = quizzRepository.findById(quizzQuestion.getQuizz_id());
        question = questionRepository.findById(quizzQuestion.getQuestion_id());

        if(quizz.isPresent() && question.isPresent()){
            quizzQuestionE.setQuestion(question.get());
            quizzQuestionE.setQuizz(quizz.get());
            quizzQuestionE = quizzQuestionRepository.save(quizzQuestionE);
            return modelMapper.map(quizzQuestionE, QuizzQuestionResp.class);
        }
        return null;
    }
    public QuizzQuestionResp updateQuizzQuestion(QuizzQuestionReq quizzQuestion,Integer id)
    {
        Optional<QuizzQuestion> questionE = quizzQuestionRepository.findById(id);
        return questionE.map(question1 -> {
            quizzQuestion.setId(questionE.get().getId());
            question = questionRepository.findById(quizzQuestion.getQuestion_id());
            quizz = quizzRepository.findById(quizzQuestion.getQuizz_id());

            if(quizz.isPresent() && question.isPresent()) {
                questionE.get().setQuestion(question.get());
                questionE.get().setQuizz(quizz.get());
                return modelMapper.map(quizzQuestionRepository.save(questionE.get()), QuizzQuestionResp.class);
            }
            return null;
        }).orElse(null);
    }
    public Integer deleteQuizzQuestion(Integer id)
    {
        Optional<QuizzQuestion> quizzQuestion = quizzQuestionRepository.findById(id);
        return quizzQuestion.map(quizzQuestion1 ->{
            quizzQuestionRepository.delete(quizzQuestion1);
            return 1;
        }).orElse(0);
    }
}
