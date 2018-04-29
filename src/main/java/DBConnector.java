import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBConnector {

    private Connection connection;

    public DBConnector() throws SQLException, ClassNotFoundException {
        //Class.forName("com.mysql.jdbc.Driver");
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        this.connection = DriverManager.getConnection(Config.url, Config.login, Config.password);
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

    public boolean hasConnected() throws SQLException {
        return connection.isValid(100);
    }
}
//100 doors challenge