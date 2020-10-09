package login;

import connection.BookDAO;
import model.SingleBookModel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "UpdateBookServlet")
public class UpdateBookServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String BookName = request.getParameter("bookname");
        String authorName = request.getParameter("authorname");
        String version = request.getParameter("version");
        String price = request.getParameter("price");

        HttpSession session = request.getSession();
        Integer bookid = (Integer) session.getAttribute("book-id");

        SingleBookModel bk = new SingleBookModel(bookid, BookName, authorName, version, price);
        BookDAO bookDAO = new BookDAO();

        String result = bookDAO.UpdateBook(bk);
        PrintWriter out = response.getWriter();
        out.println(result);

        response.sendRedirect("update-message.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
