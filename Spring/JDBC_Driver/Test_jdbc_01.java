import java.util.*;
//Step.1-import package;
 import java.sql.*;

public class Test_jdbc_01 {
    public static void main(String[] args) {

        //Step.2-load and register driver;
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        //Step.3-Create connection;
        Connection con=null;
        Scanner sc=new Scanner(System.in);
        String url=sc.next();             ; //e.g."jdbc:postgresql://localhost:5432/test_01";
        String user=sc.next();            ; //e.g."postgres";
        String password=sc.next();        ; //e.g.*****;
        try {
            con=DriverManager.getConnection(url,user,password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        System.out.println("connection established");

        //Step.4-create statement;
        Statement st=null;
        try {
            st=con.createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        String sqlQuery="select * from employees"; //"employees" is the name of the table

        // Step.5-execute statement;
        ResultSet rs=null;
        try {
            rs=st.executeQuery(sqlQuery);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        //Step.6-process the result;
        try {
            //Read operation(CRUD operation)
            while(rs.next()){
                System.out.println(rs.getInt(1)+" : "+rs.getString(2)+" : "+rs.getInt(3));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        //Step.7-close;
        try {
            con.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        System.out.println("connection closed");

    }
}
