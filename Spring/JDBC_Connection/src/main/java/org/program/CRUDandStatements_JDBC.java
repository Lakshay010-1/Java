package org.program;
import java.sql.*;                                                                   //Step-1

public class CRUDandStatements_JDBC {
    public static void main(String[] args) throws Exception{

        Class.forName("org.postgresql.Driver");                             //Step-2
        String url="jdbc:postgresql://localhost:5432/DB_Name";
        String user="postgres";
        String password="DB_Password";
        Connection connection=DriverManager.getConnection(url,user,password);         //Step-3

//      Statement and PreparedStatement                                               //Step-4
        int Emp_ID=4,Emp_Salary=20000;
        String Emp_Name="Leo";
        /* Statement - Used for CREATE, ALTER, DROP statements,
                       Used to execute normal SQL queries,
                       Used when SQL query is to be executed only once,
                       Not Support to pass parameters at runtime.
        */
        Statement statement=connection.createStatement();
//      CRUD Operations (Create ,Read ,Update ,Delete)
        //Create
        String createSQLQuery="insert into employees values(2,'Raj',50)";
        //i.e."insert into table_Name(column1,column2,column3) values(value1,value2,value3)";
        //Read
        String readSQLQuery="select id,name from employees where Emp_ID%2==0";
        //i.e."select * from table_Name"; OR "select col1,col2,col3,... from table_Name";
        //Update
        String updateSQLQuery="update employees set Emp_Name='Rajesh' where Emp_ID=2";
        //i.e."update table_Name set column1=value1, column2 = value2,... where condition";
        //Delete
        String deleteSQLQuery="delete from employees where Emp_ID=2";
        //i.e."delete from table_Name where condition";

        String sSQLQuery="insert into employees values("+Emp_ID+" ,'"+Emp_Name+"' ,"+Emp_Salary+")";

        /* PreparedStatement -  Provides a feature to execute a parameterized query,
                                Used to execute dynamic SQL queries,
                                Used when SQL query is to be executed multiple times,
                                Support pass parameters at runtime.
        */


        String psSQLQuery="insert into employees values(?,?,?)";
        PreparedStatement preparedStatement=connection.prepareStatement(psSQLQuery);
        preparedStatement.setInt(3,Emp_Salary);
        preparedStatement.setString(2,Emp_Name);
        preparedStatement.setInt(1,Emp_ID);


        boolean status=statement.execute(sSQLQuery);                                  //Step-5 and 6
        preparedStatement.execute();

        connection.close();                                                           //Step-7

    }
}
