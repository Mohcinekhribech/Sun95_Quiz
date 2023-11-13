package com.youcode.sunquizz.Subject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/subject")
public class SubjectController {
    @Autowired
    SubjectService subjectService;
    @PostMapping
    public ResponseEntity<Subject> createSubject(@RequestBody Subject subject)
    {
        Subject subject1 = subjectService.createSubject(subject);
        if(subject1 != null){
            return ResponseEntity.ok().body(subject1);
        }
        return ResponseEntity.badRequest().body(null);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Subject> updateSubject(@PathVariable Integer id,@RequestBody Subject subject)
    {
        Subject subject1 = subjectService.updateSubject(subject,id);
        if(subject1 != null){
            return ResponseEntity.ok().body(subject1);
        }
        return ResponseEntity.badRequest().body(null);
    }
    @GetMapping
    public ResponseEntity<List<Subject>> getSubjects()
    {
        List<Subject> subject = subjectService.getSubjects();
        return ResponseEntity.ok().body(subject);
    }
    @GetMapping("/subSubject/{id}")
    public List<Subject> getSubSubjects(@PathVariable Integer id)
    {
        Subject parentSubject = subjectService.getSubject(id);
        return subjectService.getSubSubject(parentSubject);
    }
    @GetMapping("/search/{title}")
    public ResponseEntity<Subject> getSubject(@PathVariable String title)
    {
        Subject subject = subjectService.getSubject(title);
        return ResponseEntity.ok().body(subject);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<String> deleteSubject(@PathVariable Integer id)
    {
        Integer deleted = subjectService.deleteSubject(id);
        if(deleted == 1){
            return ResponseEntity.ok().body("Subject deleted ?");
        }
        return ResponseEntity.ok().body("Subject not deleted ?");
    }
}
