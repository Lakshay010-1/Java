package org.program.OAuth2_Login.controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping({"/","home"})
    public String home(){
        return "Welcome to The Home Page";
    }
}