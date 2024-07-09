package com.game.backend.room;

import com.game.backend.server.servers;
import com.game.backend.server.serversRepository;
import com.game.backend.server.serversService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class roomsService {
    private final roomsRepository roomRepository;
    private final serversService serverService;
    @Autowired
    public roomsService(roomsRepository roomRepository,serversService serverService){
        this.roomRepository = roomRepository;
        this.serverService=serverService;
    }
    public rooms createRoom(rooms room){
        servers server= new servers();
        server.setLastRoom(room.getRoomCode()+1);
        serverService.updateServer(server);
        return roomRepository.save(room);}
    public List<rooms> findRooms(rooms room){return roomRepository.findAllByServerServerCode(room.getServer().getServerCode());}
    public void updateRoom(rooms room){
        Optional<rooms> optionalRooms = roomRepository.findById(room.getRoomCode());
        if(optionalRooms.isPresent()){
            rooms updateRoom = optionalRooms.get();
            updateRoom.setRoomPeople(room.getRoomPeople());
            roomRepository.save(updateRoom);
        }
        else {
            // 해당 ID에 대한 방이 존재하지 않을 경우 예외 처리합니다.
            throw new IllegalArgumentException("room_code " + room.getRoomCode() + " not found.");

        }
    }
    public void modifyRoom(rooms room){
        Optional<rooms> optionalRooms = roomRepository.findById(room.getRoomCode());
        if(optionalRooms.isPresent()){
            rooms modifyRoom = optionalRooms.get();
            modifyRoom.setRoomTitle(room.getRoomTitle());
            modifyRoom.setGameCode(room.getGameCode());
            modifyRoom.setMapCode(room.getMapCode());
            modifyRoom.setRoomLimit(room.getRoomLimit());
            roomRepository.save(modifyRoom);
        }
        else {
            // 해당 ID에 대한 방이 존재하지 않을 경우 예외 처리합니다.
            throw new IllegalArgumentException("room_code " + room.getRoomCode() + " not found.");

        }
    }
    public void deleteRoom(Integer room_code){
        roomRepository.deleteById(room_code);
    }
}
