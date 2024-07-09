package com.game.backend.userjob;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class userJobsDTO {

    private int[] userCodes;
    private int userCode;
    private int spyNum;
    private int wildNum;
    private int selfishNum;
    private String jobName;
    private String jobTeam;

}
