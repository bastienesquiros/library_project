package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.User;
import main.Connect;

public class UserDAO implements DAO<User, String> {

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
            PreparedStatement prepare = Connect.getConnection()
                    .prepareStatement("INSERT INTO user (login, password, is_librarian) VALUES (?, ?, ?)");
            prepare.setString(1, obj.getLogin());
            prepare.setString(2, obj.getPassword());
            prepare.setBoolean(3, obj.isLibrarian());
            prepare.executeUpdate();
            return obj;
        } catch (SQLException exception) {
            System.out.println("Error while creating user : " + exception.getMessage());
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

}
