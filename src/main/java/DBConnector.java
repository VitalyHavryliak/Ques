import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBConnector {
    String url = "jdbc:mysql://localhost:3306/user?useUnicode=true&useLegacyDatetimeCode=false&serverTimezone=Greece";
    private final String login = "root";
    private final String password = "root";

    private Connection connection;

    public DBConnector() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        this.connection = DriverManager.getConnection(url, login, password);
    }
    public List<Profiles> getAll() throws SQLException {
        String sqlSelect = "SELECT* FROM profiles";
        PreparedStatement preparedStatement = this.connection.prepareStatement(sqlSelect);
        ResultSet resultSet = preparedStatement.executeQuery();
        List<Profiles> profiles = new ArrayList<Profiles>();
        while (resultSet.next()) {
            profiles.add(new Profiles(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3)));
        }
        return profiles;
    }
}
