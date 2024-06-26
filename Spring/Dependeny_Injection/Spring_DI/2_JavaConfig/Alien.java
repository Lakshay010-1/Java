package org.example;
import java.beans.ConstructorProperties;


public class Alien {
    private String language;
    private Computer com;

    public Alien( ) {}

    public Alien(String language, Computer com) {
        this.language = language;
        this.com = com;
    }

    public Computer getCom() {
        return com;
    }
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
