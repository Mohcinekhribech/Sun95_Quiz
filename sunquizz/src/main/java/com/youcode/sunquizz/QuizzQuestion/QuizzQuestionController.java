package com.youcode.sunquizz.QuizzQuestion;

import com.youcode.sunquizz.QuizzQuestion.QuizzQuestion;
import com.youcode.sunquizz.QuizzQuestion.QuizzQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("quizz/questions")
public class QuizzQuestionController {
    @Autowired
    QuizzQuestionService quizzQuestionService;
    @PostMapping
    public QuizzQuestion createQuizzQuestion(@RequestBody QuizzQuestion quizzQuestion)
    {
        return quizzQuestionService.createQuizzQuestion(quizzQuestion);
    }
    @PutMapping("/{id}")
    public QuizzQuestion updateQuizzQuestion(@PathVariable Integer id, @RequestBody QuizzQuestion quizzQuestion)
    {
        return quizzQuestionService.updateQuizzQuestion(quizzQuestion,id);
    }
    @GetMapping("/{id}")
    public List<QuizzQuestion> getQuestionsByQuizz(@PathVariable Integer id)
    {
        return quizzQuestionService.getQuestionsByQuizz(id);
    }
    @DeleteMapping("delete/{id}")
    public Integer deleteQuizzQuestion(@PathVariable Integer id)
    {
        return quizzQuestionService.deleteQuizzQuestion(id);
    }
}