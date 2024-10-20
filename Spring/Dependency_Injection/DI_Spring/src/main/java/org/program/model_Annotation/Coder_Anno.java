package org.program.model_Annotation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Coder_Anno {
    private int rating;
//    @Autowired // Field Injection
    private Computer_Anno com;

    public Coder_Anno(){}

    public Coder_Anno(int rating, Computer_Anno com){
        this.rating=rating;
        this.com=com;
    }

//    @Autowired  // Constructor Injection
    public Coder_Anno(Computer_Anno com){
        this.com=com;
    }

    public int getRating() {
        return rating;
    }

    @Value("10")
    public void setRating(int rating) {
        this.rating = rating;
    }

    public Computer_Anno getCom() {
        return com;
    }

    @Autowired   //Setter Injection
    @Qualifier("com_02")
    public void setCom(Computer_Anno com) {
        this.com = com;
    }
    public void code(){
        com.compile();
        System.out.println("Coding...");
    }
}
