package connection;

import model.BookModel;
import model.SingleBookModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BookDAO {


    RegisterDAO connect = new RegisterDAO();

    public  String sql = "Insert into book(book_name,author_name,version,price,user_id) values (?,?,?,?,?)";
    public  String update =  "update book set book_name=?,author_name=?, version=?, price=? where book_id =?;";
    String result = "Book added to db";
    String Driver = "com.mysql.jdbc.Driver";

    public String sentBook(BookModel book){


        try {
            Class.forName(Driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        Connection connection = connect.getConnect();
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1,book.getBookName());
            ps.setString(2,book.getAuthorName());
            ps.setString(3, book.getVersion());
            ps.setString(4,book.getPrice());
            ps.setInt(5,book.getUserId());
            ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            result = "Book is not inserted!!";
        }

        return  result;
    }

    String rs = "Book is Updated";
    public String UpdateBook(SingleBookModel book){

        try {
            Class.forName(Driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        Connection connection = connect.getConnect();
        try (PreparedStatement ps = connection.prepareStatement(update)) {
            ps.setString(1,book.getName());
            ps.setString(2,book.getAuthor());
            ps.setString(3, book.getVersion());
            ps.setString(4,book.getPrice());
            ps.setInt(5, book.getId());

            ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            rs= "Book is not update!!";
        }

        return  rs;
    }


}
