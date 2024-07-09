package com.game.backend.character;

import com.game.backend.user.users;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class userCharacters {
    @Id
    @GeneratedValue
    private int userCharacter;
    private String characterCondition;
    @ManyToOne
    @JoinColumn(name = "userCode",referencedColumnName = "userCode")
    private users user;
    @ManyToOne
    @JoinColumn(name = "characterCode",referencedColumnName = "characterCode")
    private characters character;

}
