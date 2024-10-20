package org.program.SpringSecurity.controller;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping({"/","home"})
    public String greet(HttpServletRequest req){
        System.out.println(req.getSession().getId());
        return "Hello To You";
    }
}
