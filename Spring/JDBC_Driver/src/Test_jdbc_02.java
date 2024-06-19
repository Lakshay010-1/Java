import java.sql.*;

//CRUD Operation
public class Test_jdbc_02 {
    //"employees" is the name of the table
    public static void main(String[] args) {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        Connection con=null;
        // String url=             ; e.g."jdbc:postgresql://localhost:5432/test_01";
        // String user=            ; e.g."postgres";
        // String password=        ; e.g.*****;

        try {
            con= DriverManager.getConnection(url,user,password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        System.out.println("connection established");

        Statement st=null;
        try {
            st=con.createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        //create operation (CRUD Operation)
        String sqlQuery="insert into employees values(2,'Luck',50)";
        //update operation(CRUD Operation)
        //String sqlQuery="update employees set empname='Luck' where empid=2";
        //delete operation (delete operation)
        //String sqlQuery="delete from employees where empid=2";
        boolean status=false;
        try {
            status=st.execute(sqlQuery);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        System.out.println("status : "+status);

        try {
            con.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        System.out.println("connection closed");

    }
}
