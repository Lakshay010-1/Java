package org.example;
import org.example.config.*;
import org.example.model.Alien;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class Application 
{
    public static void main( String[] args )
    {
       
        /*
        //XML
        ApplicationContext context=new ClassPathXmlApplicationContext("springDI.xml");
        */
        
        /*
        //Java Based Config
        ApplicationContext context=new AnnotationConfigApplicationContext(AppConfig.class);
         */

         //Annotations
        ApplicationContext context=new AnnotationConfigApplicationContext(AppConfigAnnotations.class);
        //1. Getting bean by specifiying id/name of the bean and TypeCasting from Object Class to Desired Class
        //Alien al= (Alien) context.getBean("alien");
        //2. Getting bean on Class type Basis
        //Alien al=context.getBean(Alien.class);
        //3. Getting bean by specifiying id/name of the bean and desired type of the output
        Alien al=context.getBean("alien",Alien.class);
        System.out.println(al.getLanguage());
        al.code();

        

    }
}
