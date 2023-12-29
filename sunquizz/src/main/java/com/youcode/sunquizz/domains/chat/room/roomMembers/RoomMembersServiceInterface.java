package com.youcode.sunquizz.domains.chat.room.roomMembers;

import com.youcode.sunquizz.domains.chat.room.dtos.RoomReqDTO;
import com.youcode.sunquizz.domains.chat.room.dtos.RoomRespDTO;
import com.youcode.sunquizz.domains.chat.room.roomMembers.dtos.RoomMembersReqDTO;
import com.youcode.sunquizz.domains.chat.room.roomMembers.dtos.RoomMembersRespDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RoomMembersServiceInterface {
    RoomMembersRespDTO getRoomMember(Long id);
    Page<RoomMembersRespDTO> getRoomMembers(Pageable pageable);
    RoomMembersRespDTO createRoomMembers(RoomMembersReqDTO room);
    RoomMembersRespDTO updateRoomMembers(RoomMembersReqDTO room,Long id);
    Integer deleteRoomMembers(Long id);
    List<RoomMembersRespDTO> getRoomsByMember(Integer id);
}
