package com.youcode.sunquizz.domains.StudentAnswer;
import com.youcode.sunquizz.domains.AssignQuizz.AssignQuizz;
import com.youcode.sunquizz.domains.AssignQuizz.AssignQuizzRepository;
import com.youcode.sunquizz.domains.Validation.Validation;
import com.youcode.sunquizz.domains.Validation.ValidationRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class StudentAnswerService implements StudentAnswerServiceInterface{
    AssignQuizzRepository assignQuizzRepository;
    ValidationRepository validationRepository;

    // save a student answer in a quiz
    public void createStudentAnswer(Integer assignQuizz_id,Integer validation_id)
    {
        AssignQuizz assignQuizz = assignQuizzRepository.findById(assignQuizz_id).orElseThrow(EntityNotFoundException::new);
        Validation validation = validationRepository.findById(validation_id).orElseThrow(EntityNotFoundException::new);

        validation.getAssignQuizzes().add(assignQuizz);
        assignQuizz.getValidations().add(validation);

        assignQuizzRepository.save(assignQuizz);
        validationRepository.save(validation);
    }

    // remove a student answer from  a quiz
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