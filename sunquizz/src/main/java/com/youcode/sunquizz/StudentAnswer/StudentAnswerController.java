package com.youcode.sunquizz.StudentAnswer;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("student/answers")
public class StudentAnswerController {
    @Autowired
    StudentAnswerService studentAnswerService;
    @PostMapping
    public ResponseEntity<StudentAnswer> createStudentAnswer(@RequestBody StudentAnswer studentAnswer)
    {
        StudentAnswer studentAnswer1 = studentAnswerService.createStudentAnswer(studentAnswer);
        if(studentAnswer1 != null)
        {
            return ResponseEntity.ok().body(studentAnswer1);
        }
        return ResponseEntity.badRequest().body(null);
    }
    @PutMapping("/{id}")
    public ResponseEntity<StudentAnswer> updateStudentAnswer(@PathVariable Integer id, @RequestBody StudentAnswer studentAnswer)
    {
        StudentAnswer studentAnswer1 = studentAnswerService.updateStudentAnswer(id,studentAnswer);;
        if(studentAnswer1 != null)
        {
            return ResponseEntity.ok().body(studentAnswer1);
        }
        return ResponseEntity.badRequest().body(null);
    }
    @GetMapping("/{id}")
    public ResponseEntity<List<StudentAnswer>> getStudentAnswer(@PathVariable Integer id)
    {
        return ResponseEntity.ok().body(studentAnswerService.getAllAnswersByStudent(id));
    }
    @DeleteMapping("delete/{id}")
    public ResponseEntity<String> deleteStudentAnswer(@PathVariable Integer id)
    {
        Integer deleted = studentAnswerService.deleteStudentAnswer(id);
        if(deleted == 1)
        {
            return ResponseEntity.ok().body("answer is removed from answers of student");
        }
        return ResponseEntity.badRequest().body("answer  not removed from answers of student");
    }
}
