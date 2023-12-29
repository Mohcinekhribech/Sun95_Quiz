package com.youcode.sunquizz.domains.chat.room.message.dtos;

import com.youcode.sunquizz.Security.User.DTOs.UserDTO;
import com.youcode.sunquizz.Security.User.User;
import com.youcode.sunquizz.domains.chat.room.Room;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;

import java.time.LocalTime;

@Data
public class MessageReqDTO {
    private long id;
    private String content;
    private Long room_id;
    private UserDTO sender;
    private LocalTime time;
}
