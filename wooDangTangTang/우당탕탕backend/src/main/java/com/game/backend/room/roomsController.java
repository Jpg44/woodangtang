package com.game.backend.room;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/room")
public class roomsController {
    private final roomsService roomService;
    @Autowired
    public roomsController(@RequestBody roomsService roomService){
        this.roomService = roomService;
    }
    @PostMapping("/list")
    public List<rooms> findRooms(@RequestBody rooms room){return roomService.findRooms(room);}
    @PostMapping("/create")
    public rooms createRoom(@RequestBody rooms room){return roomService.createRoom(room);}
    @PutMapping("/update")
    public void updateRoom(@RequestBody rooms room){roomService.updateRoom(room);}
    @PutMapping("/modify")
    public void modifyRoom(@RequestBody rooms room){roomService.modifyRoom(room);}
    @DeleteMapping("/delete")
    public void deleteRoom(@RequestBody rooms room){roomService.deleteRoom(room.getRoomCode());}

}
