package com.youcode.sunquizz.Subject;

import com.youcode.sunquizz.Question.DTOs.QuestionRespDTO;
import com.youcode.sunquizz.Question.Question;
import com.youcode.sunquizz.Subject.DTOs.SubjectReqDTO;
import com.youcode.sunquizz.Subject.DTOs.SubjectRespDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SubjectService {
    SubjectRepository subjectRepository;
    @Autowired
    ModelMapper modelMapper;
    Optional<Subject> subjectOptional;
    @Autowired
    public SubjectService(SubjectRepository subjectRepository)
    {
        this.subjectRepository = subjectRepository;
    }
    public SubjectRespDTO getSubjectByTitle(String title)
    {
        subjectOptional = subjectRepository.findByTitle(title);
        return modelMapper.map(subjectOptional.orElse(null),SubjectRespDTO.class);
    }
    public List<SubjectRespDTO> getSubjects()
    {
        return subjectRepository.findAll().stream()
                .map(subject -> modelMapper.map(subject,SubjectRespDTO.class))
                .collect(Collectors.toList());
    }
    public SubjectRespDTO createSubject(SubjectReqDTO subject)
    {
        Subject subjectE = modelMapper.map(subject,Subject.class);
        subjectOptional = subjectRepository.findById(subject.getParentSubject_id());
        subjectOptional.ifPresent(subjectE::setParentSubject);
        subjectE = subjectRepository.save(subjectE);
        return modelMapper.map(subjectE, SubjectRespDTO.class);
    }
    public SubjectRespDTO updateSubject(SubjectReqDTO subject,Integer id)
    {
        subjectOptional = subjectRepository.findById(id);
        if(subjectOptional.isPresent()) {
            Subject subjectE = modelMapper.map(subject,Subject.class);
            subject.setId(id);
            subjectOptional = subjectRepository.findById(subject.getParentSubject_id());
            subjectOptional.ifPresent(subjectE::setParentSubject);
            return modelMapper.map(
                    subjectRepository.save(modelMapper.map(subject,Subject.class)),
                    SubjectRespDTO.class
                    );
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
