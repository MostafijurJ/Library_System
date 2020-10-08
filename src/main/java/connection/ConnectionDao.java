package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDao {

    public String UserName = "root";
    public String Password = "Kajol";
    public  String Url = "jdbc:mysql://localhost:3306/test";
    public  String Driver = "com.mysql.jdbc.Driver";

    public Connection getConnect(){
        Connection con = null;
        try {
            Class.forName(Driver);
            con =  DriverManager.getConnection(Url,UserName,Password);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return con;
    }
}
