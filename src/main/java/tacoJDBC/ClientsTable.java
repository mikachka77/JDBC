package tacoJDBC;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.List;


import static tacoJDBC.Connection.getConnection;

public class ClientsTable {

            List<Client> cList = Arrays.asList(
            new Client("Francesco Totti", 37, Client.Gender.MAN, "Chelsea"),
            new Client("Frank Lampard", 40, Client.Gender.MAN, "Manchester United"),
            new Client("Antonio Di Natale", 36, Client.Gender.MAN, "Udinese"),
            new Client("Didier Drogba", 35, Client.Gender.MAN, "Galatasaray"));


        public void clientTable() {


            try (Connection con = getConnection(); Statement statement = con.createStatement()) {
                statement.executeUpdate("DROP TABLE IF EXISTS clientsOfRestourant ");

                statement.executeUpdate("CREATE TABLE IF NOT EXISTS clientsOfRestourant " + " (" +
                        " id INTEGER(255) NOT NULL AUTO_INCREMENT ,  " +
                        "  name  VARCHAR(255), " + "  age INT(111)," +
                        "  gender  VARCHAR(5), " + "  footballClub VARCHAR(255)," +
                        "  PRIMARY KEY (id)" +
                        " )");


                for (Client client : cList) {


                 statement.executeUpdate("   INSERT INTO `clientsOfRestourant`(name, age, gender, footballClub) VALUE ('    "

                         + client.getName()+ "','"
                         + client.getAge()+ "','"
                         + client.getGender()+ "','"
                         + client.getFootballclub()+" ') ");

                }

            } catch (SQLException e) {
                System.out.println(e);
            }


        }
    }


