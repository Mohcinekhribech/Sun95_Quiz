package com.youcode.sunquizz.StudentAnswer;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("student/answers")
public class StudentAnswerController {
    @Autowired
    StudentAnswerService studentAnswerService;
    @PostMapping
    public StudentAnswer createStudentAnswer(@RequestBody StudentAnswer studentAnswer)
    {
        return studentAnswerService.createStudentAnswer(studentAnswer);
    }
    @PutMapping("/{id}")
    public StudentAnswer updateStudentAnswer(@PathVariable Integer id, @RequestBody StudentAnswer studentAnswer)
    {
        return studentAnswerService.updateStudentAnswer(id,studentAnswer);
    }
    @GetMapping("/{id}")
    public List<StudentAnswer> getStudentAnswer(@PathVariable Integer id)
    {
        return studentAnswerService.getAllAnswersByStudent(id);
    }
    @DeleteMapping("delete/{id}")
    public Integer deleteStudentAnswer(@PathVariable Integer id)
    {
        return studentAnswerService.deleteStudentAnswer(id);
    }
}
