package com.youcode.sunquizz.domains.chat.room.roomMembers.dtos;

import lombok.Data;

@Data
public class RoomMembersReqDTO {
    private Long id;
    private Integer member_id;
    private Long room_id;
}