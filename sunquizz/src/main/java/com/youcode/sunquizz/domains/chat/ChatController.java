package com.youcode.sunquizz.domains.chat;

import com.youcode.sunquizz.domains.chat.room.message.MessageServiceInterface;
import com.youcode.sunquizz.domains.chat.room.message.dtos.MessageReqDTO;
import com.youcode.sunquizz.domains.chat.room.message.dtos.MessageRespDTO;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

@Controller
@AllArgsConstructor
public class ChatController {
    MessageServiceInterface messageService;

    @MessageMapping("/chat/{roomId}")
    @SendTo("/topic/{roomId}")
    public MessageRespDTO chat(@DestinationVariable Long roomId , MessageReqDTO message){
        return messageService.createMessage(message);
    }

//    @MessageMapping("/chat.sendMessage")
//    @SendTo("/topic/public")
//    public ChatMessage sendMessage(
//            @Payload ChatMessage chatMessage
//    ) {
//        return chatMessage;
//    }
//
//    @MessageMapping("/chat.addUser")
//    @SendTo("/topic/public")
//    public ChatMessage addUser(
//            @Payload ChatMessage chatMessage,
//            SimpMessageHeaderAccessor headerAccessor
//    ) {
//        // Add username in web socket session
//        headerAccessor.getSessionAttributes().put("username", chatMessage.getSender());
//        return chatMessage;
//    }
}
