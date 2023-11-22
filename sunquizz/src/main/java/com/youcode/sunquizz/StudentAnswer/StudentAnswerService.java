package com.youcode.sunquizz.StudentAnswer;
import com.youcode.sunquizz.AssignQuizz.AssignQuizz;
import com.youcode.sunquizz.AssignQuizz.AssignQuizzRepository;
import com.youcode.sunquizz.User.Teacher.Teacher;
import com.youcode.sunquizz.Validation.DTOs.ValidationRespDTO;
import com.youcode.sunquizz.Validation.Validation;
import com.youcode.sunquizz.Validation.ValidationRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentAnswerService implements StudentAnswerServiceInterface{
    @Autowired
    AssignQuizzRepository assignQuizzRepository;
    @Autowired
    ValidationRepository validationRepository;

    public void createStudentAnswer(int assignQuizz_id,int validation_id)
    {
        AssignQuizz assignQuizz = assignQuizzRepository.findById(assignQuizz_id).orElseThrow(EntityNotFoundException::new);
        Validation validation = validationRepository.findById(validation_id).orElseThrow(EntityNotFoundException::new);

        validation.getAssignQuizzes().add(assignQuizz);
        assignQuizz.getValidations().add(validation);

        assignQuizzRepository.save(assignQuizz);
        validationRepository.save(validation);
    }
    public void removeStudentAnswer(int assignQuizz_id,int validation_id)
    {
        AssignQuizz assignQuizz = assignQuizzRepository.findById(assignQuizz_id).orElseThrow(EntityNotFoundException::new);
        Validation validation = validationRepository.findById(validation_id).orElseThrow(EntityNotFoundException::new);

        validation.getAssignQuizzes().remove(assignQuizz);
        assignQuizz.getValidations().remove(validation);

        assignQuizzRepository.save(assignQuizz);
        validationRepository.save(validation);
    }
}