package com.youcode.sunquizz.domains.QuizzQuestion;

import com.youcode.sunquizz.domains.Question.Question;
import com.youcode.sunquizz.domains.Question.QuestionRepository;
import com.youcode.sunquizz.domains.Quizz.Quizz;
import com.youcode.sunquizz.domains.Quizz.QuizzRepository;
import com.youcode.sunquizz.domains.QuizzQuestion.DTOs.QuizzQuestionReq;
import com.youcode.sunquizz.domains.QuizzQuestion.DTOs.QuizzQuestionResp;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class QuizzQuestionService {
    QuizzQuestionRepository quizzQuestionRepository;
    QuizzRepository quizzRepository;
    QuestionRepository questionRepository;
    ModelMapper modelMapper;
    Optional<Quizz> quizz;
    Optional<Question> question;

    // get all question in a quiz
    public List<QuizzQuestionResp> getQuestionsByQuizz(Integer id)
    {
        Quizz quizz = new Quizz();
        quizz.setId(id);
        return quizzQuestionRepository.findAllByQuizz(quizz).stream().map(quizzQuestion -> modelMapper.map(quizzQuestion,QuizzQuestionResp.class)).collect(Collectors.toList());
    }

    // assign a question to a quiz
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

    // update a question assigned to a quiz
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

    // remove a question  assigned to a quiz
    public Integer deleteQuizzQuestion(Integer id)
    {
        Optional<QuizzQuestion> quizzQuestion = quizzQuestionRepository.findById(id);
        return quizzQuestion.map(quizzQuestion1 ->{
            quizzQuestionRepository.delete(quizzQuestion1);
            return 1;
        }).orElse(0);
    }
}
