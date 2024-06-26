package org.example;
import org.example.config.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext context=new AnnotationConfigApplicationContext(AppConfigAnnotations.class);
        Alien al=context.getBean("alien",Alien.class);
        System.out.println(al.getLanguage());
        al.code();



        /*XML
        ApplicationContext context=new ClassPathXmlApplicationContext("springDI.xml");
        //Alien al= (Alien) context.getBean("alien");
        //Alien al=context.getBean(Alien.class);
        Alien al=context.getBean("alien",Alien.class);
        System.out.println(al.getLanguage());
        al.code();
        */

    }
}
