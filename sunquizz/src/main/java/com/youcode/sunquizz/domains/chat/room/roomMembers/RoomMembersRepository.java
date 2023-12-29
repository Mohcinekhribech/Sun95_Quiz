package com.youcode.sunquizz.domains.chat.room.roomMembers;

import com.youcode.sunquizz.Security.User.User;
import com.youcode.sunquizz.domains.chat.room.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoomMembersRepository extends JpaRepository<RoomMembers,Long> {
    List<RoomMembers> findAllByMember(User member);
}
