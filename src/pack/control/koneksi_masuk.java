package pack.control;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;


public class koneksi_masuk {

    private static Connection konek;

    public static Connection GetConnection() throws
            SQLException {
        if (konek == null) {
            Driver driver = new Driver();
            konek = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/Apotek_db?"
                    + "zeroDateTimeBehavior=convertToNull", "root", "");
        }
        return konek;
    }
}