package com.youcode.sunquizz.domains.chat.room;

import com.youcode.sunquizz.domains.chat.room.dtos.RoomReqDTO;
import com.youcode.sunquizz.domains.chat.room.dtos.RoomRespDTO;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("rooms")
public class RoomController {
    RoomServiceInterface roomService;
    @PostMapping
    public ResponseEntity<RoomRespDTO> createRoom(@RequestBody RoomReqDTO room)
    {
        RoomRespDTO room1 = roomService.createRoom(room);
        if(room1 != null)
        {
            return ResponseEntity.ok().body(room1);
        }
        return ResponseEntity.badRequest().body(null);
    }
    @PutMapping("/{id}")
    public ResponseEntity<RoomRespDTO> updateRoom(@PathVariable Long id, @Valid @RequestBody RoomReqDTO room)
    {
        RoomRespDTO room1 = roomService.updateRoom(room,id);
        if(room1 != null)
        {
            return ResponseEntity.ok().body(room1);
        }
        return ResponseEntity.badRequest().body(null);
    }
    @GetMapping
    public ResponseEntity<Page<RoomRespDTO>> getRooms(Pageable pageable)
    {
        return ResponseEntity.ok().body(roomService.getRooms(pageable));
    }
    @GetMapping("/{id}")
    public ResponseEntity<RoomRespDTO> getRoom(@PathVariable Long id)
    {
        return ResponseEntity.ok().body(roomService.getRoom(id));
    }
    @DeleteMapping("delete/{id}")
    public ResponseEntity<String> deleteRoom(@PathVariable Long id)
    {
        Integer deleted = roomService.deleteRoom(id);
        if(deleted == 1)
        {
            return  ResponseEntity.ok().body("room deleted");
        }
        return ResponseEntity.badRequest().body("room not deleted");
    }
}
