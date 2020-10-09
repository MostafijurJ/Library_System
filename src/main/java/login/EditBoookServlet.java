package login;

import connection.ViewBookDAO;
import model.SingleBookModel;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "EditServlet")
public class EditBoookServlet extends HttpServlet {

    ViewBookDAO viewBookDAO = new ViewBookDAO();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));

        HttpSession ss = request.getSession();
        ss.setAttribute("book-id",id);

        SingleBookModel existingBook = viewBookDAO.SingleBook(id);

        RequestDispatcher dispatcher = request.getRequestDispatcher("update-book.jsp");
        request.setAttribute("update", existingBook);
        dispatcher.forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

      doPost(request, response);
    }
}
