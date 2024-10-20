package org.program.Data_JPA;
import org.program.Data_JPA.model.Employee;
import org.program.Data_JPA.repo.EmployeeRepo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class JpaSpringBootApplication {

	public static void main(String[] args) {
		ApplicationContext context=SpringApplication.run(JpaSpringBootApplication.class, args);

		Employee emp1=context.getBean(Employee.class);
		emp1.setId(1);
		emp1.setName("Raj");
		emp1.setSalary(100000);

		Employee emp2=context.getBean(Employee.class);
		emp2.setId(2);
		emp2.setName("Rajesh");
		emp2.setSalary(105200);

		Employee emp3=context.getBean(Employee.class);
		emp3.setId(3);
		emp3.setName("Raju");
		emp3.setSalary(990000);

		EmployeeRepo repo=context.getBean(EmployeeRepo.class);

////	Create the entity in the database or update if exist-Create,Update Operation
		repo.save(emp1);
		repo.save(emp2);
		repo.save(emp3);

////	Select/Fetch all entities from the database-Read Operation
		System.out.println(repo.findAll());
		System.out.println("\n"+ repo.findAll() +"\n");

////	Select/Fetch desired entity from the database
		Optional<Employee> byID=repo.findById(1);
		List<Employee> byName=repo.findByName("Raj");
		List<Employee> bySalary=repo.findBySalary(100000);
		List<Employee> bySalaryG=repo.findBySalaryGreaterThan(100000);
		List<Employee> bySalaryL=repo.findBySalaryLessThan(150000);

		////orElse() to avoid null point exception
		System.out.println("\n"+ byID.orElse(new Employee()) +"\n");

		System.out.println(byName + "\n");
		System.out.println(bySalary + "\n");
		System.out.println(bySalaryG + "\n");
		System.out.println(bySalaryL + "\n");

////	delete the desired entity
		repo.delete(emp2);
	}

}
