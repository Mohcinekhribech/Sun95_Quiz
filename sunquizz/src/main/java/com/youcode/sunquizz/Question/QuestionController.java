package com.youcode.sunquizz.Question;

import com.youcode.sunquizz.Answer.Answer;
import com.youcode.sunquizz.Answer.AnswerService;
import com.youcode.sunquizz.Level.Level;
import com.youcode.sunquizz.Question.Question;
import com.youcode.sunquizz.Question.QuestionService;
import com.youcode.sunquizz.Validation.Validation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/question")
public class QuestionController {
    @Autowired
    QuestionService questionService;
//    @Autowired
//    private AnswerService answerService;

//    @PostMapping("/{questionId}/answers/{answerId}")
//    public ResponseEntity<String> associateAnswerWithQuestion(
//            @PathVariable Integer questionId, @PathVariable Integer answerId,
//            @RequestBody Validation validation) {
//        Question question = questionService.getQuestion(questionId);
//        Answer answer = answerService.getAnswer(answerId);
//
//        if (question != null && answer != null) {
//            answer.setValidation(validation);
//            question.getAnswers().add(answer);
//            answer.getQuestions().add(question);
//            questionService.createQuestion(question);
//
//            return ResponseEntity.ok("Answer associated with Question successfully.");
//        } else {
//            return ResponseEntity.notFound().build();
//        }
//    }
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
