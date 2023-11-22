package com.youcode.sunquizz.Validation;

import com.youcode.sunquizz.Answer.AnswerRepository;
import com.youcode.sunquizz.Answer.DTOs.AnswerRespDTO;
import com.youcode.sunquizz.Question.Question;
import com.youcode.sunquizz.Question.QuestionRepository;
import com.youcode.sunquizz.Validation.DTOs.ValidationReqDTO;
import com.youcode.sunquizz.Validation.DTOs.ValidationRespDTO;
import com.youcode.sunquizz.Validation.Validation;
import com.youcode.sunquizz.Validation.ValidationRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ValidationService implements  ValidationServiceInterface{
    ValidationRepository validationRepository;
    @Autowired
    ModelMapper modelMapper;

    @Autowired
    private AnswerRepository answerRepository;

    @Autowired
    private QuestionRepository questionRepository;
    @Autowired
    public ValidationService(ValidationRepository validationRepository)
    {
        this.validationRepository = validationRepository;
    }
    public ValidationRespDTO getValidation(Integer id)
    {
        Optional<Validation> validation = validationRepository.findById(id);
        return modelMapper.map(validation.orElse(null),ValidationRespDTO.class);
    }
    public List<ValidationRespDTO> getValidations()
    {
        return validationRepository.findAll().stream().map(validation -> modelMapper.map(validation, ValidationRespDTO.class)).collect(Collectors.toList());
    }
    public ValidationRespDTO createValidation(ValidationReqDTO validation)
    {
        Validation validationE = modelMapper.map(validation,Validation.class);

        if(validation.getAnswer_id()>0){
            validationE.setAnswer(
                    answerRepository.findById(validation.getAnswer_id()).get()
            );
        }

        if (validation.getQuestion_id()!=0){
            validationE.setQuestion(
                    questionRepository.findById(validation.getQuestion_id()).get()
            );
        }

        validationE = validationRepository.save(validationE);
        return modelMapper.map(validationE,ValidationRespDTO.class);
    }

    public List<ValidationRespDTO> getAnswersByQuestion(Integer id)
    {
        Question question = new Question();
        question.setId(id);
        return validationRepository.findAllByQuestion(question).stream().map(validation -> modelMapper.map(validation, ValidationRespDTO.class)).collect(Collectors.toList());
    }
    public Integer deleteValidation(Integer id)
    {
        Optional<Validation> validation = validationRepository.findById(id);
        if(validation.isPresent()) {
            validationRepository.delete(validation.get());
            return 1;
        }else return 0;
    }
}
