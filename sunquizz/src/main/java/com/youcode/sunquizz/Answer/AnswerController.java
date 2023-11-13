package com.youcode.sunquizz.Answer;

import com.youcode.sunquizz.Answer.Answer;
import com.youcode.sunquizz.Answer.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/answer")
public class AnswerController {
    @Autowired
    AnswerService answerService;
    @PostMapping
    public Answer createAnswer(@RequestBody Answer answer)
    {
        return answerService.createAnswer(answer);
    }
    @PutMapping("/{id}")
    public Answer updateAnswer(@PathVariable Integer id, @RequestBody Answer answer)
    {
        return answerService.updateAnswer(answer,id);
    }
    @GetMapping
    public List<Answer> getAnswers(@RequestBody Answer answer)
    {
        return answerService.getAnswers();
    }
    @GetMapping("/{id}")
    public Answer getAnswer(@PathVariable Integer id)
    {
        return answerService.getAnswer(id);
    }
    @DeleteMapping("delete/{id}")
    public Integer deleteAnswer(@PathVariable Integer id)
    {
        return answerService.deleteAnswer(id);
    }
}
