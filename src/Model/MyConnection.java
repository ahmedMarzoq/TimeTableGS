
package Model;

import java.sql.*;

public class MyConnection {

    private static MyConnection myConnection;
    private Connection connect;
    private Statement statement = null;

    private MyConnection(){}
    
    public Statement getStatement() throws SQLException{
        String unicode= "?useUnicode=yes&characterEncoding=UTF-8";
        connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/timetable_gs"+unicode, "root" , "");
        statement = connect.createStatement();
        
        return statement;
    }
    
    public static MyConnection getMyConnection() {
        if (myConnection == null) {
            myConnection = new MyConnection();
        }
        return myConnection;
    }
}
