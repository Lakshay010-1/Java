package org.program.Web_SpringBoot;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WebSpringBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebSpringBootApplication.class, args);
		System.out.println("This program can perform two tasks: \n1.Sum two numbers and,\n 2.Add a question to Question Paper");
	}

}
