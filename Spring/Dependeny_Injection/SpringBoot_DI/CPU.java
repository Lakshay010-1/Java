package com.project.SpringBoot_DI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CPU {
    @Autowired
    Compiler compiler;
    public void process() {
        compiler.compile();
    }
}
