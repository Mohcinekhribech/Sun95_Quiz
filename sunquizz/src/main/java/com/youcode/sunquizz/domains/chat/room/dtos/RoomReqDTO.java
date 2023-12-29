package com.youcode.sunquizz.domains.chat.room.dtos;

import com.youcode.sunquizz.Security.User.DTOs.UserDTO;
import lombok.Data;

@Data
public class RoomReqDTO {
    private Long id;
    private String name;
    private Integer owner_id;
}
