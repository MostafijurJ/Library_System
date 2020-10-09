package connection;

import model.SingleBookModel;
import model.ViewBookModel;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ViewBookDAO {

    public String UserName = "root";
    public String Password = "Kajol";
    public String Url = "jdbc:mysql://localhost:3306/test";
    public String Driver = "com.mysql.jdbc.Driver";

    private static final String SELECT_Book_BY_ID = "select book_id, book_name, author_name, version, price from book where user_id =?";
    private static final String SELECT_Each_Book = "select book_name, author_name, version, price from book where book_id =?";
    private static final String DELETE_USERS_SQL = "delete from book where book_id = ?;";

    public Connection getConnect() {
        Connection con = null;
        try {
            Class.forName(Driver);
            con = DriverManager.getConnection(Url, UserName, Password);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return con;
    }


    public List<ViewBookModel> selectBook(int user_id) {

        List<ViewBookModel> newbook = new ArrayList<>();

        try (Connection connection = getConnect();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_Book_BY_ID);) {

            preparedStatement.setInt(1, user_id);

            System.out.println(preparedStatement);

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                String name = rs.getString("book_name");
                String autor = rs.getString("author_name");
                String version = rs.getString("version");
                String price = rs.getString("price");
                int book_id = rs.getInt(1);

                newbook.add(new ViewBookModel(book_id, name, autor, version, price, user_id));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return newbook;
    }

    public SingleBookModel SingleBook(int book_id) {
        SingleBookModel bookmodel = null;

        try (Connection connection = getConnect();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_Each_Book);) {

            preparedStatement.setInt(1, book_id);

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                String name = rs.getString("book_name");
                String autor = rs.getString("author_name");
                String version = rs.getString("version");
                String price = rs.getString("price");

                bookmodel = new SingleBookModel(book_id, name, autor, version, price);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return bookmodel;
    }


    private void updateBook(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String author = request.getParameter("email");
        String ver = request.getParameter("country");
        String price = request.getParameter("country");

        SingleBookModel book = new SingleBookModel(id, name, author, ver, price);

    }

    public boolean deleteUser(int id) throws SQLException {
        boolean rowDeleted;
        try (Connection connection = getConnect();
             PreparedStatement statement = connection.prepareStatement(DELETE_USERS_SQL);) {
            statement.setInt(1, id);
            rowDeleted = statement.executeUpdate() > 0;
        }
        return rowDeleted;
    }


}
