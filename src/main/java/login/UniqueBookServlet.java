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
import java.io.PrintWriter;
import java.sql.SQLException;

@WebServlet(name = "unique-book")
public class UniqueBookServlet extends HttpServlet {
    public  int id;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

      doPost(request,response);

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String i =  request.getParameter("id");
        id = Integer.parseInt(i);
        ViewBookDAO viewBookDAO = new ViewBookDAO();

        SingleBookModel singleBookModel = viewBookDAO.SingleBook(id);

        request.setAttribute("book", singleBookModel);
        RequestDispatcher dispatcher = request.getRequestDispatcher("specific-book-details.jsp");
        dispatcher.forward(request, response);
     }


}
