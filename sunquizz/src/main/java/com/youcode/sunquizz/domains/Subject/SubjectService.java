package com.youcode.sunquizz.domains.Subject;

import com.youcode.sunquizz.domains.Subject.DTOs.SubjectReqDTO;
import com.youcode.sunquizz.domains.Subject.DTOs.SubjectRespDTO;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class SubjectService {
    SubjectRepository subjectRepository;
    ModelMapper modelMapper;
    Optional<Subject> subjectOptional;

    // get a subject by title
    public SubjectRespDTO getSubjectByTitle(String title)
    {
        subjectOptional = subjectRepository.findByTitle(title);
        return modelMapper.map(subjectOptional.orElse(null),SubjectRespDTO.class);
    }

    // get one subject
    public SubjectRespDTO getSubject(int id)
    {
        subjectOptional = subjectRepository.findById(id);
        return modelMapper.map(subjectOptional.orElse(null),SubjectRespDTO.class);
    }

    // get all subjects
    public Page<SubjectRespDTO> getSubjects(Pageable pageable)
    {
        Page<Subject> entityPage = subjectRepository.findAll(pageable);
        return entityPage.map(entity -> modelMapper.map(entity, SubjectRespDTO.class));
    }

    // create a subject
    public SubjectRespDTO createSubject(SubjectReqDTO subject)
    {
        Subject subjectE = modelMapper.map(subject,Subject.class);
        subjectOptional = subjectRepository.findById(subject.getParentSubject_id());
        subjectE.setParentSubject(subjectOptional.orElse(null));
        subjectE = subjectRepository.save(subjectE);
        return modelMapper.map(subjectE, SubjectRespDTO.class);
    }

    // update a subject
    public SubjectRespDTO updateSubject(SubjectReqDTO subject,Integer id)
    {
        subjectOptional = subjectRepository.findById(id);
        return subjectOptional.map(subject1 -> {
            Subject subjectE = modelMapper.map(subject,Subject.class);
            subject.setId(id);
            subjectOptional = subjectRepository.findById(subject.getParentSubject_id());
            subjectOptional.ifPresent(subjectE::setParentSubject);
            return modelMapper.map(
                    subjectRepository.save(modelMapper.map(subject,Subject.class)),
                    SubjectRespDTO.class
            );
        }).orElse(null);
    }

    // delete a subject
    public Integer deleteSubject(Integer id)
    {
        Optional<Subject> subject = subjectRepository.findById(id);
        return subject.map(subject1 -> {
            subjectRepository.delete(subject1);
            return 1;
        }).orElse(0);
    }
}
