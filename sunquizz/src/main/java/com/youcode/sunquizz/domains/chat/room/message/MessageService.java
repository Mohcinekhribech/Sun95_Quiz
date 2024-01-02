package com.youcode.sunquizz.domains.chat.room.message;



import com.youcode.sunquizz.Security.User.User;
import com.youcode.sunquizz.Security.User.UserRepository;
import com.youcode.sunquizz.domains.chat.room.Room;
import com.youcode.sunquizz.domains.chat.room.RoomRepository;
import com.youcode.sunquizz.domains.chat.room.message.dtos.MessageReqDTO;
import com.youcode.sunquizz.domains.chat.room.message.dtos.MessageRespDTO;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class MessageService implements MessageServiceInterface {
    MessageRepository messageRepository;
    RoomRepository roomRepository;
    UserRepository userRepository;
    ModelMapper modelMapper;
    public MessageRespDTO getMessage(Long id)
    {
        Optional<Message> message = messageRepository.findById(id);
        return modelMapper.map(message.orElse(null),MessageRespDTO.class);
    }
    public List<MessageRespDTO> getMessages()
    {
        List<Message> entityPage = messageRepository.findAll();
        return entityPage.stream().map(entity -> modelMapper.map(entity, MessageRespDTO.class)).collect(Collectors.toList());
    }
    public MessageRespDTO createMessage(MessageReqDTO message)
    {
        message.setTime(LocalTime.now());
        Message message1 = modelMapper.map(message,Message.class);
        Optional<Room> room = roomRepository.findById(message.getRoom_id());
        Optional<User> sender = userRepository.findById(message.getSender_id());
        if (room.isPresent() && sender.isPresent())
        {
            message1.setRoom(room.get());
            message1.setSender(sender.get());
        }
        return modelMapper.map(messageRepository.save(message1),MessageRespDTO.class);
    }
    public MessageRespDTO updateMessage(MessageReqDTO message,Long id)
    {
        Optional<Message> existMessage = messageRepository.findById(id);
        return existMessage.map(message1 -> {
            message.setId(message1.getId());
            return modelMapper.map(
                    messageRepository
                            .save(modelMapper.map(message,Message.class)),
                    MessageRespDTO.class
            );
        }).orElse(null);
    }
    public Integer deleteMessage(Long id)
    {
        Optional<Message> message = messageRepository.findById(id);
        return message.map(message1 -> {
            messageRepository.delete(message1);
            return 1;
        }).orElse(0);
    }
}
