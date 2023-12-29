package com.youcode.sunquizz.domains.chat.room.message;

import com.youcode.sunquizz.domains.chat.room.dtos.RoomReqDTO;
import com.youcode.sunquizz.domains.chat.room.dtos.RoomRespDTO;
import com.youcode.sunquizz.domains.chat.room.message.dtos.MessageReqDTO;
import com.youcode.sunquizz.domains.chat.room.message.dtos.MessageRespDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MessageServiceInterface {
    MessageRespDTO getMessage(Long id);
    List<MessageRespDTO> getMessages();
    MessageRespDTO createMessage(MessageReqDTO room);
    MessageRespDTO updateMessage(MessageReqDTO room,Long id);
    Integer deleteMessage(Long id);
}
