package com.youcode.sunquizz.AssignQuizz;

import com.youcode.sunquizz.Quizz.Quizz;
import com.youcode.sunquizz.Quizz.QuizzRepository;
import com.youcode.sunquizz.User.Student.Student;
import com.youcode.sunquizz.User.Teacher.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AssignQuizzService {
    @Autowired
    AssignQuizzRepository assignQuizzRepository;

    public List<AssignQuizz> createAssignQuizz(List<AssignQuizz> assignQuizzes)
    {
        return assignQuizzRepository.saveAll(assignQuizzes);
    }
    public Integer deleteAssignQuizz(Integer id)
    {
        Optional<AssignQuizz> assignQuizzOptional = assignQuizzRepository.findById(id);
        if(assignQuizzOptional.isPresent())
        {
            assignQuizzRepository.delete(assignQuizzOptional.get());
            return 1;
        }
        return 0;
    }
    public AssignQuizz updateAssignQuizz(Integer id,AssignQuizz assignQuizz)
    {
        if(assignQuizzRepository.findById(id).isPresent())
        {
            assignQuizz.setId(id);
            return assignQuizzRepository.save(assignQuizz);
        }
        return null;
    }
    public List<AssignQuizz> getAll()
    {
        return assignQuizzRepository.findAll();
    }
    public List<AssignQuizz> getAllByQuizz(Integer id)
    {
        Quizz quizz=new Quizz();
        quizz.setId(id);
        return assignQuizzRepository.findAllByQuizz(quizz);
    }
    public List<AssignQuizz> getAllByStudent(Integer id)
    {
        Student student=new Student();
        student.setId(id);
        return assignQuizzRepository.findAllByStudent(student);
    }
}
