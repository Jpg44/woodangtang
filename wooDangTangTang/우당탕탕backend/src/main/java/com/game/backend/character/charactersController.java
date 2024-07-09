package com.game.backend.character;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/character")
public class charactersController {
    private final charactersService characterService;
    @Autowired
    public charactersController(charactersService characterService){
        this.characterService=characterService;
    }
    @PostMapping("/add")
    public characters characterAdd(@RequestBody charactersDTO characterDto){
        return characterService.characterAdd(characterDto);
    }
    @PutMapping("/unlock")
    public userCharacters characterUnlock(@RequestBody userCharacters userCharacter){
        return characterService.characterUnlock(userCharacter);
    }
    @PostMapping("/list")
    public List<charactersDTO> charactersGetList(@RequestBody int user_code){
        return characterService.chractersGetList(user_code);
    }
}
