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
            for (Users Users : dbConnector.getAll()) {

                System.out.println(Users.getUsername());
                System.out.println(Users.getPassword());


                if(Users.getUsername().equals(username) && Users.getPassword().equals(password)){
                    request.setAttribute("isLoggedIn", true);
                    request.getRequestDispatcher("/Authentication/index.jsp").forward(request,response);
                }else {
                    request.setAttribute("isLoggedIn", "Not valid login or password.");
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
        request.setAttribute("isLoggedIn", "You'r not authorized!");
        request.getRequestDispatcher("/FrontEnd/index.jsp").forward(request, response);
    }
}