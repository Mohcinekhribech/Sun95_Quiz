package com.youcode.sunquizz.domains.User.Teacher;

import com.youcode.sunquizz.domains.User.Teacher.DTOs.TeacherReqDTO;
import com.youcode.sunquizz.domains.User.Teacher.DTOs.TeacherRespDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface TeacherServiceInterface {
    TeacherRespDTO createTeacher(TeacherReqDTO teacher);
    Integer deleteTeacher(Integer id);
    TeacherRespDTO updateTeacher(Integer id, TeacherReqDTO teacher);
    TeacherRespDTO getTeacher(Integer id);
    Page<TeacherRespDTO> getAll(Pageable pageable);
    List<TeacherRespDTO> searchByName(String name);
}