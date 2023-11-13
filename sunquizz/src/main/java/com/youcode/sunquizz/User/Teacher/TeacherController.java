package com.youcode.sunquizz.User.Teacher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("teacher")
public class TeacherController {
    @Autowired
    TeacherService teacherService;
    @PostMapping
    public ResponseEntity<Teacher> createTeacher(@RequestBody Teacher teacher)
    {
        Teacher teacher1 = teacherService.createTeacher(teacher);
        if(teacher1 != null)
        {
            return ResponseEntity.ok().body(teacher1);
        }
        return ResponseEntity.badRequest().body(null);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Teacher> updateTeacher(@PathVariable Integer id, @RequestBody Teacher teacher)
    {
        Teacher teacher1 = teacherService.updateTeacher(id,teacher);
        if(teacher1 != null)
        {
            return ResponseEntity.ok().body(teacher1);
        }
        return ResponseEntity.badRequest().body(null);
    }
    @GetMapping
    public ResponseEntity<List<Teacher>> getTeachers()
    {
        return ResponseEntity.ok().body(teacherService.getAll());
    }
    @GetMapping("/search/{name}")
    public ResponseEntity<List<Teacher>> getTeacher(@PathVariable String name)
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