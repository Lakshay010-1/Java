package com.DI.SpringBoot_DI;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringBootDiApplication {

	public static void main(String[] args) {
		ApplicationContext context =SpringApplication.run(SpringBootDiApplication.class, args);
		Alien alien=context.getBean(Alien.class);
		alien.code();
	}

}
