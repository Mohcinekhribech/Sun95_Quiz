package com.youcode.sunquizz.domains.StudentAnswer;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("studentAnswers")
public class StudentAnswerController {
    @Autowired
    StudentAnswerService studentAnswerService;
    @PostMapping("/{assignquiz_id}/{validation_id}")
    public ResponseEntity<String> createStudentAnswer(@PathVariable Integer assignquiz_id, @PathVariable Integer validation_id)
    {
        studentAnswerService.createStudentAnswer(assignquiz_id,validation_id);
        return ResponseEntity.ok().body("answer added to the quizz successful");
    }
    @DeleteMapping()
    public ResponseEntity<String> deleteStudentAnswer(@RequestParam int assignquiz_id, @RequestParam int validation_id)
    {
        studentAnswerService.removeStudentAnswer(assignquiz_id,validation_id);
        return ResponseEntity.ok("answer remove from the quizz successful");
    }
}
