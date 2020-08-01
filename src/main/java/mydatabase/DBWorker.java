package mydatabase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBWorker {
    private static final String URL = "jdbc:mysql://localhost:3306/library?useUnicode=true&useSSL=true&useJDBCCompliantTimezoneShift=true" +
            "&useLegacyDatetimeCode=false&serverTimezone=UTC&allowPublicKeyRetrieval=true";
    private static final String USER = "root";
    private static final String PASS = "root";

    private Connection connection;

public DBWorker(){
    try {
        connection = DriverManager.getConnection(URL, USER, PASS);
        if (!connection.isClosed()) {
            System.out.println("Соединение с БД установлено!");
        }
        connection.close();
        if(connection.isClosed()) {
            System.out.println("Соединение с БД закрыто!");
        }
    } catch (SQLException e) {
        System.out.println("Не удалось установить соединение с БД.");
    }
}

    public Connection getConnection() {
        return connection;
    }
}
