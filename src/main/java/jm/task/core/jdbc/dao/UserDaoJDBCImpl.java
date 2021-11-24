package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoJDBCImpl implements UserDao {

    //static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";

    public UserDaoJDBCImpl() {

    }

    private static final Connection connect = Util.getConnection();

    //создание таблицы
    public void createUsersTable() {
        try (Statement statement = connect.createStatement()) {
            String SQL = "CREATE TABLE users " +
                    "(id INTEGER not NULL, " +
                    " name VARCHAR(45), " +
                    " lastName VARCHAR (45), " +
                    " age INTEGER not NULL, " +
                    " PRIMARY KEY (id))";
            statement.executeUpdate(SQL);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //удаление таблицы
    public void dropUsersTable() {
        String SQL = "DROP TABLE IF EXISTS users";
        try (PreparedStatement preparedStatement = connect.prepareStatement(SQL)) {
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    //добавление юзеров
    public void saveUser(String name, String lastName, byte age) {
        try (PreparedStatement statement = connect.prepareStatement("INSERT INTO users " + " (name, lastName, age) "
                + " VALUES (?, ?, ?)")) {
            statement.setString(1, name);
            statement.setString(2, lastName);
            statement.setByte(3, age);
            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    //удаление юзеров
    public void removeUserById(long id) {
        try (PreparedStatement statement = connect.prepareStatement("DELETE users WHERE id = ?")) {
            statement.setLong(1, id);
            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    //получение всех юзеров
    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        try {
            assert false;
            try (ResultSet result = connect.createStatement().executeQuery("SELECT * FROM users")) {
                while (result.next()) {
                    User user = new User();
                    user.setId(result.getLong("id"));
                    user.setName(result.getString("name"));
                    user.setLastName(result.getString("lastName"));
                    user.setAge(result.getByte("age"));
                    users.add(user);
                }

            }
        } catch (SQLException e) {
            e.printStackTrace();

        }
        return users;
    }

    //очистка таблицы
    public void cleanUsersTable() {
        try {
            try (Statement statement = connect.createStatement()) {
                statement.executeUpdate("TRUNCATE TABLE users");
            }
        } catch (SQLException e) {
            e.printStackTrace();

        }

    }

}
