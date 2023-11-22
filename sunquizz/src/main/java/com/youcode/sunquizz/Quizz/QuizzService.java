package com.youcode.sunquizz.Quizz;


import com.youcode.sunquizz.Question.Question;
import com.youcode.sunquizz.Quizz.DTOs.QuizzReqDTO;
import com.youcode.sunquizz.Quizz.DTOs.QuizzRespDTO;
import com.youcode.sunquizz.User.Teacher.Teacher;
import com.youcode.sunquizz.User.Teacher.TeacherRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class QuizzService implements QuizzServiceInterface{
    @Autowired
    QuizzRepository quizzRepository;
    @Autowired
    TeacherRepository teacherRepository;
    @Autowired
    ModelMapper modelMapper;
    Optional<Teacher> teacher;
    public QuizzRespDTO createQuizz(QuizzReqDTO quizz)
    {
        Quizz quizzE = modelMapper.map(quizz,Quizz.class);
        teacher = teacherRepository.findById(quizz.getTeacher_id());
        if(teacher.isPresent()){
            quizzE.setTeacher(teacher.get());
            return modelMapper.map(quizzRepository.save(quizzE),QuizzRespDTO.class);
        }
        return null;
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
    public QuizzRespDTO updateQuizz(Integer id, QuizzReqDTO quizz)
    {
        if(quizzRepository.findById(id).isPresent())
        {
            quizz.setId(id);
            return modelMapper.map(quizzRepository.save(modelMapper.map(quizz,Quizz.class)),QuizzRespDTO.class);
        }
        return null;
    }
    public List<QuizzRespDTO> getAll()
    {
        return quizzRepository.findAll()
                .stream()
                .map(quizz -> modelMapper.map(quizz,QuizzRespDTO.class))
                .collect(Collectors.toList());
    }
    public List<QuizzRespDTO> getAllByTeacher(Integer id)
    {
        Teacher teacher=new Teacher();
        teacher.setId(id);
        return quizzRepository.findAllByTeacher(teacher)
                .stream()
                .map(quizz -> modelMapper.map(quizz,QuizzRespDTO.class))
                .collect(Collectors.toList());
    }
}
