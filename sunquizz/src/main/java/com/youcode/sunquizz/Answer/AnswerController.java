package com.youcode.sunquizz.Answer;

import com.youcode.sunquizz.Answer.Answer;
import com.youcode.sunquizz.Answer.AnswerService;
import com.youcode.sunquizz.Answer.DTOs.AnswerReqDTO;
import com.youcode.sunquizz.Answer.DTOs.AnswerRespDTO;
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
    public ResponseEntity<AnswerRespDTO> createAnswer(@RequestBody AnswerReqDTO answer)
    {
        AnswerRespDTO answer1 = answerService.createAnswer(answer);
        if(answer1 != null)
        {
            return ResponseEntity.ok().body(answer1);
        }
        return ResponseEntity.badRequest().body(null);
    }
    @PutMapping("/{id}")
    public ResponseEntity<AnswerRespDTO> updateAnswer(@PathVariable Integer id, @RequestBody AnswerReqDTO answer)
    {
        AnswerRespDTO answer1 = answerService.updateAnswer(answer,id);
        if(answer != null)
        {
        return ResponseEntity.ok().body(answer1);
        }
        return ResponseEntity.badRequest().body(null);
    }
    @GetMapping
    public ResponseEntity<List<AnswerRespDTO>> getAnswers()
    {
        List<AnswerRespDTO> answers = answerService.getAnswers();
        return ResponseEntity.ok().body(answers);
    }
    @GetMapping("/{id}")
    public ResponseEntity<AnswerRespDTO> getAnswer(@PathVariable Integer id)
    {
        AnswerRespDTO answer = answerService.getAnswer(id);
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
