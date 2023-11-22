package com.youcode.sunquizz.User.Teacher;

import com.youcode.sunquizz.User.Teacher.DTOs.TeacherReqDTO;
import com.youcode.sunquizz.User.Teacher.DTOs.TeacherRespDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TeacherService implements TeacherServiceInterface{
    @Autowired
    TeacherRepository teacherRepository;
    @Autowired
    ModelMapper modelMapper;

    public TeacherRespDTO createTeacher(TeacherReqDTO teacher)
    {
        return modelMapper.map(
                teacherRepository.save(modelMapper.map(
                        teacher,Teacher.class
                )),TeacherRespDTO.class
        );
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
    public TeacherRespDTO updateTeacher(Integer id, TeacherReqDTO teacher)
    {
        if(teacherRepository.findById(id).isPresent())
        {
            teacher.setId(id);
            return modelMapper.map(
                    teacherRepository.save(modelMapper.map(
                            teacher,Teacher.class
                    )),TeacherRespDTO.class
            );
        }
        return null;
    }
    public List<TeacherRespDTO> getAll()
    {
        return teacherRepository.findAll()
                .stream()
                .map(teacher -> modelMapper.map(teacher,TeacherRespDTO.class))
                .collect(Collectors.toList());
    }
    public List<TeacherRespDTO> searchByName(String name)
    {
        return teacherRepository.findAllByFirstName(name)
                .stream()
                .map(teacher -> modelMapper.map(teacher,TeacherRespDTO.class))
                .collect(Collectors.toList());
    }
}
