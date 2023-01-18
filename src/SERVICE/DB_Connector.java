package SERVICE;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DB_Connector {
    
     public static Connection conn;
     private static final String driver = "com.mysql.cj.jdbc.Driver";
     private static final String user = "admin";
     private static final String password = "chachis2014";
     private static final String url = "jdbc:mysql://localhost:3306/interfaces";
     
    public DB_Connector() {
        conn = null;
        try{
            Class.forName(driver);
            conn = DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException | SQLException e){
               System.out.println("Error de conexion" + e);
        }
    }
    
    public Connection getConnection(){
        return conn;
    }
    
    public void dc(){
        conn = null;
    }
}