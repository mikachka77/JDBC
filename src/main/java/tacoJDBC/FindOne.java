package tacoJDBC;

import java.sql.*;
import java.sql.Connection;

import static tacoJDBC.Connection.getConnection;

public class FindOne {

    Ingredient ingredient = null;
    ResultSet resultSet = null;
    PreparedStatement statement = null;

    public Ingredient findOne(String id) {

        try {
            Connection con = getConnection();
            //statement = con.prepareStatement("SELECT id, name, type FROM ingredients");
            statement = con.prepareStatement( "SELECT * FROM ingredients WHERE id = " + id);

            statement.setString(1, id);
            resultSet = statement.executeQuery();

            if (resultSet.next()) {
                ingredient = new Ingredient(resultSet.getString("id"),
                        resultSet.getString("name"),
                        Ingredient.Type.valueOf(resultSet.getString("type")));
            }


        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            return ingredient;
        }


    }
}