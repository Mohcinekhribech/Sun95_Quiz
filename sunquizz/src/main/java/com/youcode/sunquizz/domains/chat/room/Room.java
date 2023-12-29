package com.youcode.sunquizz.domains.chat.room;

import com.youcode.sunquizz.Security.User.User;
import com.youcode.sunquizz.domains.chat.room.message.Message;
import com.youcode.sunquizz.domains.chat.room.roomMembers.RoomMembers;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Room {
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Integer id;
    private String name;
    @OneToOne
    private User owner;
    @OneToMany(mappedBy = "room", cascade = CascadeType.ALL)
    private List<RoomMembers> members;
    @OneToMany(mappedBy = "room", cascade = CascadeType.ALL)
    private List<Message> messages;
}