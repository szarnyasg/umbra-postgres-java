package umbra;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class Main {

    public static void main(String[] args) throws SQLException {
        String url = "jdbc:postgresql://localhost:5432/";
        Properties props = new Properties();
        props.setProperty("user", "postgres");
        props.setProperty("password", "mysecretpassword");
        props.setProperty("ssl",  "false");
        Connection conn = DriverManager.getConnection(url, props);
        Statement statement = conn.createStatement();
        if (statement.execute("SELECT 42 as x;")) {
            System.out.println(statement.getResultSet());
        }
    }

}
