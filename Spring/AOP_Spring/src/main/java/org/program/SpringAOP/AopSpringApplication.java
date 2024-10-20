package org.program.SpringAOP;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AopSpringApplication {
	public static void main(String[] args) {
		SpringApplication.run(AopSpringApplication.class, args);
		System.out.println("AOP");
	}
}
