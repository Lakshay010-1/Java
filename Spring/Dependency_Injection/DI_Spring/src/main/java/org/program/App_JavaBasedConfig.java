package org.program;
import org.program.config.JavaBasedConfig;
import org.program.model.Coder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App_JavaBasedConfig
{
    public static void main( String[] args )
    {
        System.out.println("Java Based");
        ApplicationContext context=new AnnotationConfigApplicationContext(JavaBasedConfig.class);

        Coder coder1=context.getBean("coder_01",Coder.class);
        System.out.println("Rating is : "+coder1.getRating());
        coder1.code();

        System.out.println();

        Coder coder2=context.getBean("coder_02",Coder.class);
        System.out.println("Rating is : "+coder2.getRating());
        coder2.code();
    }
}