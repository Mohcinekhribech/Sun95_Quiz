package com.youcode.sunquizz.Validation;

import com.youcode.sunquizz.Question.Question;
import com.youcode.sunquizz.Validation.DTOs.ValidationReqDTO;
import com.youcode.sunquizz.Validation.DTOs.ValidationRespDTO;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public interface ValidationServiceInterface {
    ValidationRespDTO getValidation(Integer id);
    List<ValidationRespDTO> getValidations();
    ValidationRespDTO createValidation(ValidationReqDTO validation);

    List<ValidationRespDTO> getAnswersByQuestion(Integer id);
    Integer deleteValidation(Integer id);
}
