import org.springframework.stereotype.Component;

@Component
public class Sunglass implements  Computer{
    public void compile(){
        System.out.println("Coding using sunglasses...");
    }
}
