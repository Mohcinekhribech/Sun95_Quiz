package com.youcode.sunquizz.StudentAnswer;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("studentAnswers")
public class StudentAnswerController {
    @Autowired
    StudentAnswerService studentAnswerService;
    @PostMapping
    public ResponseEntity<String> createStudentAnswer(@RequestParam int assignquiz_id, @RequestParam int validation_id)
    {
        studentAnswerService.createStudentAnswer(assignquiz_id,validation_id);
        return ResponseEntity.ok("answer added to the quizz successful");
    }
    @DeleteMapping()
    public ResponseEntity<String> deleteStudentAnswer(@RequestParam int assignquiz_id, @RequestParam int validation_id)
    {
        studentAnswerService.removeStudentAnswer(assignquiz_id,validation_id);
        return ResponseEntity.ok("answer remove from the quizz successful");
    }
}
