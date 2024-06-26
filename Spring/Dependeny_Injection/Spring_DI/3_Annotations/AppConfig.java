package org.example.config;

import org.example.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;

@Configuration
public class AppConfig {
//    @Bean(name={"com1","desk","top",})
//    @Bean(name="Com1")
    @Bean
    @Scope("prototype")
    public Desktop desktop(){
        return new Desktop();
    }
    @Bean
    public Alien alien( @Autowired Computer com){ //(@Qualifier("laptop") @Autowired Computer com)
        Alien obj=new Alien();
        obj.setLanguage("rust");
        obj.setCom(com);
        return obj;
    }
    @Bean
    public Laptop laptop(){
        return new Laptop();
    }
    @Bean
    @Primary
    public SmartGlass smartGlass(){
        return new SmartGlass();
    }
}
