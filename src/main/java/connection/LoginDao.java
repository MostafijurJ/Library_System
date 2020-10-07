package connection;

import java.sql.*;

public class LoginDao {
    public String UserName = "root";
    public String Password = "Kajol";
    public  String Url = "jdbc:mysql://localhost:3306/test";
    public  String qury = "select * from user where username=? and password=?";

    public boolean isChecked(String Uname, String Upass){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            PreparedStatement statement;
            try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "Kajol")) {
                statement = con.prepareStatement(qury);
                statement.setString(1,Uname);
                statement.setString(2,Upass);
                ResultSet resultSet = statement.executeQuery();

                if(resultSet.next()){
                    return true;
                }
            }

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        return false;
    }
}
