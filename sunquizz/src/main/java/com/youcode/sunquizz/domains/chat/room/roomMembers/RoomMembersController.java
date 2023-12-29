package com.youcode.sunquizz.domains.chat.room.roomMembers;


import com.youcode.sunquizz.domains.chat.room.roomMembers.dtos.RoomMembersReqDTO;
import com.youcode.sunquizz.domains.chat.room.roomMembers.dtos.RoomMembersRespDTO;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("room/members")
public class RoomMembersController {
    RoomMembersServiceInterface roomMembersService;
    @PostMapping
    public ResponseEntity<RoomMembersRespDTO> createRoom(@RequestBody RoomMembersReqDTO room)
    {
        RoomMembersRespDTO room1 = roomMembersService.createRoomMembers(room);
        if(room1 != null)
        {
            return ResponseEntity.ok().body(room1);
        }
        return ResponseEntity.badRequest().body(null);
    }
    @GetMapping
    public ResponseEntity<Page<RoomMembersRespDTO>> getRoomMembers(Pageable pageable)
    {
        return ResponseEntity.ok().body(roomMembersService.getRoomMembers(pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<List<RoomMembersRespDTO>> getRoomsByMember(@PathVariable Integer id)
    {
        return ResponseEntity.ok().body(roomMembersService.getRoomsByMember(id));
    }
    @DeleteMapping("delete/{id}")
    public ResponseEntity<String> deleteRoom(@PathVariable Long id)
    {
        Integer deleted = roomMembersService.deleteRoomMembers(id);
        if(deleted == 1)
        {
            return  ResponseEntity.ok().body("room deleted");
        }
        return ResponseEntity.badRequest().body("room not deleted");
    }
}
