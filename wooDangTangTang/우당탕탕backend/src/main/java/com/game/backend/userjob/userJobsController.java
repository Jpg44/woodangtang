package com.game.backend.userjob;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/job")
public class userJobsController {
    private final userJobsService userJobService;
    @Autowired
    public userJobsController(userJobsService userJobService){
        this.userJobService=userJobService;
    }
    @PostMapping("/add")
    public userJobs addJobs(@RequestBody userJobsDTO userJobDto){
        return userJobService.addJob(userJobDto);
    }
    @PostMapping("/random")
    public List<userJobsDTO> userJobsRandom(@RequestBody userJobsDTO userJobDto){
        return userJobService.randomJob(userJobDto);
    }
    @GetMapping("/list")
    public List<userJobs> userJobsList(){
        return userJobService.userJobsList();
    }
}
