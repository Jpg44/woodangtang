package com.game.backend.character;

import com.game.backend.user.users;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
//@Table(name = "characters")
public class characters {
    @Id
    @GeneratedValue
    private int characterCode;
    private String characterName;
}
