package com.game.backend.userdata;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface userDataRepository extends JpaRepository<userData,userData> {
    List<userData> findAllByUserUserCode(int userCode);

    userData findByUserUserCodeAndDatatableDataCode(int userCode, int dataCode);
}
