package com.game.backend.room;

import com.game.backend.server.servers;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
//@Table (name = "rooms")
public class rooms {
    @Id
    @GeneratedValue
    private int roomCode;
    private String gameCode;
    private String mapCode;
    private String roomTitle;
    private int roomPeople;
    private int roomLimit;
    @ManyToOne
    @JoinColumn(name = "severCode",referencedColumnName = "serverCode" ,insertable = false, updatable = false)
    private servers server;

}
