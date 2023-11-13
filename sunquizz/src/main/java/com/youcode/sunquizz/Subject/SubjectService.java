package com.youcode.sunquizz.Subject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SubjectService {
    SubjectRepository subjectRepository;
    @Autowired
    public SubjectService(SubjectRepository subjectRepository)
    {
        this.subjectRepository = subjectRepository;
    }
    public Subject getSubjectByTitle(String title)
    {
        return subjectRepository.findByTitle(title).get();
    }
    public Subject getSubject(Integer id)
    {
        return subjectRepository.findById(id).get();
    }
    public List<Subject> getSubjects()
    {
        return subjectRepository.findAll();
    }
    public List<Subject> getSubSubject(Subject parentSubject)
    {
        return subjectRepository.findAllByParentSubject(parentSubject);
    }
    public Subject createSubject(Subject subject)
    {
        return subjectRepository.save(subject);
    }
    public Subject updateSubject(Subject subject,Integer id)
    {
        Optional<Subject> existSubject = subjectRepository.findById(id);
        if(existSubject.isPresent()) {
            subject.setId(existSubject.get().getId());
            return subjectRepository.save(subject);
        }
        return null;
    }
    public Integer deleteSubject(Integer id)
    {
        Optional<Subject> subject = subjectRepository.findById(id);
        if(subject.isPresent()) {
            subjectRepository.delete(subject.get());
            return 1;
        }else return 0;
    }
}
