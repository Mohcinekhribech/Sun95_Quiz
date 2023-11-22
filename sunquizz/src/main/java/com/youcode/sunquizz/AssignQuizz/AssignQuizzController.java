package com.youcode.sunquizz.AssignQuizz;

import com.youcode.sunquizz.AssignQuizz.DTOs.AssignQuizzReqDTO;
import com.youcode.sunquizz.AssignQuizz.DTOs.AssignQuizzRespDTO;
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
    public ResponseEntity<List<AssignQuizzRespDTO>> createAssignQuizz(@RequestBody List<AssignQuizzReqDTO> assignQuizzes)
    {
        List<AssignQuizzRespDTO> assignQuizzes1 = assignQuizzService.createAssignQuizz(assignQuizzes);
        if(!assignQuizzes1.isEmpty())
        {
            return ResponseEntity.ok().body(assignQuizzes1);
        }
        return  ResponseEntity.badRequest().body(null);
    }
    @PutMapping("/{id}")
    public ResponseEntity<AssignQuizzRespDTO> updateAssignQuizz(@PathVariable Integer id, @RequestBody AssignQuizzReqDTO assignQuizz)
    {
        AssignQuizzRespDTO assignQuizz1 = assignQuizzService.updateAssignQuizz(id,assignQuizz);
        if(assignQuizz1!=null)
        {
        return ResponseEntity.ok().body(assignQuizz1);
        }
        return ResponseEntity.badRequest().body(null);
    }
    @GetMapping
    public ResponseEntity<List<AssignQuizzRespDTO>> getAssignQuizzs()
    {
        List<AssignQuizzRespDTO> assignQuizzes =  assignQuizzService.getAll();
        return ResponseEntity.ok().body(assignQuizzes);
    }
    @GetMapping("/student/{id}")
    public ResponseEntity<List<AssignQuizzRespDTO>> getAllTestsAssignToOneStudent(@PathVariable Integer id)
    {
        List<AssignQuizzRespDTO> assignQuizzes =  assignQuizzService.getAllByStudent(id);
        return ResponseEntity.ok().body(assignQuizzes);
    }
    @GetMapping("/quizz/{id}")
    public ResponseEntity<List<AssignQuizzRespDTO>> GetAllStudentsAssignedToOneTest(@PathVariable Integer id)
    {
        List<AssignQuizzRespDTO> assignQuizzes =  assignQuizzService.getAllByQuizz(id);
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
