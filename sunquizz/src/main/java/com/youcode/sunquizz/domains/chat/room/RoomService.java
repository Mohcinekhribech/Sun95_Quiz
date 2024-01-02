package com.youcode.sunquizz.domains.chat.room;


import com.youcode.sunquizz.Security.User.User;
import com.youcode.sunquizz.Security.User.UserRepository;
import com.youcode.sunquizz.domains.chat.room.dtos.RoomReqDTO;
import com.youcode.sunquizz.domains.chat.room.dtos.RoomRespDTO;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.Optional;

@AllArgsConstructor
@Service
public class RoomService implements RoomServiceInterface{
    RoomRepository roomRepository;
    UserRepository userRepository;
    ModelMapper modelMapper;
    public RoomRespDTO getRoom(Long id)
    {
        Optional<Room> room = roomRepository.findById(id);
        return modelMapper.map(room.orElse(null),RoomRespDTO.class);
    }
    public Page<RoomRespDTO> getRooms(Pageable pageable)
    {
        Page<Room> entityPage = roomRepository.findAll(pageable);
        return entityPage.map(entity -> modelMapper.map(entity, RoomRespDTO.class));
    }
    public RoomRespDTO createRoom(RoomReqDTO room)
    {
        Room room1 = modelMapper.map(room,Room.class);
        Optional<User> user = userRepository.findById(room.getOwner_id());
        return user.map(u ->{
            room1.setOwner(u);
            return modelMapper.map(roomRepository.save(room1), RoomRespDTO.class);
        }).orElse(null);

    }
    public RoomRespDTO updateRoom(RoomReqDTO room,Long id)
    {
        Optional<Room> existRoom = roomRepository.findById(id);
        return existRoom.map(room1 -> {
//            room.setId(room1.getId());
            return modelMapper.map(
                    roomRepository
                            .save(modelMapper.map(room,Room.class)),
                    RoomRespDTO.class
            );
        }).orElse(null);
    }
    public Integer deleteRoom(Long id)
    {
        Optional<Room> room = roomRepository.findById(id);
        return room.map(room1 -> {
            roomRepository.delete(room1);
            return 1;
        }).orElse(0);
    }
}
