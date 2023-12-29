package com.youcode.sunquizz.domains.Validation;

import com.youcode.sunquizz.domains.Answer.AnswerRepository;
import com.youcode.sunquizz.domains.Question.Question;
import com.youcode.sunquizz.domains.Question.QuestionRepository;
import com.youcode.sunquizz.domains.Validation.DTOs.ValidationReqDTO;
import com.youcode.sunquizz.domains.Validation.DTOs.ValidationRespDTO;
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
                    answerRepository.findById(validation.getAnswer_id()).orElse(null)
            );
        }

        if (validation.getQuestion_id()!=0){
            validationE.setQuestion(
                    questionRepository.findById(validation.getQuestion_id()).orElse(null)
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
        return validation.map(validation1 -> {
            validationRepository.delete(validation.get());
            return 1;
        }).orElse(0);
    }
}
