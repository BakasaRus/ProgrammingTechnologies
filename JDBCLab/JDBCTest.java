package JDBCLab;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCTest {
    public static void main(String[] args) {
        try (Connection conn = DriverManager.getConnection("jdbc:sqlite:db.sqlite")) {
            DatabaseMetaData dbmd = conn.getMetaData();
            System.out.println(dbmd.getDriverName());
            System.out.println(dbmd.getUserName());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
