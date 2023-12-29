package com.youcode.sunquizz.domains.chat.room.dtos;

import com.youcode.sunquizz.Security.User.DTOs.UserDTO;
import com.youcode.sunquizz.domains.chat.room.message.dtos.MessageRespDTO;
import com.youcode.sunquizz.domains.chat.room.roomMembers.dtos.RoomMembersReqDTO;
import lombok.Data;

import java.util.List;

@Data
public class RoomRespDTO {
    private Long id;
    private String name;
    private UserDTO owner;
    private List<RoomMembersReqDTO> members;
    private List<MessageRespDTO> messages;
}
