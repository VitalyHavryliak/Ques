import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "Authentication")
public class Authentication extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("pass");
        request.setAttribute("username", username);
        try {
            DBConnector dbConnector = new DBConnector();
            for (Profiles profiles : dbConnector.getAll()) {
                if(profiles.login.equals(username) && profiles.password.equals(password)){
                    request.setAttribute("isLoggedIn", true);
                    request.getRequestDispatcher("/FrontEnd/Authentication.jsp").forward(request,response);
                }else {
                    request.setAttribute("isLoggedIn", "You're not authoaerkjbwr");
                    request.getRequestDispatcher("/FrontEnd/index.jsp").forward(request, response);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/FrontEnd/Authentication.jsp").forward(request, response);
    }
}