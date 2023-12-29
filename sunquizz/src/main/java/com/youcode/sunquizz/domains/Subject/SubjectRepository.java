package com.youcode.sunquizz.domains.Subject;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface SubjectRepository extends JpaRepository<Subject,Integer> {
     Optional<Subject> findByTitle(String name);
     List<Subject> findAllByParentSubject(Subject parentSubject);
}
