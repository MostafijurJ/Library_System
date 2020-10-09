package login;

import connection.ViewBookDAO;
import model.SingleBookModel;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "DeleteBookServlet")
public class DeleteBookServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ViewBookDAO viewBookDAO = new ViewBookDAO();

        int id = Integer.parseInt(request.getParameter("id"));
        try {
            boolean f =  viewBookDAO.deleteUser(id);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        response.sendRedirect("delete-message.jsp");

    }
}
