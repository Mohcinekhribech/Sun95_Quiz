package com.youcode.sunquizz.Answer;

import com.youcode.sunquizz.Answer.Answer;
import com.youcode.sunquizz.Answer.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/answer")
public class AnswerController {
    @Autowired
    AnswerService answerService;
    @PostMapping
    public ResponseEntity<Answer> createAnswer(@RequestBody Answer answer)
    {
        Answer answer1 = answerService.createAnswer(answer);
        if(answer1 != null)
        {
            return ResponseEntity.ok().body(answer1);
        }
        return ResponseEntity.badRequest().body(null);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Answer> updateAnswer(@PathVariable Integer id, @RequestBody Answer answer)
    {
        Answer answer1 = answerService.updateAnswer(answer,id);
        if(answer != null)
        {
        return ResponseEntity.ok().body(answer1);
        }
        return ResponseEntity.badRequest().body(null);
    }
    @GetMapping
    public ResponseEntity<List<Answer>> getAnswers()
    {
        List<Answer> answers = answerService.getAnswers();
        return ResponseEntity.ok().body(answers);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Answer> getAnswer(@PathVariable Integer id)
    {
        Answer answer = answerService.getAnswer(id);
        return ResponseEntity.ok().body(answer);
    }
    @DeleteMapping("delete/{id}")
    public ResponseEntity<String> deleteAnswer(@PathVariable Integer id)
    {
        Integer deleted = answerService.deleteAnswer(id);
        if(deleted == 1)
        {
            return ResponseEntity.ok().body("answer deleted");
        }
        return ResponseEntity.badRequest().body("answer not deleted");
    }
}
