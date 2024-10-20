package org.program.Data_JPA.repo;
import org.program.Data_JPA.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee,Integer> {

    //Query contains JPQL[Jakarta/Java Persistence Query Language]
    //"?1" to specify the value for first parameter. i.e. "?n" for nth variable in parameter,"?2" for second parameter.
    @Query("select e from Employee e where e.name=?1")
    List<Employee> findByName(String Name);

//    @Query Annotation is optional for some Cases/functions, for others @Query annotation is required.
//    JPA uses DSL(Domain Specific Language which creates some functions internally )
    List<Employee> findBySalary(int Salary);
    List<Employee> findBySalaryGreaterThan(int Salary);
    List<Employee> findBySalaryLessThan(int Salary);
}
