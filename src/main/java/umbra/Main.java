package umbra;

import java.sql.*;
import java.util.Properties;

public class Main {

    public static void main(String[] args) throws SQLException {
        String url = "jdbc:postgresql://localhost:5432/";
        Properties props = new Properties();
        props.setProperty("user", "postgres");
        props.setProperty("password", "mysecretpassword");
        props.setProperty("ssl",  "false");
        props.setProperty("preferQueryMode", "simple");
        props.setProperty("assumeMinServerVersion", "9.0");
        Connection conn = DriverManager.getConnection(url, props);
        Statement statement = conn.createStatement();
        if (statement.execute("SELECT 42 as x;")) {
            ResultSet resultSet = statement.getResultSet();
            while (resultSet.next()) {
                int res = resultSet.getInt(1);
                System.out.println(res);
            }
        }
    }

}
