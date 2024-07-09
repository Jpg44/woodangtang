package com.game.backend.userjob;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class userJobsService {
    private final userJobsRepository userJobRepository;

    @Autowired
    public userJobsService(userJobsRepository userJobRepository) {
        this.userJobRepository = userJobRepository;
    }

    public userJobs addJob(userJobsDTO userJobDto){
        userJobs userJob =new userJobs();
        userJob.setJobName(userJobDto.getJobName());
        userJob.setJobTeam(userJobDto.getJobTeam());
        return userJobRepository.save(userJob);
    }
    public List<userJobs> userJobsList(){
        return  userJobRepository.findAll();
    }

    public List<userJobsDTO> randomJob(userJobsDTO userJobDto) {
        List<userJobsDTO> userJobdtoList = new ArrayList<>() ;
        int usersNum = userJobDto.getUserCodes().length;
        int[] usersCode = userJobDto.getUserCodes();
        int spyNum=userJobDto.getSpyNum();
        int selfishNum=userJobDto.getSelfishNum();
        int wildNum=userJobDto.getWildNum();
        List<userJobs> spyJobs = userJobRepository.findByJobTeam("spy");
        List<userJobs> selfishJobs = userJobRepository.findByJobTeam("selfish");
        List<userJobs> wildJobs = userJobRepository.findByJobTeam("wild");
        shuffleArray(userJobDto.getUserCodes());
        shuffleJobs(spyJobs);
        shuffleJobs(selfishJobs);
        shuffleJobs(wildJobs);
        for(int i=0;i<usersNum;i++){
            userJobsDTO userJobdto =new userJobsDTO();
            if(i<spyNum){
                System.out.println("%%%%%%아디?");
                userJobdto.setJobName(spyJobs.get(i).getJobName());
                userJobdto.setUserCode(usersCode[i]);
                userJobdto.setJobTeam("spy");
            } else if (i<spyNum+selfishNum) {
                userJobdto.setJobName(selfishJobs.get(i-spyNum).getJobName());
                userJobdto.setUserCode(usersCode[i]);
                userJobdto.setJobTeam("selfish");
            } else if (i<spyNum+selfishNum+wildNum) {
                userJobdto.setJobName(wildJobs.get(i-spyNum-selfishNum).getJobName());
                userJobdto.setUserCode(usersCode[i]);
                userJobdto.setJobTeam("wild");
            }
            userJobdtoList.add(userJobdto);
        }
        return userJobdtoList;

    }
    private static void shuffleArray(int[] array) {
        Random rand = new Random();
        for (int i = array.length - 1; i > 0; i--) {
            int j = rand.nextInt(i + 1); // 0부터 i까지의 랜덤한 인덱스 선택
            // 현재 인덱스의 값과 랜덤한 인덱스의 값 교환
            int temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }
    }

    private static void shuffleJobs(List<userJobs> array) {
        Random rand = new Random();
        for (int i = array.size() - 1; i > 0; i--) {
            int j = rand.nextInt(i + 1); // 0부터 i까지의 랜덤한 인덱스 선택
            // 현재 인덱스의 값과 랜덤한 인덱스의 값 교환
            userJobs temp = array.get(i);
            array.set(i, array.get(j));
            array.set(j, temp);
        }
    }
}