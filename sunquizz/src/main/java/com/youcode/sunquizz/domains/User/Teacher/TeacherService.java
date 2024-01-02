package com.youcode.sunquizz.domains.User.Teacher;

import com.youcode.sunquizz.domains.User.Teacher.DTOs.TeacherReqDTO;
import com.youcode.sunquizz.domains.User.Teacher.DTOs.TeacherRespDTO;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class TeacherService implements TeacherServiceInterface{
    TeacherRepository teacherRepository;
    ModelMapper modelMapper;

    //create a teacher
    public TeacherRespDTO createTeacher(TeacherReqDTO teacher)
    {
        return modelMapper.map(
                teacherRepository.save(modelMapper.map(
                        teacher,Teacher.class
                )),TeacherRespDTO.class
        );
    }

    // delete a teacher
    public Integer deleteTeacher(Integer id)
    {
        Optional<Teacher> teacherOptional = teacherRepository.findById(id);
        return teacherOptional.map(teacher -> {
            teacherRepository.delete(teacherOptional.get());
            return 1;
        }).orElse(0);
    }

    // update the teacher info
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

    // get one teacher
    public TeacherRespDTO getTeacher(Integer id) {
        Optional<Teacher> teacher = teacherRepository.findById(id);
        return modelMapper.map(teacher.orElse(null), TeacherRespDTO.class);
    }

    // get all teacher , paginated
    public Page<TeacherRespDTO> getAll(Pageable pageable)
    {
        Page<Teacher> entityPage = teacherRepository.findAll(pageable);
        return entityPage.map(entity -> modelMapper.map(entity, TeacherRespDTO.class));
    }

    // search the teachers by name
    public List<TeacherRespDTO> searchByName(String name)
    {
        return teacherRepository.findAllByFirstName(name)
                .stream()
                .map(teacher -> modelMapper.map(teacher,TeacherRespDTO.class))
                .collect(Collectors.toList());
    }
}
