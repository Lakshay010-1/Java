package com.project.Backend_Layers.repo;
import com.project.Backend_Layers.model.Computer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class ComRepo {
    private JdbcTemplate jdbc;

    public JdbcTemplate getJdbc() {
        return jdbc;
    }
    @Autowired
    public void setJdbc(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    public void save(Computer com){
        String sql="insert into computer (brand,rating,price) values (?,?,?)";
        int rowAffected=jdbc.update(sql,com.getBrand(),com.getRating(),com.getPrice());
        System.out.println("Rows Affected "+rowAffected);
        System.out.println("Added in list...");
    }

    public List<Computer> findAll() {
        String sql="select * from computer";
        RowMapper<Computer> mapper =new RowMapper<Computer>() {
            @Override
            public Computer mapRow(ResultSet rs, int rowNum) throws SQLException {
               Computer com=new Computer();
               com.setBrand(rs.getString("brand"));
               com.setRating(rs.getInt("rating"));
               com.setPrice(rs.getInt("price"));
               return com;
            }
        };
        return jdbc.query(sql,mapper);

    }
}
