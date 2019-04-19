package JDBCLab;

import JDBCLab.javatunes.util.ItemDAO;
import JDBCLab.javatunes.util.MusicItem;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ItemDAOMain {
    public static void main(String[] args) {
        try (Connection connection = DriverManager.getConnection("jdbc:sqlite:db.sqlite")) {
            MusicItem item;
            ItemDAO dao = new ItemDAO(connection);

            item = dao.searchById(1L);
            System.out.println(item);

            item = dao.searchById(100L);
            System.out.println(item);

            System.out.println(dao.searchByKeyword("of"));
            System.out.println(dao.searchByKeyword("Gay"));

            MusicItem newItem = new MusicItem(
                0L,
                "Hello",
                "Adele",
                "2014-05-07",
                BigDecimal.valueOf(77.88),
                BigDecimal.valueOf(78.99)
            );

            dao.create(newItem);
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
