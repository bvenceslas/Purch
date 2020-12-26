
package brain.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnect {
    private static Connection con = null;
    static ReadKeys read;
    public static Connection connectDb() throws SQLException, ClassNotFoundException, Exception
    {
        read = new ReadKeys();
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        //return con = DriverManager.getConnection("jdbc:sqlserver://DESKTOP-2SIGCPD\\BRAINSERVER;databaseName=AndreaBD; user = sa; password = brain");        
        return con = DriverManager.getConnection("jdbc:sqlserver://"+read.getServer()+"; databaseName = "+read.getDatabase()+";user = "+read.getUser()+"; password = "+read.getPassword()+"");               
    
    }
    
    public static void disconnectDb() throws SQLException
    {
        if (con != null)
        {
            con.close();            
        }
    }
}
