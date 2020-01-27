package tacoJDBC;

import java.sql.DriverManager;
import java.sql.SQLException;

public class Connection {
    static java.sql.Connection getConnection() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/data1  ";
        java.util.Properties prop = new java.util.Properties();
        prop.put("user", "root");
        prop.put("password", "mishamalcev");
        return DriverManager.getConnection(url, prop);
    }


}
