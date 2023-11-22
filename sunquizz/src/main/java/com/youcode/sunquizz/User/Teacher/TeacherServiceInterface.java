package com.youcode.sunquizz.User.Teacher;

import com.youcode.sunquizz.User.Teacher.DTOs.TeacherReqDTO;
import com.youcode.sunquizz.User.Teacher.DTOs.TeacherRespDTO;

import java.util.List;

public interface TeacherServiceInterface {
    TeacherRespDTO createTeacher(TeacherReqDTO teacher);
    Integer deleteTeacher(Integer id);
    TeacherRespDTO updateTeacher(Integer id, TeacherReqDTO teacher);
    List<TeacherRespDTO> getAll();
    List<TeacherRespDTO> searchByName(String name);
}