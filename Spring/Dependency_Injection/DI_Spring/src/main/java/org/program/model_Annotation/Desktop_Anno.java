package org.program.model_Annotation;
import org.springframework.stereotype.Component;

@Component("com_02")
public class Desktop_Anno implements Computer_Anno {
    @Override
    public void compile() {
        System.out.println("Compiling Using Desktop...");
    }
}
