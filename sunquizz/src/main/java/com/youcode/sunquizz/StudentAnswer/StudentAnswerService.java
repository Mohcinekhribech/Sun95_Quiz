package com.youcode.sunquizz.StudentAnswer;
import com.youcode.sunquizz.AssignQuizz.AssignQuizz;
import com.youcode.sunquizz.User.Teacher.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentAnswerService {
    @Autowired
    StudentAnswerRepository studentAnswerRepository;

    public StudentAnswer createStudentAnswer(StudentAnswer studentAnswer)
    {
        return studentAnswerRepository.save(studentAnswer);
    }
    public Integer deleteStudentAnswer(Integer id)
    {
        Optional<StudentAnswer> studentAnswerOptional = studentAnswerRepository.findById(id);
        if(studentAnswerOptional.isPresent())
        {
            studentAnswerRepository.delete(studentAnswerOptional.get());
            return 1;
        }
        return 0;
    }
    public StudentAnswer updateStudentAnswer(Integer id,StudentAnswer studentAnswer)
    {
        if(studentAnswerRepository.findById(id).isPresent())
        {
            studentAnswer.setId(id);
            return studentAnswerRepository.save(studentAnswer);
        }
        return null;
    }
    public List<StudentAnswer> getAllAnswersByStudent(Integer id)
    {
        AssignQuizz assignQuizz=new AssignQuizz();
        assignQuizz.setId(id);
        return studentAnswerRepository.findAllByAssignQuizz(assignQuizz);
    }
}