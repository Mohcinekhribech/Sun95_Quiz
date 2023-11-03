package com.youcode.sunquizz.Answer;

import com.youcode.sunquizz.Answer.Answer;
import com.youcode.sunquizz.Answer.AnswerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AnswerService {
    AnswerRepository answerRepository;
    @Autowired
    public AnswerService(AnswerRepository answerRepository)
    {
        this.answerRepository = answerRepository;
    }
    public Answer getAnswer(Integer id)
    {
        Optional<Answer> answer = answerRepository.findById(id);
        if (answer.isPresent()) {
            return answer.get();
        }
        return null;
    }
    public List<Answer> getAnswers()
    {
        return answerRepository.findAll();
    }
    public Answer createAnswer(Answer answer)
    {
        return answerRepository.save(answer);
    }
    public Answer updateAnswer(Answer answer,Integer id)
    {
        Optional<Answer> existAnswer = answerRepository.findById(id);
        if(existAnswer.isPresent()) {
            answer.setId(existAnswer.get().getId());
            return answerRepository.save(answer);
        }
        return null;
    }
    public Integer deleteAnswer(Integer id)
    {
        Optional<Answer> answer = answerRepository.findById(id);
        if(answer.isPresent()) {
            answerRepository.delete(answer.get());
            return 1;
        }else return 0;
    }
}
