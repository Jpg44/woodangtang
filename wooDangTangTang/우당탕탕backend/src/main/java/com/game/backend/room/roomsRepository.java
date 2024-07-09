package com.game.backend.room;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface roomsRepository extends JpaRepository<rooms, Integer> {
    List<rooms> findAllByServerServerCode(int serverCode);
}
