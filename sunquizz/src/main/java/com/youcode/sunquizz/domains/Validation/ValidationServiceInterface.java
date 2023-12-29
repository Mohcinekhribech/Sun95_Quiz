package com.youcode.sunquizz.domains.Validation;

import com.youcode.sunquizz.domains.Validation.DTOs.ValidationReqDTO;
import com.youcode.sunquizz.domains.Validation.DTOs.ValidationRespDTO;

import java.util.List;

public interface ValidationServiceInterface {
    ValidationRespDTO getValidation(Integer id);
    List<ValidationRespDTO> getValidations();
    ValidationRespDTO createValidation(ValidationReqDTO validation);

    List<ValidationRespDTO> getAnswersByQuestion(Integer id);
    Integer deleteValidation(Integer id);
}
