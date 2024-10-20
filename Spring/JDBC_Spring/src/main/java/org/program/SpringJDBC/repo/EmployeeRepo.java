package org.program.SpringJDBC.repo;
import org.program.SpringJDBC.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class EmployeeRepo {

    private JdbcTemplate jdbc;

    public JdbcTemplate getJdbc() {
        return jdbc;
    }

    @Autowired
    public void setJdbc(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    public void save(Employee newEmployee) {
        String sqlQuery="insert into employees (id,name,salary) values(?,?,?)";
        int affectedRows=jdbc.update( sqlQuery, newEmployee.getId(), newEmployee.getName(), newEmployee.getSalary());
    }

    public void deleteById(int id) {
        String sqlQuery="delete from employees where id=?";
        int rowsAffected=jdbc.update(sqlQuery,id);
    }

    public List<Employee> findAll() {
        RowMapper<Employee> mapper=(rs,rowNum) -> {
//                return new Employee(rs.getInt(1),rs.getString(2),rs.getInt(3));
              return new Employee(rs.getInt("id"),rs.getString("name"),rs.getInt("salary"));       //or columnLabel
        };
        String sqlQuery="select * from employees";
        return jdbc.query(sqlQuery,mapper);
    }
}
