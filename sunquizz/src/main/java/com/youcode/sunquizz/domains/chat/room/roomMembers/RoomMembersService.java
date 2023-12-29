package com.youcode.sunquizz.domains.chat.room.roomMembers;


import com.youcode.sunquizz.Security.User.User;
import com.youcode.sunquizz.Security.User.UserRepository;
import com.youcode.sunquizz.domains.chat.room.roomMembers.dtos.RoomMembersReqDTO;
import com.youcode.sunquizz.domains.chat.room.roomMembers.dtos.RoomMembersRespDTO;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class RoomMembersService implements RoomMembersServiceInterface {
    RoomMembersRepository roomMembersRepository;
    UserRepository userRepository;
    ModelMapper modelMapper;

    public RoomMembersRespDTO getRoomMember(Long id) {
        Optional<RoomMembers> room = roomMembersRepository.findById(id);
        return modelMapper.map(room.orElse(null), RoomMembersRespDTO.class);
    }

    public Page<RoomMembersRespDTO> getRoomMembers(Pageable pageable) {
        Page<RoomMembers> entityPage = roomMembersRepository.findAll(pageable);
        return entityPage.map(entity -> modelMapper.map(entity, RoomMembersRespDTO.class));
    }

    public List<RoomMembersRespDTO> getRoomsByMember(Integer id) {
        Optional<User> user = userRepository.findById(id);
        return user.map(u ->{
            List<RoomMembers> entityPage = roomMembersRepository.findAllByMember(user.get());
            return entityPage.stream().map(entity -> modelMapper.map(entity, RoomMembersRespDTO.class)).collect(Collectors.toList());
        }).orElse(List.of());
    }

    public RoomMembersRespDTO createRoomMembers(RoomMembersReqDTO room) {
        return modelMapper.map(
                roomMembersRepository
                        .save(modelMapper.map(room, RoomMembers.class)),
                RoomMembersRespDTO.class
        );
    }

    public RoomMembersRespDTO updateRoomMembers(RoomMembersReqDTO room, Long id) {
        Optional<RoomMembers> existRoomMembers = roomMembersRepository.findById(id);
        return existRoomMembers.map(room1 -> {
            room.setId(room1.getId());
            return modelMapper.map(
                    roomMembersRepository
                            .save(modelMapper.map(room, RoomMembers.class)),
                    RoomMembersRespDTO.class
            );
        }).orElse(null);
    }

    public Integer deleteRoomMembers(Long id) {
        Optional<RoomMembers> room = roomMembersRepository.findById(id);
        return room.map(room1 -> {
            roomMembersRepository.delete(room1);
            return 1;
        }).orElse(0);
    }
}
