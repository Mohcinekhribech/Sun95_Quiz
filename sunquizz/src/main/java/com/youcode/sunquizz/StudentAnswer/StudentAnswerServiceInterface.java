package com.youcode.sunquizz.StudentAnswer;

import com.youcode.sunquizz.AssignQuizz.AssignQuizz;
import com.youcode.sunquizz.Validation.Validation;
import jakarta.persistence.EntityNotFoundException;

public interface StudentAnswerServiceInterface {
    void createStudentAnswer(int assignQuizz_id,int validation_id);
    void removeStudentAnswer(int assignQuizz_id,int validation_id);
}
