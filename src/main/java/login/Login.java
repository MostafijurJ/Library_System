package login;

import connection.LoginDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "Login")
public class Login extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String UserName = request.getParameter("username");
        String Password = request.getParameter("password");

        LoginDao dao = new LoginDao();

        if (dao.isChecked(UserName, Password)) {
            // Handling the logged in user in other pages
            HttpSession session = request.getSession();
            session.setAttribute("username", UserName);
            response.sendRedirect("welcome.jsp");

        } else {
            PrintWriter pt = response.getWriter();
            pt.println("Invalid username and password!. ");
            response.sendRedirect("login.jsp");
        }
    }
}
