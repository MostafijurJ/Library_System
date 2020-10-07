package login;

import connection.RegisterDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "Register")
public class Register extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String UserName = request.getParameter("username");
        String UserEmail = request.getParameter("email");
        String UserPass = request.getParameter("password");

        User user = new User(UserName,UserEmail,UserPass);
        RegisterDAO registerDAO = new RegisterDAO();

        String result = registerDAO.InserData(user);

        HttpSession session = request.getSession();
        session.setAttribute("username", UserName);

        response.sendRedirect("welcome.jsp");
        PrintWriter ps = response.getWriter();

        ps.println(result);

    }
}
