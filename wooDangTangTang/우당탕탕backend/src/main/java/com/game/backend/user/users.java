package com.game.backend.user;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Entity
@Getter
@Setter
@Table(name = "users")
public class users {
    @Id
    @GeneratedValue
    private int userCode;
    private String userId;
    private String userName;
    private String userPassword;
    private String userAnswer;
}
