package com.youcode.sunquizz.domains.StudentAnswer;

public interface StudentAnswerServiceInterface {
    void createStudentAnswer(Integer assignQuizz_id,Integer validation_id);
    void removeStudentAnswer(int assignQuizz_id,int validation_id);
}
