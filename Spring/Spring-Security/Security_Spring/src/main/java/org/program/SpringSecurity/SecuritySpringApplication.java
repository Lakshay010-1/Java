package org.program.SpringSecurity;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SecuritySpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(SecuritySpringApplication.class, args);
		System.out.println("Spring Security");
	}

}
