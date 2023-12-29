package com.youcode.sunquizz.domains.chat.room.message.dtos;

import com.youcode.sunquizz.Security.User.DTOs.UserDTO;
import com.youcode.sunquizz.domains.chat.room.dtos.RoomReqDTO;
import lombok.Data;

import java.time.LocalTime;

@Data
public class MessageRespDTO {
    private long id;
    private String content;
    private RoomReqDTO room;
    private UserDTO sender;
    private LocalTime time;
}