package com.game.backend.user;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
public class responseDTO {
    private String userName;
    private int userCode;
    private boolean idCheck;
    private String userPassword;

}
