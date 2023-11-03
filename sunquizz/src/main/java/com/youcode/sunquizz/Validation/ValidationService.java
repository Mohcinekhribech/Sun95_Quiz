package com.youcode.sunquizz.Validation;

import com.youcode.sunquizz.Question.Question;
import com.youcode.sunquizz.Question.QuestionRepository;
import com.youcode.sunquizz.Validation.Validation;
import com.youcode.sunquizz.Validation.ValidationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ValidationService {
    ValidationRepository validationRepository;
    @Autowired
    public ValidationService(ValidationRepository validationRepository)
    {
        this.validationRepository = validationRepository;
    }
    public Validation getValidation(Integer id)
    {
        Optional<Validation> validation = validationRepository.findById(id);
        if (validation.isPresent()) {
            return validation.get();
        }
        return null;
    }
    public List<Validation> getValidations()
    {
        return validationRepository.findAll();
    }
    public Validation createValidation(Validation validation)
    {
        return validationRepository.save(validation);
    }

    public List<Validation> getAnswersByQuestion(Integer id)
    {
        Question question = new Question();
        question.setId(id);
        return validationRepository.findAllByQuestion(question);
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
