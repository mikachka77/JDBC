package tacoJDBC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static tacoJDBC.Connection.getConnection;

public class OrdersTable {

    Connection con = null;
    Statement statement = null;

    public void ordersTable() {
        System.out.println("ORDER TABLE");
        try (Connection con = getConnection(); Statement statement = con.createStatement()) {
            statement.executeUpdate("DROP TABLE IF EXISTS ordersTable ");

            statement.executeUpdate(" CREATE TABLE IF NOT EXISTS ordersTable " +

                                        " (id INT(255) NOT NULL AUTO_INCREMENT,  " +
                                        "  PRIMARY KEY (id), " +
                                        "  client_id  INT, " +
                                        "  quantity  INT, " +
                                        "  date CHAR(255) )"
            );


     /*        ResultSet rs = statement.executeQuery(
                           "SELECT name " +
                               "FROM clientsOfRestourant");


           while (rs.next()){
               System.out.println(rs.getString("name"));
           }

     */

        } catch (SQLException e) {
        }

    }


}
