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
    StudentRepository teacherRepository;

    public Student createStudent(Student teacher)
    {
        return teacherRepository.save(teacher);
    }
    public Integer deleteStudent(Integer id)
    {
        Optional<Student> teacherOptional = teacherRepository.findById(id);
        if(teacherOptional.isPresent())
        {
            teacherRepository.delete(teacherOptional.get());
            return 1;
        }
        return 0;
    }
    public Student updateStudent(Integer id,Student teacher)
    {
        if(teacherRepository.findById(id).isPresent())
        {
            teacher.setId(id);
            return teacherRepository.save(teacher);
        }
        return null;
    }
    public List<Student> getAll()
    {
        return teacherRepository.findAll();
    }
    public List<Student> searchByName(String name)
    {
        return teacherRepository.findAllByFirstNameOrLastName(name,name);
    }
}
