package org.program.DI_SpringBoot;
import org.program.DI_SpringBoot.model.Coder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class DI_SpringBootApplication {

	public static void main(String[] args) {
		ApplicationContext context=SpringApplication.run(DI_SpringBootApplication.class, args);
		Coder coder=context.getBean(Coder.class);
		System.out.println("Rating is : "+coder.getRating());
		coder.code();
	}

}
