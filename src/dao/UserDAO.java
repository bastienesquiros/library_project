package dao;

import java.sql.PreparedStatement;
import java.sql.Statement;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.User;
import main.Connect;

public class UserDAO implements DAO<User> {

    @Override
    public List<User> findAll() {
        try {
            PreparedStatement prepare = Connect.getConnection()
                    .prepareStatement("SELECT * FROM user");
            ResultSet result = prepare.executeQuery();
            List<User> users = new ArrayList<>();
            while (result.next()) {
                User user = new User();
                user.setIdUser(result.getInt("id_user"));
                user.setLogin(result.getString("login"));
                user.setPassword(result.getString("password"));
                user.setLibrarian(result.getBoolean("is_librarian"));
                users.add(user);
            }
            return users;
        } catch (SQLException exception) {
            System.out.println("Error while getting users : " + exception.getMessage());
        }
        return null;
    }

    @Override
    public User find(int id) {
        try {
            PreparedStatement prepare = Connect.getConnection()
                    .prepareStatement("SELECT * FROM user WHERE id_user = ?");
            prepare.setInt(1, id);
            ResultSet result = prepare.executeQuery();
            User user = new User();
            if (result.next()) {
                user.setIdUser(result.getInt("id_user"));
                user.setLogin(result.getString("login"));
                user.setPassword(result.getString("password"));
                user.setLibrarian(result.getBoolean("is_librarian"));
                return user;
            } else {
                System.out.println("User does not exist");
            }
        } catch (SQLException exception) {
            System.out.println("Error while finding user : " + exception.getMessage());
        }
        return null;
    }

    @Override
    public User create(User obj) {
        try {
            PreparedStatement prepare = Connect.getConnection().prepareStatement(
                    "INSERT INTO user (login, password, is_librarian) VALUES (?, ?, ?)",
                    Statement.RETURN_GENERATED_KEYS);
            prepare.setString(1, obj.getLogin());
            prepare.setString(2, obj.getPassword());
            prepare.setBoolean(3, obj.isLibrarian());
            prepare.executeUpdate();

            ResultSet generatedKeys = prepare.getGeneratedKeys();
            if (generatedKeys.next()) {
                int generatedId = generatedKeys.getInt(1);
                obj.setIdUser(generatedId);
                return obj;
            }
        } catch (SQLException exception) {
            System.out.println("Error while creating user: " + exception.getMessage());
        }
        return null;
    }

    @Override
    public String delete(int id) {
        try {
            PreparedStatement prepare = Connect.getConnection()
                    .prepareStatement("DELETE FROM user WHERE id_user = ?");
            prepare.setInt(1, id);
            prepare.executeUpdate();
            return "User deleted";
        } catch (SQLException exception) {
            System.out.println("Error while deleting user : " + exception.getMessage());
        }
        return "User not deleted";
    }

    public static String delete(String login) {
        try {
            PreparedStatement prepare = Connect.getConnection()
                    .prepareStatement("DELETE FROM user WHERE login = ?");
            prepare.setString(1, login);
            prepare.executeUpdate();
            return "User deleted";
        } catch (SQLException exception) {
            System.out.println("Error while deleting user : " + exception.getMessage());
        }
        return "User not deleted";
    }

    @Override
    public String update(User user) {
        try {
            PreparedStatement prepare = Connect.getConnection()
                    .prepareStatement("UPDATE user SET login = ?, password = ?, is_librarian = ? WHERE id_user = ?");
            prepare.setString(1, user.getLogin());
            prepare.setString(2, user.getPassword());
            prepare.setBoolean(3, user.isLibrarian());
            prepare.setInt(4, user.getIdUser());
            prepare.executeUpdate();
            return "User updated";
        } catch (SQLException exception) {
            System.out.println("Error while updating user : " + exception.getMessage());
        }
        return null;
    }

    public static boolean signIn(String login, String password) {
        try {
            PreparedStatement prepare = Connect.getConnection()
                    .prepareStatement("SELECT * FROM user WHERE login = ? AND password = ?");
            prepare.setString(1, login);
            prepare.setString(2, password);
            ResultSet result = prepare.executeQuery();
            return result.next();
        } catch (SQLException exception) {
            System.out.println("Error while signing in : " + exception.getMessage());
        }
        return false;
    }

    public static boolean isLibrarian(String login) {
        try {
            PreparedStatement prepare = Connect.getConnection()
                    .prepareStatement("SELECT * FROM user WHERE login = ?");
            prepare.setString(1, login);
            ResultSet result = prepare.executeQuery();
            if (result.next()) {
                return result.getBoolean("is_librarian");
            }
        } catch (SQLException exception) {
            System.out.println("Error while checking if user is librarian : " + exception.getMessage());
        }
        return false;
    }

    public static String displayByUsername(String username) {
        try {
            PreparedStatement prepare = Connect.getConnection()
                    .prepareStatement("SELECT * FROM user WHERE login = ?");
            prepare.setString(1, username);
            ResultSet result = prepare.executeQuery();
            User user = new User();
            if (result.next()) {
                user.setIdUser(result.getInt("id_user"));
                user.setLogin(result.getString("login"));
                user.setPassword(result.getString("password"));
                user.setLibrarian(result.getBoolean("is_librarian"));
                return "Username : " + user.getLogin() + " Password : " + user.getPassword();
            } else {
                System.out.println("User does not exist");
            }
        } catch (SQLException exception) {
            System.out.println("Error while finding user : " + exception.getMessage());
        }
        return null;
    }

}
