package com.game.backend.userdata;

import org.springframework.data.jpa.repository.JpaRepository;


public interface dataTableRepository extends JpaRepository<dataTable , Integer> {
    String findDataNameByDataCode(int dataCode);

    int findByDataName(String dataName);
}
