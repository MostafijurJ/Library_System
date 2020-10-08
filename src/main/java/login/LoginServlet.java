package login;

import connection.ConnectionDao;
import connection.LoginDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet(name = "Login")
public class LoginServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String UserName = request.getParameter("username");
        String Password = request.getParameter("password");

        LoginDao dao = new LoginDao();

        if (dao.isChecked(UserName, Password)) {
            // Handling the logged in user in other pages
            HttpSession session = request.getSession();
            session.setAttribute("username", UserName);


            String qury = "Select id from user where username = '"+ UserName+"'";

            ConnectionDao cd = new ConnectionDao();
            Connection connection = cd.getConnect();
            ResultSet resultSet = null;
            int userID = 0;
            try (PreparedStatement ps = connection.prepareStatement(qury)) {
                resultSet =  ps.executeQuery();
                if(resultSet.next()){
                    userID = resultSet.getInt(1);
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

            HttpSession ss = request.getSession();
            ss.setAttribute("user_id", userID);

            response.sendRedirect("welcome.jsp");

        } else {
            PrintWriter pt = response.getWriter();
            pt.println("Invalid username and password!. ");
            response.sendRedirect("login.jsp");
        }
    }
}
