package org.program;
import java.sql.*;      //Step.1-import package;

public class Steps_JDBC {
    public static void main(String[] args) throws Exception {

/*      Steps to Connect Java Application with Database:-
        Step 1 – Import the Packages
        Step 2 – Load the drivers using the forName() method and Register the drivers using DriverManager {Optional}
        Step 3 – Establish a connection using the Connection class object
        Step 4 – Create a statement
        Step 5 – Execute the query
        Step 6 – Process the Result
        Step 7 – Close the connections
*/

        //Step.2-Load driver;
        Class.forName("org.postgresql.Driver");    //DB Driver

        //Step.3-Register Driver and Create connection;
        Connection con=null;
        String url= "jdbc:postgresql://localhost:5432/DB_Name";  //e.g."jdbc:mysql://localhost:3306/DB_Name";
        String user="postgres";                                  //e.g.-"mysql","oracle"
        String password="DB_Password";                           //e.g.database server password
        con=DriverManager.getConnection(url,user,password);
        System.out.println("connection established");

        //Step.4-create statement;
        Statement st=con.createStatement();
        String sqlQuery="select * from table_Name";

        // Step.5-execute statement;
        ResultSet rs=st.executeQuery(sqlQuery);

        //Step.6-process the result;
        while(rs.next()){
            System.out.println(rs.getInt(1)+" : "+rs.getString(2)+" : "+rs.getInt(3)); //accessing Data from the table
        }

        //Step.7-close;
        con.close();
        System.out.println("connection closed");

    }
}