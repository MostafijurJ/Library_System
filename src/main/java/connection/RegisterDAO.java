package connection;

import model.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RegisterDAO {

    public String UserName = "root";
    public String Password = "Kajol";
    public  String Url = "jdbc:mysql://localhost:3306/test";
    public  String Driver = "com.mysql.jdbc.Driver";

    public void LoadDriver(String Driver){
        try {
            Class.forName(Driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnect(){
        Connection con = null;
        try {
            con =  DriverManager.getConnection(Url,UserName,Password);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return con;
    }

    public String InserData(User user){

        LoadDriver(Driver);
        Connection connection = getConnect();
        String result = "Data goes to DB";
        String query = "Insert into user (username, email, password) values(?,?,?)";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, user.getUserName());
            ps.setString(2, user.getEmail());
            ps.setString(3, user.getPassword());
            ps.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
            result = "Error!!";
        }

        return result;
    }
}
