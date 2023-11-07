package com.youcode.sunquizz.AssignQuizz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/assignQuizz")
public class AssignQuizzController {
    @Autowired
    AssignQuizzService assignQuizzService;
    @PostMapping
    public List<AssignQuizz> createAssignQuizz(@RequestBody List<AssignQuizz> assignQuizzes)
    {
        return assignQuizzService.createAssignQuizz(assignQuizzes);
    }
    @PutMapping("/{id}")
    public AssignQuizz updateAssignQuizz(@PathVariable Integer id, @RequestBody AssignQuizz assignQuizz)
    {
        return assignQuizzService.updateAssignQuizz(id,assignQuizz);
    }
    @GetMapping
    public List<AssignQuizz> getAssignQuizzs()
    {
        return assignQuizzService.getAll();
    }
    @GetMapping("/student/{id}")
    public List<AssignQuizz> getAllTestsAssignToOneStudent(@PathVariable Integer id)
    {
        return assignQuizzService.getAllByStudent(id);
    }
    @GetMapping("/quizz/{id}")
    public List<AssignQuizz> GetAllStudentsAssignedToOneTest(@PathVariable Integer id)
    {
        return assignQuizzService.getAllByQuizz(id);
    }
    @DeleteMapping("delete/{id}")
    public Integer deleteAssignQuizz(@PathVariable Integer id)
    {
        return assignQuizzService.deleteAssignQuizz(id);
    }
}
