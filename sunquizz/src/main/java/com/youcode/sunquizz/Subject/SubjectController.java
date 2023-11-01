package com.youcode.sunquizz.Subject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/subject")
public class SubjectController {
    @Autowired
    SubjectService subjectService;
    @PostMapping
    public Subject createSubject(@RequestBody Subject subject)
    {
        return subjectService.createSubject(subject);
    }
    @PutMapping("/{id}")
    public Subject updateSubject(@PathVariable Integer id,@RequestBody Subject subject)
    {
        return subjectService.updateSubject(subject,id);
    }
    @GetMapping
    public List<Subject> getSubjects(@RequestBody Subject subject)
    {
        return subjectService.getSubjects();
    }
    @GetMapping("/search/{title}")
    public Subject getSubject(@PathVariable String title)
    {
        return subjectService.getSubject(title);
    }
    @DeleteMapping("delete/{id}")
    public Integer deleteSubject(@PathVariable Integer id)
    {
        return subjectService.deleteSubject(id);
    }
}
