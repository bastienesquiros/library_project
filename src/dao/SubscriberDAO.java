package dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import entity.Subscriber;
import main.Connect;

public class SubscriberDAO implements DAO<Subscriber> {

    @Override
    public List<Subscriber> findAll() {
        try {
            PreparedStatement prepare = Connect.getConnection()
                    .prepareStatement("SELECT * FROM subscriber");
            ResultSet result = prepare.executeQuery();
            List<Subscriber> subscribers = new ArrayList<>();
            while (result.next()) {
                Subscriber subscriber = new Subscriber();
                subscriber.setIdSubscriber(result.getInt("id_subscriber"));
                subscriber.setFirstname(result.getString("firstname"));
                subscriber.setLastname(result.getString("lastname"));
                subscriber.setAddress(result.getString("address"));
                subscriber.setNbMaxBorrow(result.getInt("nb_max_borrow"));
                subscriber.setBlame(result.getInt("nb_blames"));
                subscriber.setIdUser(result.getInt("id_user"));
                subscribers.add(subscriber);
                Date sqlDate = result.getDate("not_allowed_to_borrow_until");
                LocalDate localDate = sqlDate.toLocalDate();
                subscriber.setNotAllowedToBorrowUntil(localDate);
            }
            return subscribers;
        } catch (SQLException exception) {
            System.out.println("Error retrieving subscribers: " + exception.getMessage());
        }
        return null;
    }

    @Override
    public Subscriber find(int id) {
        try {
            PreparedStatement prepare = Connect.getConnection()
                    .prepareStatement("SELECT * FROM subscriber WHERE id_subscriber = ?");
            prepare.setInt(1, id);
            ResultSet result = prepare.executeQuery();
            Subscriber subscriber = new Subscriber();
            if (result.next()) {
                subscriber.setIdSubscriber(result.getInt("id_subscriber"));
                subscriber.setFirstname(result.getString("firstname"));
                subscriber.setLastname(result.getString("lastname"));
                subscriber.setAddress(result.getString("address"));
                subscriber.setNbMaxBorrow(result.getInt("nb_max_borrow"));
                subscriber.setBlame(result.getInt("nb_blames"));
                subscriber.setIdUser(result.getInt("id_user"));
                Date sqlDate = result.getDate("not_allowed_to_borrow_until");
                LocalDate localDate = sqlDate.toLocalDate();
                subscriber.setNotAllowedToBorrowUntil(localDate);
                return subscriber;
            } else {
                System.out.println("Subscriber does not exist");
            }
        } catch (SQLException exception) {
            System.out.println("Error retrieving subscriber id " + id + " : " + exception.getMessage());
        }
        return null;
    }

    @Override
    public Subscriber create(Subscriber obj) {
        try {
            PreparedStatement prepare = Connect.getConnection()
                    .prepareStatement(
                            "INSERT INTO subscriber (firstname, lastname, address, nb_max_borrow, nb_blames, not_allowed_to_borrow_until, id_user) VALUES (?, ?, ?, ?, ?, ?, ?)");
            prepare.setString(1, obj.getFirstname());
            prepare.setString(2, obj.getLastname());
            prepare.setString(3, obj.getAddress());
            prepare.setInt(4, obj.getNbMaxBorrow());
            prepare.setInt(5, obj.getBlame());
            if (obj.getNotAllowedToBorrowUntil() == null) {
                prepare.setDate(6, null);
            } else {
                LocalDate localDate = obj.getNotAllowedToBorrowUntil();
                Date sqlDate = Date.valueOf(localDate);
                prepare.setDate(6, sqlDate);
            }
            prepare.setInt(7, obj.getIdUser());
            prepare.executeUpdate();
            return obj;
        } catch (SQLException exception) {
            System.out.println("Error creating user : " + exception.getMessage());
        }
        return null;
    }

    @Override
    public String delete(int id) {
        try {
            PreparedStatement prepare = Connect.getConnection()
                    .prepareStatement("DELETE FROM subscriber WHERE id_subscriber = ?");
            prepare.setInt(1, id);
            prepare.executeUpdate();
            return "Subscriber deleted";
        } catch (SQLException exception) {
            System.out.println("Error deleting user : " + exception.getMessage());
        }
        return "Subscriber not deleted";
    }

    @Override
    public String update(Subscriber obj) {
        try {
            PreparedStatement prepare = Connect.getConnection()
                    .prepareStatement("UPDATE subscriber SET firstname = ?, "
                            + "lastname = ?, address = ?, nb_max_borrow = ?, "
                            + "nb_blames = ?, not_allowed_to_borrow_until = ?, "
                            + "id_user = ? WHERE id_subscriber = ?");
            prepare.setString(1, obj.getFirstname());
            prepare.setString(2, obj.getLastname());
            prepare.setString(3, obj.getAddress());
            prepare.setInt(4, obj.getNbMaxBorrow());
            prepare.setInt(5, obj.getBlame());
            LocalDate localDate = obj.getNotAllowedToBorrowUntil();
            Date sqlDate = Date.valueOf(localDate);
            prepare.setDate(6, sqlDate);
            prepare.setInt(7, obj.getIdUser());
            prepare.executeUpdate();
            return "Subscriber updated";
        } catch (SQLException exception) {
            System.out.println("Error updating user : " + exception.getMessage());
        }
        return null;
    }

    public Subscriber findByName(String firstname, String lastname) {
        try {
            PreparedStatement prepare = Connect.getConnection()
                    .prepareStatement("SELECT * FROM subscriber WHERE lower(firstname) = ? AND lower(lastname) = ? ");
            prepare.setString(1, firstname);
            prepare.setString(2, lastname);
            ResultSet result = prepare.executeQuery();
            Subscriber subscriber = new Subscriber();
            if (result.next()) {
                subscriber.setIdSubscriber(result.getInt("id_subscriber"));
                subscriber.setFirstname(result.getString("firstname"));
                subscriber.setLastname(result.getString("lastname"));
                subscriber.setAddress(result.getString("address"));
                subscriber.setNbMaxBorrow(result.getInt("nb_max_borrow"));
                subscriber.setBlame(result.getInt("nb_blames"));
                subscriber.setIdUser(result.getInt("id_user"));
                Date sqlDate = result.getDate("not_allowed_to_borrow_until");
                LocalDate localDate = sqlDate.toLocalDate();
                subscriber.setNotAllowedToBorrowUntil(localDate);
                return subscriber;
            } else {
                System.out.println("Subscriber does not exist");
            }
        } catch (SQLException exception) {
            System.out.println("Error retrieving subscriber name " + firstname + " " + lastname);
            System.out.println(exception.getMessage());
        }
        return null;
    }

    public static Subscriber displaySubscriberAndUserData(String login) {
        try {
            PreparedStatement prepare = Connect.getConnection()
                    .prepareStatement(
                            "SELECT * FROM subscriber INNER JOIN user ON subscriber.id_user = user.id_user WHERE user.login = ? ");
            prepare.setString(1, login);
            ResultSet result = prepare.executeQuery();
            Subscriber subscriber = new Subscriber();
            if (result.next()) {
                subscriber.setIdSubscriber(result.getInt("id_subscriber"));
                subscriber.setFirstname(result.getString("firstname"));
                subscriber.setLastname(result.getString("lastname"));
                subscriber.setAddress(result.getString("address"));
                subscriber.setNbMaxBorrow(result.getInt("nb_max_borrow"));
                subscriber.setBlame(result.getInt("nb_blames"));
                subscriber.setIdUser(result.getInt("id_user"));
                if (result.getDate("not_allowed_to_borrow_until") != null) {
                    Date sqlDate = result.getDate("not_allowed_to_borrow_until");
                    LocalDate localDate = sqlDate.toLocalDate();
                    subscriber.setNotAllowedToBorrowUntil(localDate);
                }
                return subscriber;
            } else {
                System.out.println("Subscriber does not exist");
            }
        } catch (SQLException exception) {
            System.out.println("Error retrieving subscriber name ");
            System.out.println(exception.getMessage());
        }
        return null;
    }

    public static String deleteSubscriberByUserLogin(String login) {
        try {
            PreparedStatement prepare = Connect.getConnection()
                    .prepareStatement(
                            "DELETE FROM subscriber WHERE id_user = (SELECT id_user FROM user WHERE login = ?)");
            prepare.setString(1, login);
            prepare.executeUpdate();
            return "Subscriber deleted";
        } catch (SQLException exception) {
            System.out.println("Error deleting user : " + exception.getMessage());
        }
        return "Subscriber not deleted";

    }
}