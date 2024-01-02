package com.youcode.sunquizz.domains.Answer;


import com.youcode.sunquizz.domains.Answer.DTOs.AnswerReqDTO;
import com.youcode.sunquizz.domains.Answer.DTOs.AnswerRespDTO;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class AnswerService implements AnswerServiceInterface{
    AnswerRepository answerRepository;
    ModelMapper modelMapper;

    //get One answer
    public AnswerRespDTO getAnswer(Integer id)
    {
        //check if answer exist
        Optional<Answer> answer = answerRepository.findById(id);

        //convert answer entity to  response dto
        return modelMapper.map(answer.orElse(null),AnswerRespDTO.class);
    }

    // get all answers with pagination
    public Page<AnswerRespDTO> getAnswers(Pageable pageable)
    {
        Page<Answer> entityPage = answerRepository.findAll(pageable);
        return entityPage.map(entity -> modelMapper.map(entity, AnswerRespDTO.class));
    }

    //create a answer
    public AnswerRespDTO createAnswer(AnswerReqDTO answer)
    {
        // convert the request dto to answer entity save it and return the response dto
        return modelMapper.map(answerRepository.save(modelMapper.map(answer,Answer.class)),AnswerRespDTO.class);
    }

    //update a answer
    public AnswerRespDTO updateAnswer(AnswerReqDTO answer, Integer id)
    {
        //check if answer exist
        Optional<Answer> existAnswerOptional = answerRepository.findById(id);

        // save the updated data and return the response
        return existAnswerOptional.map(existAnswer -> {
            answer.setId(existAnswer.getId());
            Answer updatedAnswer = answerRepository.save(modelMapper.map(answer, Answer.class));
            return modelMapper.map(updatedAnswer, AnswerRespDTO.class);
        }).orElse(null);
    }

    //delete one answer
    public Integer deleteAnswer(Integer id)
    {
        //check if answer exist
        Optional<Answer> answer = answerRepository.findById(id);
        return answer.map(answer1 -> {
            answerRepository.delete(answer1);
            return 1;
        }).orElse(0);
    }
}
