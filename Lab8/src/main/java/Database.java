import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Database {
    private static final String URL =
            "jdbc:postgresql://localhost:5432/postgres";
    private static final String USER = "postgres";
    private static final String PASSWORD = "pass";
    private static Connection connection = null;

    private Database() {}
    public static Connection getConnection() {
        if(connection == null) {
            createConnection();
        }
        return connection;
    }
    private static void createConnection() {
        try {
            connection = DriverManager.getConnection(URL,USER,PASSWORD);
            //connection.setAutoCommit(false);
            //generateTables();
        } catch (SQLException e) {
            System.err.println(e);
        }
    }
    public static void closeConnection() {
        closeConnection();
    }

    public static void rollback() {
    }

    private static void generateTables() throws SQLException {
        Statement statement = Database.connection.createStatement();
    /*    String sql = "DROP TABLE continents";
        statement.execute(sql);
        String sql = "DROP TABLE countries";
        statement.execute(sql);*/
        String sql = "CREATE TABLE continents (id INT PRIMARY KEY, name VARCHAR(300) NOT NULL)";
        statement.execute(sql);
        sql = "create table countries(id int primary key, name VARCHAR(30), code varchar(20), continent varchar(300))";
        statement.execute(sql);
    }
}
