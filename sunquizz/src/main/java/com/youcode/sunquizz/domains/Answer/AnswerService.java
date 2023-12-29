package com.youcode.sunquizz.domains.Answer;


import com.youcode.sunquizz.domains.Answer.DTOs.AnswerReqDTO;
import com.youcode.sunquizz.domains.Answer.DTOs.AnswerRespDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AnswerService implements AnswerServiceInterface{
    AnswerRepository answerRepository;
    ModelMapper modelMapper;

    @Autowired
    public AnswerService(AnswerRepository answerRepository,ModelMapper modelMapper)
    {
        this.answerRepository = answerRepository;
        this.modelMapper = modelMapper;
    }
    public AnswerRespDTO getAnswer(Integer id)
    {
        Optional<Answer> answer = answerRepository.findById(id);
        return modelMapper.map(answer.orElse(null),AnswerRespDTO.class);
    }
    public Page<AnswerRespDTO> getAnswers(Pageable pageable)
    {
        Page<Answer> entityPage = answerRepository.findAll(pageable);
        return entityPage.map(entity -> modelMapper.map(entity, AnswerRespDTO.class));}
    public AnswerRespDTO createAnswer(AnswerReqDTO answer)
    {
        return modelMapper.map(answerRepository.save(modelMapper.map(answer,Answer.class)),AnswerRespDTO.class);
    }
    public AnswerRespDTO updateAnswer(AnswerReqDTO answer, Integer id)
    {
        Optional<Answer> existAnswerOptional = answerRepository.findById(id);

        return existAnswerOptional.map(existAnswer -> {
            answer.setId(existAnswer.getId());
            Answer updatedAnswer = answerRepository.save(modelMapper.map(answer, Answer.class));
            return modelMapper.map(updatedAnswer, AnswerRespDTO.class);
        }).orElse(null);
    }
    public Integer deleteAnswer(Integer id)
    {
        Optional<Answer> answer = answerRepository.findById(id);
        return answer.map(answer1 -> {
            answerRepository.delete(answer1);
            return 1;
        }).orElse(0);
    }
}
