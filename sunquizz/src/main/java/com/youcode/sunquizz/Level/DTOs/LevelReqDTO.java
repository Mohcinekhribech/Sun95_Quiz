package com.youcode.sunquizz.Level.DTOs;

import lombok.Data;

@Data
public class LevelReqDTO {
    private int id;
    private String name;
    private int maxPoint;
    private int minPoint;
}
