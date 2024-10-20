package org.program.SpringJDBC;
import org.program.SpringJDBC.model.Employee;
import org.program.SpringJDBC.service.EmployeeService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import java.util.List;

@SpringBootApplication
public class SpringJdbcApplication {
	public static void main(String[] args) {
		ApplicationContext context=SpringApplication.run(SpringJdbcApplication.class, args);
		EmployeeService service=context.getBean(EmployeeService.class);

		Employee newEmployee=context.getBean(Employee.class);
		newEmployee.setId(4);
		newEmployee.setName("Rajesh");
		newEmployee.setSalary(50000);

		service.hireEmployee(newEmployee);
		service.fireEmployee(1);
		List<Employee> employeeList=service.getEmployees();
		System.out.println(employeeList);

	}
}
