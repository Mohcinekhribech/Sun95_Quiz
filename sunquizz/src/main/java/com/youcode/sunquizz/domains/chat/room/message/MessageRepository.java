package com.youcode.sunquizz.domains.chat.room.message;

import com.youcode.sunquizz.domains.chat.room.roomMembers.RoomMembers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageRepository extends JpaRepository<Message,Long> {
}
