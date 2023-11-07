package com.youcode.sunquizz.Quizz;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/quizz")
public class QuizzController {
    @Autowired
    QuizzService quizzService;
    @PostMapping
    public Quizz createQuizz(@RequestBody Quizz quizz)
    {
        return quizzService.createQuizz(quizz);
    }
    @PutMapping("/{id}")
    public Quizz updateQuizz(@PathVariable Integer id, @RequestBody Quizz quizz)
    {
        return quizzService.updateQuizz(id,quizz);
    }
    @GetMapping
    public List<Quizz> getQuizzs()
    {
        return quizzService.getAll();
    }
    @GetMapping("/quizz/{id}")
    public List<Quizz> getQuizz(@PathVariable Integer id)
    {
        return quizzService.getAllByTeacher(id);
    }
    @DeleteMapping("delete/{id}")
    public Integer deleteQuizz(@PathVariable Integer id)
    {
        return quizzService.deleteQuizz(id);
    }
}