package org.program.SpringSecurity.controller;
import org.program.SpringSecurity.model.Users;
import org.program.SpringSecurity.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    private BCryptPasswordEncoder bCryptPasswordEncoder=new BCryptPasswordEncoder(10);

    @PostMapping("register")
    public Users register(@RequestBody Users user){
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        return userService.register(user);
    }

    @PostMapping("login")
    public String login(@RequestBody Users user){
        return userService.verify(user);
    }

}
