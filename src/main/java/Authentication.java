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
        String password = request.getParameter("password");

        String pageToLoad = "index.jsp";

        String valid = "/resources/pages/index.jsp";
        String notValid = "index.jsp";

        request.setAttribute("username", username);
        try {
            DBConnector dbConnector = new DBConnector();

            request.setAttribute("isConnected", true);

            for (Users Users : dbConnector.getAll()) {
                if(Users.getUsername().equals(username) && Users.getPassword().equals(password)){
                    request.setAttribute("isLoggedIn", true);
                    System.out.println("Success");
                    pageToLoad = valid;
                }else {
                    System.out.println("Failed");
                    request.setAttribute("isLoggedIn", "Not valid login or password.");
                    pageToLoad = notValid;
                }
            }

            request.getRequestDispatcher(pageToLoad).forward(request,response);

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("isLoggedIn", "You'r not authorized!");
        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }
}