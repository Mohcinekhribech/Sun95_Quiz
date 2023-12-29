package com.youcode.sunquizz.domains.Subject;

import com.youcode.sunquizz.domains.Subject.DTOs.SubjectReqDTO;
import com.youcode.sunquizz.domains.Subject.DTOs.SubjectRespDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<Page<SubjectRespDTO>> getSubjects(Pageable pageable){
        return ResponseEntity.ok().body(subjectService.getSubjects(pageable));
    }
    @GetMapping("/search/{title}")
    public ResponseEntity<SubjectRespDTO> getSubjectByTitle(@PathVariable String title)
    {
        SubjectRespDTO subject = subjectService.getSubjectByTitle(title);
        return ResponseEntity.ok().body(subject);
    }
    @GetMapping("/{id}")
    public ResponseEntity<SubjectRespDTO> getSubject(@PathVariable int id)
    {
        SubjectRespDTO subject = subjectService.getSubject(id);
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