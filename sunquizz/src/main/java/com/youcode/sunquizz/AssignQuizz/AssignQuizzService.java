package com.youcode.sunquizz.AssignQuizz;

import com.youcode.sunquizz.AssignQuizz.DTOs.AssignQuizzReqDTO;
import com.youcode.sunquizz.AssignQuizz.DTOs.AssignQuizzRespDTO;
import com.youcode.sunquizz.Question.DTOs.QuestionRespDTO;
import com.youcode.sunquizz.Question.Question;
import com.youcode.sunquizz.Quizz.Quizz;
import com.youcode.sunquizz.Quizz.QuizzRepository;
import com.youcode.sunquizz.User.Student.Student;
import com.youcode.sunquizz.User.Student.StudentRepository;
import com.youcode.sunquizz.User.Teacher.Teacher;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AssignQuizzService {
    @Autowired
    AssignQuizzRepository assignQuizzRepository;
    @Autowired
    ModelMapper modelMapper;
    @Autowired
    QuizzRepository quizzRepository;
    @Autowired
    StudentRepository studentRepository;
    Optional<Quizz> quizz;
    Optional<Student> student;

    public List<AssignQuizzRespDTO> createAssignQuizz(List<AssignQuizzReqDTO> assignQuizzes)
    {
        List<AssignQuizz> assignQuizzes1 = assignQuizzes.stream()
                .map(assignQuizze -> {
                    AssignQuizz assignQuizzE =  modelMapper.map(assignQuizze,AssignQuizz.class);
                    quizz = quizzRepository.findById(assignQuizze.getQuizz_id());
                    student = studentRepository.findById(assignQuizze.getStudent_id());
                    if(quizz.isPresent() && student.isPresent()){
                        assignQuizzE.setQuizz(quizz.get());
                        assignQuizzE.setStudent(student.get());
                    }
                    return assignQuizzE;
                }).collect(Collectors.toList());
        return assignQuizzRepository.saveAll(assignQuizzes1)
                .stream()
                .map(assignQuizz -> modelMapper.map(assignQuizz,AssignQuizzRespDTO.class))
                .collect(Collectors.toList());
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
    public AssignQuizzRespDTO updateAssignQuizz(Integer id,AssignQuizzReqDTO assignQuizz)
    {
        if(assignQuizzRepository.findById(id).isPresent())
        {
            assignQuizz.setId(id);
            return modelMapper.map(
                    assignQuizzRepository.save(modelMapper.map(assignQuizz,AssignQuizz.class)),
                    AssignQuizzRespDTO.class
            );
        }
        return null;
    }
    public List<AssignQuizzRespDTO> getAll()
    {
        return assignQuizzRepository.findAll()
                .stream()
                .map(assignQuizz -> modelMapper.map(assignQuizz,AssignQuizzRespDTO.class))
                .collect(Collectors.toList());
    }
    public List<AssignQuizzRespDTO> getAllByQuizz(Integer id)
    {
        Quizz quizz=new Quizz();
        quizz.setId(id);
        return assignQuizzRepository.findAllByQuizz(quizz)
                .stream()
                .map(assignQuizz -> modelMapper.map(assignQuizz,AssignQuizzRespDTO.class))
                .collect(Collectors.toList());
    }
    public List<AssignQuizzRespDTO> getAllByStudent(Integer id)
    {
        Student student=new Student();
        student.setId(id);
        return assignQuizzRepository.findAllByStudent(student)
                .stream()
                .map(assignQuizz -> modelMapper.map(assignQuizz,AssignQuizzRespDTO.class))
                .collect(Collectors.toList());
    }
}
