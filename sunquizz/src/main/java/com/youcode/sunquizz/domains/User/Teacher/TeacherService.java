package com.youcode.sunquizz.domains.User.Teacher;

import com.youcode.sunquizz.domains.User.Teacher.DTOs.TeacherReqDTO;
import com.youcode.sunquizz.domains.User.Teacher.DTOs.TeacherRespDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
        return teacherOptional.map(teacher -> {
            teacherRepository.delete(teacherOptional.get());
            return 1;
        }).orElse(0);
    }
    public TeacherRespDTO updateTeacher(Integer id, TeacherReqDTO teacher)
    {
        Optional<Teacher> teacherOptional = teacherRepository.findById(id);
        return teacherOptional.map(teacher1 -> {
            teacher.setId(id);
            return modelMapper.map(
                    teacherRepository.save(modelMapper.map(
                            teacher,Teacher.class
                    )),TeacherRespDTO.class
            );
        }).orElse(null);
    }

    @Override
    public TeacherRespDTO getTeacher(Integer id) {
        Optional<Teacher> teacher = teacherRepository.findById(id);
        return modelMapper.map(teacher.orElse(null), TeacherRespDTO.class);
    }

    public Page<TeacherRespDTO> getAll(Pageable pageable)
    {
        Page<Teacher> entityPage = teacherRepository.findAll(pageable);
        return entityPage.map(entity -> modelMapper.map(entity, TeacherRespDTO.class));
    }
    public List<TeacherRespDTO> searchByName(String name)
    {
        return teacherRepository.findAllByFirstName(name)
                .stream()
                .map(teacher -> modelMapper.map(teacher,TeacherRespDTO.class))
                .collect(Collectors.toList());
    }
}
