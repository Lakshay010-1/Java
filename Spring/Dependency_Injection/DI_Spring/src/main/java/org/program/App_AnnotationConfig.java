package org.program;
import org.program.config.AnnotationsConfig;
import org.program.model_Annotation.Coder_Anno;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App_AnnotationConfig
{
    public static void main( String[] args )
    {
        System.out.println("Annotations");
        ApplicationContext context=new AnnotationConfigApplicationContext(AnnotationsConfig.class);
        Coder_Anno coder=context.getBean(Coder_Anno.class);
        System.out.println("Rating is : "+coder.getRating());
        coder.code();

    }
}