package com.game.backend.userdata;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/data")
public class userDataController {
    private final userDataService userDataservice;
    @Autowired
    public userDataController(userDataService userDataservice){
        this.userDataservice = userDataservice;
    }
    @PostMapping("/add")
    public dataTable dataTableAdd(@RequestBody dataTable datatable){
        return userDataservice.dataTableAdd(datatable);
    }
    @PostMapping("/list")
    public List<userDataDTO> userDataList(@RequestBody int userCode){
        return userDataservice.userDataList(userCode);
    }
    @PutMapping("/update")
    public void userDataUpdate(@RequestBody dataDTO dataDto){
        userDataservice.userDataUpdate(dataDto);
    }
}
