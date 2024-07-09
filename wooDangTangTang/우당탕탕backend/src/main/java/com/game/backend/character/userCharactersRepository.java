package com.game.backend.character;

import org.springframework.data.jpa.repository.JpaRepository;

public interface userCharactersRepository extends JpaRepository<userCharacters,Integer> {
    boolean existsByUserUserCodeAndCharacterCharacterCode(int userCode, int characterCode);
}
