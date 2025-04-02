import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbHelper {
    private String username ="root";
    private String password ="1234";
    private String dbUrl = "jdbc:mysql://localhost:3306/sakila";

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(dbUrl, username, password);
    }

    public void showError(SQLException exception){
        System.out.println("Exception massage: " + exception.getMessage());
        System.out.println("Error Code: " + exception.getErrorCode());

    }
}
