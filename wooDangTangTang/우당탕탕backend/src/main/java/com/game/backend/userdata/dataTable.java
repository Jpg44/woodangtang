package com.game.backend.userdata;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class dataTable {
    @Id
    @GeneratedValue
    private int  dataCode;
    @Column(unique = true)
    private String dataName;
    private String dataType;

}
