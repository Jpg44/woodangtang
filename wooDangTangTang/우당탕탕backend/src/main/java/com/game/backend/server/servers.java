package com.game.backend.server;

import com.game.backend.room.rooms;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
//@Table(name = "servers")
public class servers {
    @Id
    private int serverCode;
    private int serverPeople;
    private int serverLimit;
    private int lastRoom;
    @OneToMany(mappedBy = "server")
    private List<rooms> rooms = new ArrayList<>();
}
