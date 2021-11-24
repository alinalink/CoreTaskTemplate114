package jm.task.core.jdbc;

import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;

import java.sql.SQLException;

public class Main {
    private static final UserService userService = new UserServiceImpl();

    public static void main(String[] args) throws SQLException {

        userService.createUsersTable();
        userService.saveUser("Иван", "Иванов", (byte) 20);
        userService.saveUser("Вася", "Сидоров", (byte) 21);
        userService.saveUser("Саша", "Смирнов", (byte) 22);
        userService.saveUser("Петя", "Петров", (byte) 23);
        userService.getAllUsers();
        userService.cleanUsersTable();
        userService.dropUsersTable();

    }
}
