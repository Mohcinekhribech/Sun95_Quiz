package com.youcode.sunquizz.domains.User.Student;

import com.youcode.sunquizz.domains.User.Student.DTOs.StudentReqDTO;
import com.youcode.sunquizz.domains.User.Student.DTOs.StudentRespDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
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
        student.setRegistrationDate(LocalDate.now());
        return modelMapper.map(
                studentRepository.save(modelMapper.map(student,Student.class)),
                StudentRespDTO.class
        );
    }
    public Integer deleteStudent(Integer id)
    {
        Optional<Student> studentOptional = studentRepository.findById(id);
        return studentOptional.map(student -> {
            studentRepository.delete(studentOptional.get());
            return 1;
        }).orElse(0);
    }

    public StudentRespDTO getStudent(Integer id) {
        Optional<Student> student = studentRepository.findById(id);
        return modelMapper.map(student.orElse(null), StudentRespDTO.class);
    }
    public StudentRespDTO updateStudent(Integer id,StudentReqDTO student)
    {
        Optional<Student> studentOptional = studentRepository.findById(id);
        return studentOptional.map(student1 -> {
            student.setId(id);
            return modelMapper.map(
                    studentRepository.save(modelMapper.map(student,Student.class)),
                    StudentRespDTO.class
            );
        }).orElse(null);
    }
    public Page<StudentRespDTO> getAll(Pageable pageable)
    {
        Page<Student> entityPage = studentRepository.findAll(pageable);
        return entityPage.map(entity -> modelMapper.map(entity, StudentRespDTO.class));
    }
    public List<StudentRespDTO> searchByName(String name)
    {
        return studentRepository.findAllByFirstName(name)
                .stream()
                .map(student -> modelMapper.map(student,StudentRespDTO.class))
                .collect(Collectors.toList());
    }
}
