package jm.task.core.jdbc.util;

import java.sql.*;


public class Util {
    //настройка соеденения с БД
//    private static final String dbUrl = "jdbc:mysql://localhost:3306/users?useSSL=false";
//    private static final String dbUsername = "root";
//    private static final String dbPassword = "1234098765";
//
//    public static Connection getConnection() {
//        Connection connection = null;
//        try {
//            Class.forName("com.mysql.jdbc.Driver");
//            connection = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
//        } catch (ClassNotFoundException e) {
//            System.out.println("Could not load JDBC driver: " + e.getMessage());
//        } catch (SQLException e) {
//            System.out.println("Could not connect to DB: " + e.getMessage());
//        }
//        return connection;

    private static final String URL = "jdbc:mysql://localhost:3306/users?autoReconnect=true&useSSL=false";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "1234098765";
    static Connection connection;
    public static Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
