package com.youcode.sunquizz.domains.User.Student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student,Integer> {
    List<Student> findAllByFirstName(String firstName);
    Optional<Student> findByEmail(String firstName);
}