package com.youcode.sunquizz.StudentAnswer;

import com.youcode.sunquizz.AssignQuizz.AssignQuizz;
import com.youcode.sunquizz.Validation.Validation;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class StudentAnswer {
    @Id
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "assignQuizz_id")
    private AssignQuizz assignQuizz;
    @ManyToOne
    @JoinColumn(name = "validation_id")
    private Validation validation;
}
