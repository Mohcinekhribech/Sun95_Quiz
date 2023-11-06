package com.youcode.sunquizz.User;

import jakarta.persistence.Entity;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;

import java.time.LocalDate;


@MappedSuperclass
@Data
public class User {
    private String firstName;
    private String LastName;
    private LocalDate dateOfBirth;
    private String adress;
}
