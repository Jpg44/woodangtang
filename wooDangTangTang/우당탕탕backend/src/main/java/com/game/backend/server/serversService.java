package com.game.backend.server;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class serversService {
    private final serversRepository serverRepository;
    @Autowired
    public serversService(serversRepository serverRepository){
        this.serverRepository = serverRepository;
    }
    public List<servers>findServers(){return serverRepository.findAll();}
    public void updateServer(servers server){
        Optional<servers> optionalServers =serverRepository.findById(server.getServerCode());
        if(optionalServers.isPresent()){
            servers updateServer =optionalServers.get();
            updateServer.setServerPeople(server.getServerPeople());
            updateServer.setLastRoom(server.getLastRoom());
            serverRepository.save(updateServer);

        }
        else {
            // 해당 ID에 대한 서버가 존재하지 않을 경우 예외 처리합니다.
            throw new IllegalArgumentException("server_code " + server.getServerCode() + " not found.");

        }
        }



}
