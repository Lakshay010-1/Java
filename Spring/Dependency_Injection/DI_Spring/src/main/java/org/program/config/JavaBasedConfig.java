package org.program.config;
import org.program.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.*;

@Configuration
public class JavaBasedConfig {

    @Bean(name = {"coder_01"})
    @Lazy
    @Scope("singleton")
    public Coder coder(@Qualifier("com_01") @Autowired Computer com){
        Coder c=new Coder();
        c.setRating(8);
        c.setCom(com);
        return c;
    }

    @Bean(name={"coder_02"})
    @Lazy
    @Scope("prototype")
    public Coder coder2(@Qualifier("com_02") @Autowired Computer com){
        Coder c=new Coder();
        c.setRating(21);
        c.setCom(com);
        return c;
    }

    @Bean(name = {"com_02","desktop"})
    @Primary
    @Lazy
    public Desktop desktop(){
        return new Desktop();
    }

    @Bean(name = {"laptop","com_01"})
    @Lazy
    public Laptop laptop(){
        return new Laptop();
    }

}