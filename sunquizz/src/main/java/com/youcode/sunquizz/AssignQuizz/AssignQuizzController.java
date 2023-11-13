package com.youcode.sunquizz.AssignQuizz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/assignQuizz")
public class AssignQuizzController {
    @Autowired
    AssignQuizzService assignQuizzService;
    @PostMapping
    public ResponseEntity<List<AssignQuizz>> createAssignQuizz(@RequestBody List<AssignQuizz> assignQuizzes)
    {
        List<AssignQuizz> assignQuizzes1 = assignQuizzService.createAssignQuizz(assignQuizzes);
        if(!assignQuizzes1.isEmpty())
        {
            return ResponseEntity.ok().body(assignQuizzes1);
        }
        return  ResponseEntity.badRequest().body(null);
    }
    @PutMapping("/{id}")
    public ResponseEntity<AssignQuizz> updateAssignQuizz(@PathVariable Integer id, @RequestBody AssignQuizz assignQuizz)
    {
        AssignQuizz assignQuizz1 = assignQuizzService.updateAssignQuizz(id,assignQuizz);
        if(assignQuizz1!=null)
        {
        return ResponseEntity.ok().body(assignQuizz1);
        }
        return ResponseEntity.badRequest().body(null);
    }
    @GetMapping
    public ResponseEntity<List<AssignQuizz>> getAssignQuizzs()
    {
        List<AssignQuizz> assignQuizzes =  assignQuizzService.getAll();
        return ResponseEntity.ok().body(assignQuizzes);
    }
    @GetMapping("/student/{id}")
    public ResponseEntity<List<AssignQuizz>> getAllTestsAssignToOneStudent(@PathVariable Integer id)
    {
        List<AssignQuizz> assignQuizzes =  assignQuizzService.getAllByStudent(id);
        return ResponseEntity.ok().body(assignQuizzes);
    }
    @GetMapping("/quizz/{id}")
    public ResponseEntity<List<AssignQuizz>> GetAllStudentsAssignedToOneTest(@PathVariable Integer id)
    {
        List<AssignQuizz> assignQuizzes =  assignQuizzService.getAllByQuizz(id);
        return ResponseEntity.ok().body(assignQuizzes);
    }
    @DeleteMapping("delete/{id}")
    public ResponseEntity<String> deleteAssignQuizz(@PathVariable Integer id)
    {
        Integer deleted = assignQuizzService.deleteAssignQuizz(id);
        if(deleted == 1)
        {
            return ResponseEntity.ok().body("the answer is removed from the answer !");
        }
        return ResponseEntity.badRequest().body("the answer is not removed from the answer !");
    }
}
