package com.youcode.sunquizz.domains.chat.room.roomMembers;

import com.youcode.sunquizz.Security.User.User;
import com.youcode.sunquizz.domains.chat.room.Room;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class RoomMembers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private User member;
    @ManyToOne
    private Room room;
}