package com.youcode.sunquizz.User.Student;

import com.youcode.sunquizz.User.Student.Student;
import com.youcode.sunquizz.User.Student.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {
    @Autowired
    StudentService studentService;
    @PostMapping
    public Student createStudent(@RequestBody Student student)
    {
        return studentService.createStudent(student);
    }
    @PutMapping("/{id}")
    public Student updateStudent(@PathVariable Integer id, @RequestBody Student student)
    {
        return studentService.updateStudent(id,student);
    }
    @GetMapping
    public List<Student> getStudents()
    {
        return studentService.getAll();
    }
    @GetMapping("/search/{name}")
    public List<Student> getStudent(@PathVariable String name)
    {
        return studentService.searchByName(name);
    }
    @DeleteMapping("delete/{id}")
    public Integer deleteStudent(@PathVariable Integer id)
    {
        return studentService.deleteStudent(id);
    }
}
