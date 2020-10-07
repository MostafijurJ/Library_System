package connection;

import login.bookModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BookDAO {

    public  String Driver = "com.mysql.jdbc.Driver";

    public void LoadDriver(String Driver){
        try {
            Class.forName(Driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    RegisterDAO connect = new RegisterDAO();

    public  String sql = "Insert into book values(?,?,?,?,?)";
    String result = "Book added to db";

    public String sentBook(bookModel book){

        LoadDriver(Driver);
        Connection connection = connect.getConnect();
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1,book.getBookName());
            ps.setString(2,book.getAuthorName());
            ps.setString(3, book.getVersion());
            ps.setString(4,book.getPrice());
            ps.setString(5,book.getUsername());

            ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            result = "Book is not inserted!!";
        }

        return  result;
    }

}
