import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBConnector {
    //String url = "jdbc:mysql://localhost:3306/user";
    private final String login = "root";
    private final String password = "root";

    private Connection connection;

    public DBConnector() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        this.connection = DriverManager.getConnection(Config.url, login, password);
    }
    public List<Users> getAll() throws SQLException {
        List<Users> users = new ArrayList<>();

        String sqlSelect = "SELECT * FROM accounts WHERE status = ?";
        PreparedStatement preparedStatement = this.connection.prepareStatement(sqlSelect);
        preparedStatement.setString(1, "granted");
        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()){
            users.add(new Users(resultSet.getInt(1), resultSet.getString(2),
                    resultSet.getString(3), resultSet.getString(4),
                    resultSet.getInt(5)));
        }

        return users;
    }
}
//100 doors challenge