package com.game.backend.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class usersService {
    private final usersRepository userRepository;
    @Autowired
    public usersService(usersRepository userRepository){
        this.userRepository=userRepository;
    }

    public users save(users user){return userRepository.save(user);}
    public List<users>findAll(){return userRepository.findAll();}
    public responseDTO userLogin(users user){
        Optional<users> optionalUser = userRepository.findByUserIdAndUserPassword(user.getUserId(),user.getUserPassword());
        if(optionalUser.isPresent()){
        users serverUser =optionalUser.get();
        responseDTO responsedto = new responseDTO();
        responsedto.setUserCode(serverUser.getUserCode());
        responsedto.setUserName(serverUser.getUserName());
        return responsedto;
       }
        else {
           return null;
       }
    }
    public responseDTO userPassword(users user){
        Optional<users> optionalUser = userRepository.findByUserIdAndUserAnswer(user.getUserId(),user.getUserAnswer());
        if(optionalUser.isPresent()){
            users serverUser =optionalUser.get();
            responseDTO responsedto = new responseDTO();
            responsedto.setUserPassword(serverUser.getUserPassword());
            return responsedto;
        }
        else {
            return null;
        }
    }
    public responseDTO idCheck(String user_id){
        Optional<users> optionalUser = userRepository.findByUserId(user_id);
        responseDTO responsedto =new responseDTO();
        if(optionalUser.isPresent()){
            responsedto.setIdCheck(true);
        }
        else{
            responsedto.setIdCheck(false);
        }
        return responsedto;
    }
    public Optional<users>findById(int user_code){return userRepository.findById(user_code);}
    public void deleteById(int user_code){userRepository.deleteById(user_code);}

}
