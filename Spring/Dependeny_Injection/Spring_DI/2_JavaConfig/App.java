package org.example;
import org.example.config.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext context=new AnnotationConfigApplicationContext(AppConfig.class);
        Alien al=context.getBean("alien",Alien.class);
        System.out.println(al.getLanguage());
        al.code();
    }
}
