package com.game.backend.userdata;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class dataDTO {
    private int userCode;
    private List<dataObject> dataList;
}
