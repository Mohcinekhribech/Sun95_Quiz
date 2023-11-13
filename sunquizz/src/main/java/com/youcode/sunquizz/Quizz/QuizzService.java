package com.youcode.sunquizz.Quizz;


import com.youcode.sunquizz.User.Teacher.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuizzService {
    @Autowired
    QuizzRepository quizzRepository;

    public Quizz createQuizz(Quizz quizz)
    {
        return quizzRepository.save(quizz);
    }
    public Integer deleteQuizz(Integer id)
    {
        Optional<Quizz> quizzOptional = quizzRepository.findById(id);
        if(quizzOptional.isPresent())
        {
            quizzRepository.delete(quizzOptional.get());
            return 1;
        }
        return 0;
    }
    public Quizz updateQuizz(Integer id,Quizz quizz)
    {
        if(quizzRepository.findById(id).isPresent())
        {
            quizz.setId(id);
            return quizzRepository.save(quizz);
        }
        return null;
    }
    public List<Quizz> getAll()
    {
        return quizzRepository.findAll();
    }
    public List<Quizz> getAllByTeacher(Integer id)
    {
        Teacher teacher=new Teacher();
        teacher.setId(id);
        return quizzRepository.findAllByTeacher(teacher);
    }
}
