package com.project.Backend_Layers;
import com.project.Backend_Layers.model.Computer;
import com.project.Backend_Layers.service.ComService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import java.util.*;

@SpringBootApplication
public class BackendLayersApplication {

	public static void main(String[] args) {
		ApplicationContext context=SpringApplication.run(BackendLayersApplication.class, args);
		Computer com=context.getBean(Computer.class);
		com.setBrand("Laptop");
		com.setRating(10);
		com.setPrice(600000);
		ComService comSer=context.getBean(ComService.class);
		comSer.addCom(com);

		List<Computer> comList=comSer.getCom();
		System.out.println(comList);

		System.out.println("Task Completed...");

	}

}
