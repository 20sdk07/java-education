

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {


    public static void main(String[] args) throws SQLException {
        Connection connection = null;
        DbHelper Helper = new DbHelper();
        Statement st = null;
        ResultSet resultSet;
        String sql = "select * from sakila.user ";

        try {
            connection = Helper.getConnection();
            resultSet = st.executeQuery(sql);

            while (resultSet.next()) {
                System.out.println(resultSet.getString(1));
            }


        } catch (SQLException exception) {
            Helper.showError(exception);
        } finally {
            connection.close();
        }


    }
}