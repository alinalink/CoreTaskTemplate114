package jm.task.core.jdbc.util;

import com.mysql.fabric.jdbc.FabricMySQLDriver;

import java.sql.*;

public class Util {
    //настройка соеденения с БД
    private static final String URL = "jdbc:mysql://localhost:3306/users?useSSL=false";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "1234098765";
    private static Connection connection;

    public static Connection getConnection() {
        try {
            Driver driver = new FabricMySQLDriver();
            DriverManager.deregisterDriver(driver);
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            if (!connection.isClosed()) {
                System.out.println("Соединение установлено");
            }
            connection.close();
        } catch (SQLException ex) {
            System.err.println("Ошибка соединения");
        }
        return connection;
    }
}
