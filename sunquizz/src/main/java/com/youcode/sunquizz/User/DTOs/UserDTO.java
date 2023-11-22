package com.youcode.sunquizz.User.DTOs;

import lombok.Data;

import java.time.LocalDate;
@Data
public class UserDTO {

    private String firstName;
    private String LastName;
    private LocalDate dateOfBirth;
    private String adress;
}
