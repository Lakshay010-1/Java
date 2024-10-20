package org.program.SpringSecurity.service;
import org.program.SpringSecurity.model.Users;
import org.program.SpringSecurity.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;


@Service
public class UserService {

    @Autowired
    UserRepo repo;
    @Autowired
    AuthenticationManager authManager;
    @Autowired
    JWTService jwtService;

    public Users register(Users u){
        return repo.save(u);
    }

    public String verify(Users user) {
        Authentication authentication=authManager
                .authenticate(new UsernamePasswordAuthenticationToken(user.getName(),user.getPassword()));
        return (authentication.isAuthenticated())?jwtService.generateToken(user.getName()):"Fail";
    }
}
