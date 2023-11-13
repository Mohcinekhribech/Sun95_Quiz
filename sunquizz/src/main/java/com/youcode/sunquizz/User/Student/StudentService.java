package com.youcode.sunquizz.User.Student;

import com.youcode.sunquizz.User.Student.Student;
import com.youcode.sunquizz.User.Student.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    StudentRepository studentRepository;

    public Student createStudent(Student student)
    {
        return studentRepository.save(student);
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
    public Student updateStudent(Integer id,Student student)
    {
        if(studentRepository.findById(id).isPresent())
        {
            student.setId(id);
            return studentRepository.save(student);
        }
        return null;
    }
    public List<Student> getAll()
    {
        return studentRepository.findAll();
    }
    public List<Student> searchByName(String name)
    {
        return studentRepository.findAllByFirstName(name);
    }
}
