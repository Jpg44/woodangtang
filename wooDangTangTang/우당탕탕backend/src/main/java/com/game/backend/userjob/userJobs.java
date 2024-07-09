package com.game.backend.userjob;

import com.game.backend.user.users;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
public class userJobs {
    @Id
    @GeneratedValue
    private int jobCode;
    private String jobTeam;
    private String jobName;

}
