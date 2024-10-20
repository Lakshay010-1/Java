package org.program.DI_SpringBoot.model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Coder {

    private int rating;
    private Computer com;

    public Coder() {
    }

    public Coder(int rating) {
        this.rating = rating;
    }

    public Coder(Computer com) {
        this.com = com;
    }

    public Coder(int rating, Computer com) {
        this.rating = rating;
        this.com = com;
    }

    public int getRating() {
        return rating;
    }

    @Value("99")
    public void setRating(int rating) {
        this.rating = rating;
    }

    public Computer getCom() {
        return com;
    }

    @Autowired
    @Qualifier("desktop")
    public void setCom(Computer com) {
        this.com = com;
    }

    public void code(){
        com.compile();
        System.out.println("Coding...");
    }
}
