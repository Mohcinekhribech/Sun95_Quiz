package com.youcode.sunquizz.Media;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Media {
    @Id
    private Integer id;
    private MediaType type;
    private String link;
    private String description;
}