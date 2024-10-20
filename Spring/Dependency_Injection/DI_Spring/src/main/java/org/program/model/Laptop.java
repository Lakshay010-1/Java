package org.program.model;

public class Laptop implements Computer{
    @Override
    public void compile() {
        System.out.println("Compiling Using Laptop...");
    }
}
