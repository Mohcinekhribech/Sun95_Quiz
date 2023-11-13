package com.youcode.sunquizz.QuizzQuestion;

import com.youcode.sunquizz.QuizzQuestion.QuizzQuestion;
import com.youcode.sunquizz.QuizzQuestion.QuizzQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("quizz/questions")
public class QuizzQuestionController {
    @Autowired
    QuizzQuestionService quizzQuestionService;
    @PostMapping
    public ResponseEntity<QuizzQuestion> createQuizzQuestion(@RequestBody QuizzQuestion quizzQuestion)
    {
        QuizzQuestion quizzQuestion1 = quizzQuestionService.createQuizzQuestion(quizzQuestion);
        if(quizzQuestion1 != null)
        {
            return  ResponseEntity.ok().body(quizzQuestion1);
        }
        return ResponseEntity.badRequest().body(null);
    }
    @PutMapping("/{id}")
    public ResponseEntity<QuizzQuestion> updateQuizzQuestion(@PathVariable Integer id, @RequestBody QuizzQuestion quizzQuestion)
    {
        QuizzQuestion quizzQuestion1 = quizzQuestionService.updateQuizzQuestion(quizzQuestion,id);
        if(quizzQuestion1 != null)
        {
            return  ResponseEntity.ok().body(quizzQuestion1);
        }
        return ResponseEntity.badRequest().body(null);
    }
    @GetMapping("/{id}")
    public ResponseEntity<List<QuizzQuestion>> getQuestionsByQuizz(@PathVariable Integer id)
    {
        return ResponseEntity.ok().body(quizzQuestionService.getQuestionsByQuizz(id));
    }
    @DeleteMapping("delete/{id}")
    public ResponseEntity<String> deleteQuizzQuestion(@PathVariable Integer id)
    {
        Integer deleted = quizzQuestionService.deleteQuizzQuestion(id);
        if(deleted == 1)
        {
            return ResponseEntity.ok().body("question removed from quizz ");
        }
        return ResponseEntity.ok().body("question not removed from quizz");
    }
}