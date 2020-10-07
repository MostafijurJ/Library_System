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
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;

@WebServlet(name = "View_Book")
public class View_Book extends HttpServlet {

    public String Driver = "com.mysql.jdbc.Driver";

    public void LoadDriver(String Driver) {
        try {
            Class.forName(Driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RegisterDAO registerDAO = new RegisterDAO();
        LoadDriver(Driver);

        HttpSession session = request.getSession();
        String username = session.getAttribute("username").toString();

        PrintWriter out = response.getWriter();

        Connection con = registerDAO.getConnect();

        String qury = "Select * from book where user_name = '" + username + "'";
        try {
            PreparedStatement ps = con.prepareStatement(qury);
            ps.executeUpdate();
            ResultSet rs = (ResultSet) ps;
            out.println("<table>");
            while (rs.next()) {
                out.println("<tr><td>'" + rs.getString(1) + "'</td><td>'\"+rs.getString(2)+\"' </td><td>'\"+rs.getString(3)+\"' </td><td>'\"+rs.getString(4)+\"' </td></tr>");
            }
            out.println("</table>");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }


}
