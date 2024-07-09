package com.game.backend.userdata;

import com.game.backend.user.users;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class userData {
    @Id
    @GeneratedValue
    private int userDataCode;
    private int dataValue;
    @ManyToOne
    @JoinColumn(name = "userCode" ,referencedColumnName = "userCode")
    users user;
    @ManyToOne
    @JoinColumn(name="dataCode" , referencedColumnName = "dataCode")
    dataTable datatable;

}
