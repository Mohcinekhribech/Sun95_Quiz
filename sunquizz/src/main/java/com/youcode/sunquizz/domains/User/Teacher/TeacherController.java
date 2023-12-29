package com.youcode.sunquizz.domains.User.Teacher;

import com.youcode.sunquizz.domains.User.Teacher.DTOs.TeacherReqDTO;
import com.youcode.sunquizz.domains.User.Teacher.DTOs.TeacherRespDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("teacher")
public class TeacherController {
    @Autowired
    TeacherService teacherService;
    @PostMapping
    public ResponseEntity<TeacherRespDTO> createTeacher(@RequestBody TeacherReqDTO teacher)
    {
        TeacherRespDTO teacher1 = teacherService.createTeacher(teacher);
        if(teacher1 != null)
        {
            return ResponseEntity.ok().body(teacher1);
        }
        return ResponseEntity.badRequest().body(null);
    }
    @PutMapping("/{id}")
    public ResponseEntity<TeacherRespDTO> updateTeacher(@PathVariable Integer id, @RequestBody TeacherReqDTO teacher)
    {
        TeacherRespDTO teacher1 = teacherService.updateTeacher(id,teacher);
        if(teacher1 != null)
        {
            return ResponseEntity.ok().body(teacher1);
        }
        return ResponseEntity.badRequest().body(null);
    }
    @GetMapping
    public ResponseEntity<Page<TeacherRespDTO>> getTeachers(Pageable pageable)
    {
        return ResponseEntity.ok().body(teacherService.getAll(pageable));
    }
    @GetMapping("/{id}")
    public ResponseEntity<TeacherRespDTO> getTeacher(@PathVariable Integer id)
    {
        return ResponseEntity.ok().body(teacherService.getTeacher(id));
    }
    @GetMapping("/search/{name}")
    public ResponseEntity<List<TeacherRespDTO>> getTeacher(@PathVariable String name)
    {
        return ResponseEntity.ok().body(teacherService.searchByName(name));
    }
    @DeleteMapping("delete/{id}")
    public ResponseEntity<String> deleteTeacher(@PathVariable Integer id)
    {
        Integer deleted = teacherService.deleteTeacher(id);
        if(deleted == 1){
            return ResponseEntity.ok().body("Teacher deleted ?");
        }
        return ResponseEntity.ok().body("Teacher not deleted ?");
    }
}