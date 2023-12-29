package com.youcode.sunquizz.domains.Quizz;


import com.youcode.sunquizz.domains.Quizz.DTOs.QuizzReqDTO;
import com.youcode.sunquizz.domains.Quizz.DTOs.QuizzRespDTO;
import com.youcode.sunquizz.domains.User.Teacher.Teacher;
import com.youcode.sunquizz.domains.User.Teacher.TeacherRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
        return teacher.map(teacher1 -> {
            quizzE.setTeacher(teacher.get());
            return modelMapper.map(quizzRepository.save(quizzE),QuizzRespDTO.class);
        }).orElse(null);
    }
    public Integer deleteQuizz(Integer id)
    {
        Optional<Quizz> quizzOptional = quizzRepository.findById(id);
        return quizzOptional.map(quizz -> {
            quizzRepository.delete(quizzOptional.get());
            return 1;
        }).orElse(0);
    }
    public QuizzRespDTO updateQuizz(Integer id, QuizzReqDTO quizz)
    {
        Optional<Quizz> quizzOptional = quizzRepository.findById(id);
        return quizzOptional.map(quizz1 -> {
            quizz.setId(id);
            return modelMapper.map(quizzRepository.save(modelMapper.map(quizz,Quizz.class)),QuizzRespDTO.class);
        }).orElse(null);
    }
    public Page<QuizzRespDTO> getAll(Pageable pageable)
    {
        Page<Quizz> entityPage = quizzRepository.findAll(pageable);
        return entityPage.map(entity -> modelMapper.map(entity, QuizzRespDTO.class));
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
    public QuizzRespDTO getQuizz(Integer id)
    {
        Optional<Quizz> quizz = quizzRepository.findById(id);
        return quizz.map(value -> modelMapper.map(value, QuizzRespDTO.class)).orElse(null);
    }
}
