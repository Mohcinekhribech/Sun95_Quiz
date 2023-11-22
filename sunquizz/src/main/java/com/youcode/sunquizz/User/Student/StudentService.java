package com.youcode.sunquizz.User.Student;

import com.youcode.sunquizz.User.Student.DTOs.StudentReqDTO;
import com.youcode.sunquizz.User.Student.DTOs.StudentRespDTO;
import com.youcode.sunquizz.User.Student.Student;
import com.youcode.sunquizz.User.Student.StudentRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StudentService implements StudentServiceInterface{
    @Autowired
    StudentRepository studentRepository;
    @Autowired
    ModelMapper modelMapper;

    public StudentRespDTO createStudent(StudentReqDTO student)
    {
        return modelMapper.map(
                studentRepository.save(modelMapper.map(student,Student.class)),
                StudentRespDTO.class
        );
    }
    public Integer deleteStudent(Integer id)
    {
        Optional<Student> studentOptional = studentRepository.findById(id);
        if(studentOptional.isPresent())
        {
            studentRepository.delete(studentOptional.get());
            return 1;
        }
        return 0;
    }
    public StudentRespDTO updateStudent(Integer id,StudentReqDTO student)
    {
        if(studentRepository.findById(id).isPresent())
        {
            student.setId(id);
            return modelMapper.map(
                    studentRepository.save(modelMapper.map(student,Student.class)),
                    StudentRespDTO.class
            );
        }
        return null;
    }
    public List<StudentRespDTO> getAll()
    {
        return studentRepository.findAll()
                .stream()
                .map(student -> modelMapper.map(student,StudentRespDTO.class))
                .collect(Collectors.toList());
    }
    public List<StudentRespDTO> searchByName(String name)
    {
        return studentRepository.findAllByFirstName(name)
                .stream()
                .map(student -> modelMapper.map(student,StudentRespDTO.class))
                .collect(Collectors.toList());
    }
}
