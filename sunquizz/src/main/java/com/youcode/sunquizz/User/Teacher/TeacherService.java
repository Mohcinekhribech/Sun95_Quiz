package com.youcode.sunquizz.User.Teacher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeacherService {
    @Autowired
    TeacherRepository teacherRepository;

    public Teacher createTeacher(Teacher teacher)
    {
        return teacherRepository.save(teacher);
    }
    public Integer deleteTeacher(Integer id)
    {
        Optional<Teacher> teacherOptional = teacherRepository.findById(id);
        if(teacherOptional.isPresent())
        {
            teacherRepository.delete(teacherOptional.get());
            return 1;
        }
        return 0;
    }
    public Teacher updateTeacher(Integer id,Teacher teacher)
    {
        if(teacherRepository.findById(id).isPresent())
        {
            teacher.setId(id);
            return teacherRepository.save(teacher);
        }
        return null;
    }
    public List<Teacher> getAll()
    {
        return teacherRepository.findAll();
    }
    public List<Teacher> searchByName(String name)
    {
        return teacherRepository.findAllByFirstNameOrLastName(name,name);
    }
}
