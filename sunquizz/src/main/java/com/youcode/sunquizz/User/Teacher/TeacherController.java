package com.youcode.sunquizz.User.Teacher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("teacher")
public class TeacherController {
    @Autowired
    TeacherService teacherService;
    @PostMapping
    public Teacher createTeacher(@RequestBody Teacher teacher)
    {
        return teacherService.createTeacher(teacher);
    }
    @PutMapping("/{id}")
    public Teacher updateTeacher(@PathVariable Integer id, @RequestBody Teacher teacher)
    {
        return teacherService.updateTeacher(id,teacher);
    }
    @GetMapping
    public List<Teacher> getTeachers()
    {
        return teacherService.getAll();
    }
    @GetMapping("/search/{name}")
    public List<Teacher> getTeacher(@PathVariable String name)
    {
        return teacherService.searchByName(name);
    }
    @DeleteMapping("delete/{id}")
    public Integer deleteTeacher(@PathVariable Integer id)
    {
        return teacherService.deleteTeacher(id);
    }
}