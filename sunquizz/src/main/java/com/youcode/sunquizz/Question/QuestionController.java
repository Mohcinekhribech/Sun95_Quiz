package com.youcode.sunquizz.Question;

import com.youcode.sunquizz.Answer.Answer;
import com.youcode.sunquizz.Answer.AnswerService;
import com.youcode.sunquizz.Level.Level;
import com.youcode.sunquizz.Question.DTOs.QuestionReqDTO;
import com.youcode.sunquizz.Question.DTOs.QuestionRespDTO;
import com.youcode.sunquizz.Question.Question;
import com.youcode.sunquizz.Question.QuestionService;
import com.youcode.sunquizz.Validation.Validation;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("question")
public class QuestionController {
    @Autowired
    QuestionService questionService;
    ModelMapper modelMapper;
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
    public ResponseEntity<List<QuestionRespDTO>> getQuestions()
    {
        return ResponseEntity.ok().body(questionService.getQuestions());
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
