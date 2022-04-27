import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
        public static void main(String args[]) {
            try {
                Statement statement = Database.getConnection().createStatement();
                //String sql = "CREATE TABLE continents (id INT PRIMARY KEY, name VARCHAR(300) NOT NULL)";
                //statement.execute(sql);
               /* sql = "DROP TABLE countries";
                statement.execute(sql);*/
                var continents = new ContinentDAO();
                continents.create("Asia");
                //Database.getConnection().commit();
                System.out.println(continents.findById(3));
                //Database.getConnection().commit();
            } catch (SQLException e) {
                System.err.println(e);
                //Database.rollback();
            }
        }

}
