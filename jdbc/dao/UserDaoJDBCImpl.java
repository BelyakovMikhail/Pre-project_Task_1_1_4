package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.*;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserDaoJDBCImpl implements UserDao {
    private final Connection connection = Util.getConnection();
    public UserDaoJDBCImpl() {

    }

    public void createUsersTable() {
        try (Statement statement = connection.createStatement()) {
            statement.execute("create table users  (\n" +
                    "  id bigint NOT NULL AUTO_INCREMENT,\n" +
                    "  name varchar(45) NOT NULL,\n" +
                    "  lastName varchar(45) NOT NULL,\n" +
                    "  age tinyint NOT NULL,\n" +
                    "  PRIMARY KEY (id)\n" +
                    ")");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void dropUsersTable() {
        try (Statement statement = connection.createStatement()) {
            statement.execute("drop table users");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void saveUser(String name, String lastName, byte age) {
        try (PreparedStatement prepareStatement = connection.prepareStatement(
                "INSERT INTO users (name, lastName, age) VALUES (?, ?, ?)")) {
            prepareStatement.setString(1, name);
            prepareStatement.setString(2, lastName);
            prepareStatement.setByte(3, age);
            prepareStatement.executeUpdate();
            connection.setAutoCommit(false);
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();

        }
    }

    public void removeUserById(long id) {
        try (Statement statement = connection.createStatement()) {
            statement.executeUpdate("delete from users where id = id ");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public List<User> getAllUsers() {
        List<User> list = new ArrayList<>();
        try (PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM users");
             ResultSet rS = preparedStatement.executeQuery("SELECT * FROM users")) {
            while (rS.next()) {
                User user = new User();
                user.setId(rS.getLong("id"));
                user.setName(rS.getString("name"));
                user.setLastName(rS.getString("lastName"));
                user.setAge(rS.getByte("age"));
                list.add(user);
                connection.commit();
            }
        } catch (SQLException e) {
            e.printStackTrace();

        }
        return list;

    }

    public void cleanUsersTable() {
        try (Statement statement = connection.createStatement()) {
            statement.execute("truncate table users");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
