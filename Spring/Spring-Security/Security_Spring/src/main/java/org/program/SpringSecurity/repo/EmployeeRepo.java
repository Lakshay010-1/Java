package org.program.SpringSecurity.repo;
import org.program.SpringSecurity.model.Employee;
import java.util.ArrayList;
import java.util.List;

public class EmployeeRepo {
    ArrayList<Employee> list=new ArrayList<>(List.of(new Employee(1,"Raj"),new Employee(2,"Rajesh"),new Employee(3,"Raju")));

    public ArrayList<Employee> getEmployee(){
        return list;
    }
    public Employee addEmployee(Employee e){
        list.add(e);
        return e;
    }

}
