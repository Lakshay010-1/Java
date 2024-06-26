package org.example;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import java.beans.ConstructorProperties;

@Component
public class Alien {
    @Value("React")
    private String language;
    //@Autowired //Field Injection
    private Computer com;

    public Alien( ) {}

    public Alien(String language, Computer com) {
        this.language = language;
        this.com = com;
    }

    public Computer getCom() {
        return com;
    }
    @Autowired //Setter Injection
    @Qualifier("desktop")
    public void setCom(Computer com) {
        this.com = com;
    }
    public String getLanguage() {
        return language;
    }
    public void setLanguage(String language) {
        this.language = language;
    }
    public void code(){
        com.compile();
    }
}
