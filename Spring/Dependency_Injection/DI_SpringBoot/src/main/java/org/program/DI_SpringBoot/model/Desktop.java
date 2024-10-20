package org.program.DI_SpringBoot.model;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
public class Desktop implements Computer{
    @Override
    public void compile() {
        System.out.println("Compiling using Desktop...");
    }
}