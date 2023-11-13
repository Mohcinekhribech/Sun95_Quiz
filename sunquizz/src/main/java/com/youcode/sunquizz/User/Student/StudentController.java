package com.youcode.sunquizz.User.Student;

import com.youcode.sunquizz.User.Student.Student;
import com.youcode.sunquizz.User.Student.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    StudentService studentService;
    @PostMapping
    public ResponseEntity<Student> createStudent(@RequestBody Student student)
    {
        Student student1 = studentService.createStudent(student);
        if(student1 != null)
        {
            return ResponseEntity.ok().body(student1);
        }
        return ResponseEntity.badRequest().body(null);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable Integer id, @RequestBody Student student)
    {
        Student student1 = studentService.updateStudent(id,student);
        if(student1 != null)
        {
            return ResponseEntity.ok().body(student1);
        }
        return ResponseEntity.badRequest().body(null);
    }
    @GetMapping
    public ResponseEntity<List<Student>> getStudents()
    {
        return ResponseEntity.ok().body(studentService.getAll());
    }
    @GetMapping("/search/{name}")
    public ResponseEntity<List<Student>> getStudent(@PathVariable String name)
    {
        return ResponseEntity.ok().body(studentService.searchByName(name));
    }
    @DeleteMapping("delete/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable Integer id)
    {
        Integer deleted = studentService.deleteStudent(id);
        if(deleted == 1){
            return ResponseEntity.ok().body("Student deleted ?");
        }
        return ResponseEntity.ok().body("Student not deleted ?");
    }
}
