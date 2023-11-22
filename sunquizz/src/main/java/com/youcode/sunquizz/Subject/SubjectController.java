package com.youcode.sunquizz.Subject;

import com.youcode.sunquizz.Subject.DTOs.SubjectReqDTO;
import com.youcode.sunquizz.Subject.DTOs.SubjectRespDTO;
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
    public ResponseEntity<SubjectRespDTO> createSubject(@RequestBody SubjectReqDTO subject)
    {
        SubjectRespDTO subject1 = subjectService.createSubject(subject);
        if(subject1 != null){
            return ResponseEntity.ok().body(subject1);
        }
        return ResponseEntity.badRequest().body(null);
    }
    @PutMapping("/{id}")
    public ResponseEntity<SubjectRespDTO> updateSubject(@PathVariable Integer id,@RequestBody SubjectReqDTO subject)
    {
        SubjectRespDTO subject1 = subjectService.updateSubject(subject,id);
        if(subject1 != null){
            return ResponseEntity.ok().body(subject1);
        }
        return ResponseEntity.badRequest().body(null);
    }
    @GetMapping
    public ResponseEntity<List<SubjectRespDTO>> getSubjects()
    {
        List<SubjectRespDTO> subject = subjectService.getSubjects();
        return ResponseEntity.ok().body(subject);
    }
    @GetMapping("/search/{title}")
    public ResponseEntity<SubjectRespDTO> getSubject(@PathVariable String title)
    {
        SubjectRespDTO subject = subjectService.getSubjectByTitle(title);
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