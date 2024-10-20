package org.program.model_Annotation;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("com_01")
@Primary
@Scope("prototype")
public class Laptop_Anno implements Computer_Anno {
    @Override
    public void compile() {
        System.out.println("Compiling Using Laptop...");
    }
}
