package com.youcode.sunquizz.Quizz;


import com.youcode.sunquizz.Quizz.DTOs.QuizzReqDTO;
import com.youcode.sunquizz.Quizz.DTOs.QuizzRespDTO;
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
    public ResponseEntity<QuizzRespDTO> createQuizz(@RequestBody QuizzReqDTO quizz)
    {
        QuizzRespDTO quizz1 = quizzService.createQuizz(quizz);
            return ResponseEntity.ok().body(quizz1);
    }
    @PutMapping("/{id}")
    public ResponseEntity<QuizzRespDTO> updateQuizz(@PathVariable Integer id, @RequestBody QuizzReqDTO quizz)
    {
        return ResponseEntity.ok().body(quizzService.updateQuizz(id,quizz));
    }
    @GetMapping
    public ResponseEntity<List<QuizzRespDTO>> getQuizzs()
    {
        return ResponseEntity.ok().body(quizzService.getAll());
    }
    @GetMapping("/quizz/{id}")
    public ResponseEntity<List<QuizzRespDTO>> getQuizz(@PathVariable Integer id)
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