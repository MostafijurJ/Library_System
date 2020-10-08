package login;

import connection.ViewBookDAO;
import model.ViewBookModel;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "View_BookServlet")
public class View_BookServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        Integer user_id = (Integer) session.getAttribute("user_id");

        ViewBookDAO viewBookDAO = new ViewBookDAO();

        List<ViewBookModel> booklist = (List<ViewBookModel>) viewBookDAO.selectBook(user_id);

       request.setAttribute("booklist", booklist);
        RequestDispatcher dispatcher = request.getRequestDispatcher("view_book.jsp");
        dispatcher.forward(request, response);

    }


}
