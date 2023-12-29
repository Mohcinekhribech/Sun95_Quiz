package com.youcode.sunquizz.domains.chat.room;

import com.youcode.sunquizz.domains.Media.DTOs.MediaReqDTO;
import com.youcode.sunquizz.domains.Media.DTOs.MediaRespDTO;
import com.youcode.sunquizz.domains.Media.MediaType;
import com.youcode.sunquizz.domains.chat.room.dtos.RoomReqDTO;
import com.youcode.sunquizz.domains.chat.room.dtos.RoomRespDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface RoomServiceInterface {
    RoomRespDTO getRoom(Long id);
    Page<RoomRespDTO> getRooms(Pageable pageable);
    RoomRespDTO createRoom(RoomReqDTO room);
    RoomRespDTO updateRoom(RoomReqDTO room,Long id);
    Integer deleteRoom(Long id);
}
