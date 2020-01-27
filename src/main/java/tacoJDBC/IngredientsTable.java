package tacoJDBC;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.List;
import static tacoJDBC.Connection.getConnection;


public class IngredientsTable {
    Connection con = null;
    Statement statement = null;

    List<Ingredient> ingredients = Arrays.asList(
            new Ingredient("FLTO", "Flour Tortilla", Ingredient.Type.WRAP),
            new Ingredient("COTO", "Corn Tortilla", Ingredient.Type.WRAP),
            new Ingredient("GRBF", "Ground Beef", Ingredient.Type.PROTEIN),
            new Ingredient("CARN", "Carnitas", Ingredient.Type.PROTEIN),
            new Ingredient("TMTO", "Diced Tomatoes", Ingredient.Type.VEGGIES),
            new Ingredient("LETC", "Lettuce", Ingredient.Type.VEGGIES),
            new Ingredient("CHED", "Cheddar", Ingredient.Type.CHEESE),
            new Ingredient("JACK", "Monterrey Jack", Ingredient.Type.CHEESE),
            new Ingredient("SLSA", "Salsa", Ingredient.Type.SAUCE),
            new Ingredient("SRCR", "Sour Cream", Ingredient.Type.SAUCE));

    public void ingredientTable() {
        try (Connection con = getConnection(); Statement statement = con.createStatement()) {
            statement.executeUpdate("DROP TABLE IF EXISTS ingredients ");

            statement.executeUpdate(" CREATE TABLE IF NOT EXISTS ingredients " +
                                        " (id CHAR(255) PRIMARY KEY,  " +
                                        "  name  CHAR(255) , " +
                                        " type CHAR(255) )");



            for (Ingredient ing : ingredients) {
                statement.executeUpdate("INSERT INTO `ingredients`(id,name,type) VALUE ('"
                        +ing.getId()+"','"
                        +ing.getName()+ "','"
                        +ing.getType()+"')");
            }

        } catch (SQLException e) {
        }

    }



}
