package com.youcode.sunquizz.domains.User.Student;

import com.youcode.sunquizz.domains.User.Student.DTOs.StudentReqDTO;
import com.youcode.sunquizz.domains.User.Student.DTOs.StudentRespDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    StudentService studentService;
    @PostMapping
    public ResponseEntity<StudentRespDTO> createStudent(@RequestBody StudentReqDTO student)
    {
        StudentRespDTO student1 = studentService.createStudent(student);
        if(student1 != null)
        {
            return ResponseEntity.ok().body(student1);
        }
        return ResponseEntity.badRequest().body(null);
    }
    @PutMapping("/{id}")
    public ResponseEntity<StudentRespDTO> updateStudent(@PathVariable Integer id, @RequestBody StudentReqDTO student)
    {
        StudentRespDTO student1 = studentService.updateStudent(id,student);
        if(student1 != null)
        {
            return ResponseEntity.ok().body(student1);
        }
        return ResponseEntity.badRequest().body(null);
    }
    @GetMapping("/{id}")
    public ResponseEntity<StudentRespDTO> getTeacher(@PathVariable Integer id)
    {
        return ResponseEntity.ok().body(studentService.getStudent(id));
    }
    @GetMapping
    public ResponseEntity<Page<StudentRespDTO>> getStudents(Pageable pageable)
    {
        return ResponseEntity.ok().body(studentService.getAll(pageable));
    }
    @GetMapping("/search/{name}")
    public ResponseEntity<List<StudentRespDTO>> getStudent(@PathVariable String name)
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
