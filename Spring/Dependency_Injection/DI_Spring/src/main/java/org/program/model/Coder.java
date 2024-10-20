package org.program.model;

public class Coder {
    private int rating;
    private Computer com;

    public Coder(){}

    public Coder(int rating,Computer com){
        this.rating=rating;
        this.com=com;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public Computer getCom() {
        return com;
    }

    public void setCom(Computer com) {
        this.com = com;
    }
    public void code(){
        com.compile();
        System.out.println("Coding...");
    }
}
