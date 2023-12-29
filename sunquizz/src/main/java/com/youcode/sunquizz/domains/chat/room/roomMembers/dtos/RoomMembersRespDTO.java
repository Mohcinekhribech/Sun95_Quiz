package com.youcode.sunquizz.domains.chat.room.roomMembers.dtos;

import com.youcode.sunquizz.Security.User.DTOs.UserDTO;
import com.youcode.sunquizz.domains.chat.room.dtos.RoomReqDTO;
import lombok.Data;

@Data
public class RoomMembersRespDTO {
    private Long id;
    private UserDTO member;
    private RoomReqDTO room;
}
