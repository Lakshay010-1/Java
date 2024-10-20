package org.program.model;

public class Desktop implements Computer{

    @Override
    public void compile() {
        System.out.println("Compiling Using Desktop...");
    }
}
