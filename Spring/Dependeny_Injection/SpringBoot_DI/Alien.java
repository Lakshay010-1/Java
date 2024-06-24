package com.project.SpringBoot_DI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Alien {
    @Autowired
    CPU cpu;
    public void code(){

        cpu.process();
    }
}
