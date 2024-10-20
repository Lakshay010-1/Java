package org.program.SpringSecurity.controller;
import jakarta.servlet.http.HttpServletRequest;
import org.program.SpringSecurity.model.Employee;
import org.program.SpringSecurity.repo.EmployeeRepo;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class EmployeeController {
    EmployeeRepo repo=new EmployeeRepo();

    @GetMapping("employees")
    public List<Employee> getEmployees(){
        return repo.getEmployee();
    }

//    CSRF token is required to perform add,update,or delete operation

    @GetMapping("get-csrf-token")
    public CsrfToken getCsrf(HttpServletRequest req){
        return (CsrfToken) req.getAttribute("_csrf");
    }

    @PostMapping("employees")
    public Employee addEmployee(@RequestBody Employee e){
        return repo.addEmployee(e);
    }

}
