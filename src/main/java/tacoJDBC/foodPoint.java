package tacoJDBC;

public class foodPoint {

    public static void main(String[] args) {

        new IngredientsTable().ingredientTable();
        new ClientsTable().clientTable();
        new OrdersTable().ordersTable();
        Ingredient ingredient = new FindOne().findOne("CARN");
        System.out.println(ingredient);

    }



}
