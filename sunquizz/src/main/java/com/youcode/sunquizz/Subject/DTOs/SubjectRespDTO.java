package com.youcode.sunquizz.Subject.DTOs;

import lombok.Data;

import java.util.List;
@Data
public class SubjectRespDTO {
    private int id;
    private String title;
    private SubjectReqDTO parentSubject;
    private List<SubjectReqDTO> childSubjects;
}