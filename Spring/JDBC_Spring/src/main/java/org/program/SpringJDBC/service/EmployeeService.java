package org.program.SpringJDBC.service;
import org.program.SpringJDBC.model.Employee;
import org.program.SpringJDBC.repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EmployeeService {
    private EmployeeRepo repo;

    public EmployeeRepo getRepo() {
        return repo;
    }

    @Autowired
    public void setRepo(EmployeeRepo repo) {
        this.repo = repo;
    }

    public void hireEmployee(Employee newEmployee) {
        repo.save(newEmployee);
    }

    public List<Employee> getEmployees() {
        return repo.findAll();
    }


    public void fireEmployee(int id) {
        repo.deleteById(id);
    }
}
