package com.game.backend.server;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/server")
public class serversController {
    private final serversService serverService;
    @Autowired
    public serversController(serversService serverService){
        this.serverService = serverService;
    }
    @GetMapping("/list")
    public List<servers>findServers(){return serverService.findServers();}
    @PutMapping("/update")
    public void updateServers(@RequestBody servers server){serverService.updateServer(server);}
}
