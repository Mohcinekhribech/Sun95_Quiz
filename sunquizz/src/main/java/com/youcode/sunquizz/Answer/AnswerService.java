package com.youcode.sunquizz.Answer;


import com.youcode.sunquizz.Answer.DTOs.AnswerReqDTO;
import com.youcode.sunquizz.Answer.DTOs.AnswerRespDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
    public List<AnswerRespDTO> getAnswers()
    {
        return answerRepository.findAll().stream().map(answer -> modelMapper.map(answer, AnswerRespDTO.class)).collect(Collectors.toList());
    }
    public AnswerRespDTO createAnswer(AnswerReqDTO answer)
    {
        return modelMapper.map(answerRepository.save(modelMapper.map(answer,Answer.class)),AnswerRespDTO.class);
    }
    public AnswerRespDTO updateAnswer(AnswerReqDTO answer, Integer id)
    {
        Optional<Answer> existAnswer = answerRepository.findById(id);
        if(existAnswer.isPresent()) {
            answer.setId(existAnswer.get().getId());
            return modelMapper.map(answerRepository.save(modelMapper.map(answer,Answer.class)),AnswerRespDTO.class);
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
