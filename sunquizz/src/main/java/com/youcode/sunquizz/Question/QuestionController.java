package com.youcode.sunquizz.Question;

import com.youcode.sunquizz.Level.Level;
import com.youcode.sunquizz.Question.Question;
import com.youcode.sunquizz.Question.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/question")
public class QuestionController {
    @Autowired
    QuestionService questionService;
    @PostMapping
    public Question createQuestion(@RequestBody Question question)
    {
        return questionService.createQuestion(question);
    }
    @PutMapping("/{id}")
    public Question updateQuestion(@PathVariable Integer id, @RequestBody Question question)
    {
        return questionService.updateQuestion(question,id);
    }
    @GetMapping
    public List<Question> getQuestions(@RequestBody Question question)
    {
        return questionService.getQuestions();
    }
    @GetMapping("/{id}")
    public Question getQuestion(@PathVariable Integer id)
    {
        return questionService.getQuestion(id);
    }
    @DeleteMapping("delete/{id}")
    public Integer deleteQuestion(@PathVariable Integer id)
    {
        return questionService.deleteQuestion(id);
    }
    @GetMapping("by_level/{id}")
    public List<Question> getQuestionByLevel(@PathVariable Integer id)
    {
        return questionService.getQuestionByLevel(id);
    }
    @GetMapping("by_subject/{id}")
    public List<Question> getQuestionBySubject(@PathVariable Integer id)
    {
        return questionService.getQuestionBySubject(id);
    }
}
