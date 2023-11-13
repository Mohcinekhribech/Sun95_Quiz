package com.youcode.sunquizz.Quizz;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/quizz")
public class QuizzController {
    @Autowired
    QuizzService quizzService;
    @PostMapping
    public ResponseEntity<Quizz> createQuizz(@RequestBody Quizz quizz)
    {
        Quizz quizz1 = quizzService.createQuizz(quizz);
        if(quizz1 != null)
        {
            return ResponseEntity.ok().body(quizz1);
        }
        return ResponseEntity.badRequest().body(null);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Quizz> updateQuizz(@PathVariable Integer id, @RequestBody Quizz quizz)
    {
        return ResponseEntity.ok().body(quizzService.updateQuizz(id,quizz));
    }
    @GetMapping
    public ResponseEntity<List<Quizz>> getQuizzs()
    {
        return ResponseEntity.ok().body(quizzService.getAll());
    }
    @GetMapping("/quizz/{id}")
    public ResponseEntity<List<Quizz>> getQuizz(@PathVariable Integer id)
    {
        return ResponseEntity.ok().body(quizzService.getAllByTeacher(id));
    }
    @DeleteMapping("delete/{id}")
    public ResponseEntity<String> deleteQuizz(@PathVariable Integer id)
    {
        Integer deleted = quizzService.deleteQuizz(id);
        if(deleted == 1)
        {
            return ResponseEntity.ok().body("Quizz deleted");
        }
        return ResponseEntity.badRequest().body("Quizz not deleted");
    }
}