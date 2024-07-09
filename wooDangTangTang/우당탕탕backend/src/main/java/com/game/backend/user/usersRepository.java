package com.game.backend.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface usersRepository extends JpaRepository<users,Integer> {
    Optional<users> findByUserId(String userId);
    Optional<users> findByUserIdAndUserPassword(String userId, String userPassword);


    Optional<users> findByUserIdAndUserAnswer(String userId, String userAnswer);

    Optional<users> findByUserCode(int userCode);

    Optional<users> findByUserPassword(String userId);
}
