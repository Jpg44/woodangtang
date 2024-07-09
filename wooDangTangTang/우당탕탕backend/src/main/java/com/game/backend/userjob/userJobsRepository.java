package com.game.backend.userjob;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface userJobsRepository extends JpaRepository<userJobs,Integer> {
    List<userJobs>findByJobTeam(String jobsTeam);
}
