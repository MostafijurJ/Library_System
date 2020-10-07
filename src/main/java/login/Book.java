package login;

import connection.BookDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "Book")
public class Book extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String BookName = request.getParameter("bookname");
        String authorName = request.getParameter("authorname");
        String version = request.getParameter("version");
        String price = request.getParameter("price");

        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");

        bookModel book = new bookModel(BookName, authorName, version, price, username);

        BookDAO bookDAO = new BookDAO();
        String result = bookDAO.sentBook(book);
        PrintWriter out = response.getWriter();
        out.println(result);
    }
}
