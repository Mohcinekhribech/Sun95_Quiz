package com.youcode.sunquizz.domains.Question;

import com.youcode.sunquizz.domains.Question.DTOs.QuestionReqDTO;
import com.youcode.sunquizz.domains.Question.DTOs.QuestionRespDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("question")
public class QuestionController {
    @Autowired
    QuestionService questionService;
    @PostMapping
    public ResponseEntity<QuestionRespDTO> createQuestion(@RequestBody QuestionReqDTO question)
    {
        QuestionRespDTO question1 = questionService.createQuestion(question);
        if(question1 != null)
        {
            return  ResponseEntity.ok().body(question1);
        }
        return ResponseEntity.badRequest().body(null);
    }
    @PutMapping("/{id}")
    public ResponseEntity<QuestionRespDTO> updateQuestion(@PathVariable Integer id, @RequestBody QuestionReqDTO question)
    {
        QuestionRespDTO question1 = questionService.updateQuestion(question,id);;
        if(question1 != null)
        {
            return  ResponseEntity.ok().body(question1);
        }
        return ResponseEntity.badRequest().body(null);
    }
    @GetMapping
    public ResponseEntity<Page<QuestionRespDTO>> getQuestions(Pageable pageable)
    {
        return ResponseEntity.ok().body(questionService.getQuestions(pageable));
    }
    @GetMapping("/{id}")
    public ResponseEntity<QuestionRespDTO> getQuestion(@PathVariable Integer id)
    {
        return ResponseEntity.ok().body(questionService.getQuestion(id));
    }
    @DeleteMapping("delete/{id}")
    public ResponseEntity<String> deleteQuestion(@PathVariable Integer id)
    {
        Integer deleted = questionService.deleteQuestion(id);
        if(deleted == 1)
        {
            return ResponseEntity.ok().body("question deleted");
        }
        return ResponseEntity.ok().body("question not deleted");
    }
    @GetMapping("by_level/{id}")
    public ResponseEntity<List<QuestionRespDTO>> getQuestionByLevel(@PathVariable Integer id)
    {
        return ResponseEntity.ok().body(questionService.getQuestionByLevel(id));
    }
    @GetMapping("by_subject/{id}")
    public ResponseEntity<List<QuestionRespDTO>> getQuestionBySubject(@PathVariable Integer id)
    {
        return ResponseEntity.ok().body(questionService.getQuestionBySubject(id));
    }
}
