import java.sql.*;

//Prepared Statements
public class Test_jdbc_03 {
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
            con=DriverManager.getConnection(url,user,password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        System.out.println("connection established");

        //Getting data from variables 
        //Approach-1;

//        Statement st=null;
//        try {
//            st=con.createStatement();
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//        //create operation (CRUD Operation)
//        int empid1=6,empsalary1=33;
//        String empname1="lak";
//        String sqlQuery="insert into employees values("+ empid1 +" , '"+ empname1 +"' , "+ empsalary1 +" )";
//        boolean status=false;
//        try {
//            status=st.execute(sqlQuery);
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//        System.out.println("status : "+status);
//
//        try {
//            con.close();
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//        System.out.println("connection closed");

        //Approach-2;
        int empid2=7,empsalary2=44;
        String empname="Laptop";

        String sqlQuery="insert into employees values (?,?,?)";
        PreparedStatement ps=null;
        try {
            ps=con.prepareStatement(sqlQuery);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        try {
            ps.setInt(3,empsalary2);
            ps.setInt(1,empid2);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        try {
            ps.setString(2,empname);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        try {
            ps.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        try {
            con.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        System.out.println("connection closed");


    }
}
