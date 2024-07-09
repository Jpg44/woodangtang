package com.game.backend.character;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class charactersService {
    private final charactersRepository characterRepository;
    private final userCharactersRepository userCharacterRepository;
    @Autowired
    public charactersService(charactersRepository characterRepository,userCharactersRepository userCharacterRepository){
        this.characterRepository=characterRepository;
        this.userCharacterRepository=userCharacterRepository;
    }


    public characters characterAdd(charactersDTO characterDto){
        characters character = new characters();
        character.setCharacterName(characterDto.getCharacterName());
        return characterRepository.save(character);
    }
    public userCharacters characterUnlock(userCharacters userCharacter){
       return userCharacterRepository.save(userCharacter) ;
    }
    public List<charactersDTO>chractersGetList(int user_code){
        List<charactersDTO> charactersDtoList = new ArrayList<>();
        List<characters> charactersList = characterRepository.findAll();
        List<userCharacters>userCharactersList =new ArrayList<>();

        for(characters character:charactersList){
            boolean state = userCharacterRepository.existsByUserUserCodeAndCharacterCharacterCode(user_code,character.getCharacterCode());
            charactersDTO characterDto=new charactersDTO();
            characterDto.setCharacterName(character.getCharacterName());
            characterDto.setCharacterCode(character.getCharacterCode());
            characterDto.setCharacterHold(state);
            charactersDtoList.add(characterDto);
        }

        return charactersDtoList;
    }
}
