package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.Subscriber;
import entity.User;
import main.Connect;

public class SubscriberDAO implements DAO<Subscriber, String> {

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
                subscriber.setAdress(result.getString("address"));
                subscriber.setNbMaxBorrow(result.getInt("nb_max_borrow"));
                subscriber.setBlame(result.getInt("nb_blames"));
                subscriber.setNotAllowedToBorrowUntil(result.getDate("not_allowed_to_borrow_until"));
                subscribers.add(subscriber);
            }
            return subscribers;
        } catch (SQLException exception) {
            System.out.println("Error retrieving subscribers:" + exception.getMessage());
        }
        return null;
    }
	
}
