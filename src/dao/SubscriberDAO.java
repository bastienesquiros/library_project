package dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.Subscriber;
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
                subscriber.setAddress(result.getString("address"));
                subscriber.setNbMaxBorrow(result.getInt("nb_max_borrow"));
                subscriber.setBlame(result.getInt("nb_blames"));
                subscriber.setNotAllowedToBorrowUntil(result.getDate("not_allowed_to_borrow_until"));
                subscriber.setIdUser(result.getInt("id_user"));
                subscribers.add(subscriber);
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
	                 subscriber.setNotAllowedToBorrowUntil(result.getDate("not_allowed_to_borrow_until"));
	                 subscriber.setIdUser(result.getInt("id_user"));
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
	                    .prepareStatement("INSERT INTO subscriber (firstname, lastname, address, nb_max_borrow, nb_blames, not_allowed_to_borrow_until, id_user) VALUES (?, ?, ?, ?, ?, ?, ?)");
	            prepare.setString(1, obj.getFirstname());
	            prepare.setString(2, obj.getLastname());
	            prepare.setString(3, obj.getAddress());
	            prepare.setInt(4, obj.getNbMaxBorrow());
	            prepare.setInt(5, obj.getBlame());
	            prepare.setDate(6, (Date) obj.getNotAllowedToBorrowUntil());
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
		            prepare.setDouble(6, obj.getNotAllowedToBorrowUntil());
		            prepare.setInt(7, obj.getIdUser());
		            prepare.executeUpdate();
		            return "Subscriber updated";
		        } catch (SQLException exception) {
		            System.out.println("Error updating user : " + exception.getMessage());
		        }
			return null;
		}
}
