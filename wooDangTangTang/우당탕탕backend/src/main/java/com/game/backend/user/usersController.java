package com.game.backend.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class usersController {
    private final usersService userService;
    @Autowired
    public usersController(usersService userService){
        this.userService=userService;
    }
    @PostMapping("/signup")
    public users createUser(@RequestBody users user){return userService.save(user);}
    @PostMapping("/login")
    public responseDTO userLogin(@RequestBody users user){return userService.userLogin(user);}
    //public Optional<users>getUserById(@RequestBody users user){return userService.findById(user.getUser_code());}
    //public List<users>getUsers(){return userService.findAll();}
    @PostMapping("/check")
    public responseDTO userCheckId(@RequestBody users user){return userService.idCheck(user.getUserId());}
    @PostMapping("/password")
    public responseDTO userPassword(@RequestBody users user){return userService.userLogin(user);}
    @DeleteMapping("/delete")
    public void deleteUserById(@RequestBody users user){userService.deleteById(user.getUserCode());}


}
