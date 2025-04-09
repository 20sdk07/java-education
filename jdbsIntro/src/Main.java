import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws SQLException {
        Connection connection = null;
        DbHelper dbHelper = new DbHelper();
        Statement statement = null;
        ResultSet resultSet = null;

      

        try {
            connection = dbHelper.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery("select * from city where countrycode = 'USA' and population > 1000000");
            ArrayList<Cities> cities = new ArrayList<>();
            

            while (resultSet.next()) {
                cities.add(new Cities(
                        resultSet.getString("Name"),
                        resultSet.getString("CountryCode"),
                        resultSet.getInt("Population")
                ));
            }
            System.out.println(cities.size() + " cities found.");

        } catch (SQLException exception) {
            dbHelper.showError(exception);
            System.out.println("Connection failed.");
        }finally {
            connection.close();
            System.out.println("Connection closed.");
        }
    }
}