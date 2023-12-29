package com.youcode.sunquizz.domains.User.Student;

import com.youcode.sunquizz.domains.User.Student.DTOs.StudentReqDTO;
import com.youcode.sunquizz.domains.User.Student.DTOs.StudentRespDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface StudentServiceInterface {
    StudentRespDTO createStudent(StudentReqDTO teacher);
    Integer deleteStudent(Integer id);
    StudentRespDTO updateStudent(Integer id, StudentReqDTO teacher);
    Page<StudentRespDTO> getAll(Pageable pageable);
    StudentRespDTO getStudent(Integer id);
    List<StudentRespDTO> searchByName(String name);
}
