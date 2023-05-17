package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

import com.mysql.cj.x.protobuf.MysqlxPrepare.Prepare;

import entity.Reservation;
import main.Connect;

public class ReservationDAO implements DAO<Reservation> {

    @Override
    public List<Reservation> findAll() {
        try {
            PreparedStatement prepare = Connect.getConnection()
                    .prepareStatement("SELECT * FROM reservation");
            ResultSet result = prepare.executeQuery();
            List<Reservation> reservations = new ArrayList<>();
            while (result.next()) {
                Reservation reservation = new Reservation();
                reservation.setIdReservation(result.getInt("id_reservation"));
                Date sqlDate = result.getDate("date_reservation");
                LocalDate localDate = sqlDate.toLocalDate();
                reservation.setDateReservation(localDate);
                reservation.setValid(result.getBoolean("is_valid"));
                reservations.add(reservation);
            }
            return reservations;
        } catch (Exception exception) {
            System.out.println("Error retrieving reservations: " + exception.getMessage());
        }
        return null;
    }

    @Override
    public Reservation find(int id) {
        try {
            PreparedStatement prepare = Connect.getConnection()
                    .prepareStatement("SELECT * FROM reservation WHERE id_reservation = ?");
            prepare.setInt(1, id);
            ResultSet result = prepare.executeQuery();
            Reservation reservation = new Reservation();
            if (result.next()) {
                reservation.setIdReservation(result.getInt("id_reservation"));
                Date sqlDate = result.getDate("date_reservation");
                LocalDate localDate = sqlDate.toLocalDate();
                reservation.setDateReservation(localDate);
                reservation.setValid(result.getBoolean("is_valid"));
                return reservation;
            } else {
                System.out.println("No reservation found with id " + id);
            }
        } catch (Exception exception) {
            System.out.println("Error retrieving reservation: " + exception.getMessage());
        }
        return null;
    }

    @Override
    public Reservation create(Reservation obj) {
        try {
            PreparedStatement prepare = Connect.getConnection()
                    .prepareStatement("INSERT INTO reservation (date_reservation, is_valid) VALUES (?, ?)");
            LocalDate localDate = obj.getDateReservation();
            prepare.setDate(1, Date.valueOf(localDate));
            prepare.setBoolean(2, obj.isValid());
            prepare.executeUpdate();
            return obj;

        } catch (SQLException exception) {
            System.out.println("Error creating reservation: " + exception.getMessage());
        }
        return null;
    }

    @Override
    public String delete(int id) {
        try {
            PreparedStatement prepare = Connect.getConnection()
                    .prepareStatement("DELETE FROM reservation WHERE id_reservation = ?");
            prepare.setInt(1, id);
            prepare.executeUpdate();
            return "Reservation deleted";
        } catch (SQLException exception) {
            System.out.println("Error deleting reservation: " + exception.getMessage());
        }
        return null;

    }

    @Override
    public String update(Reservation obj) {
        try {
            PreparedStatement prepare = Connect.getConnection()
                    .prepareStatement(
                            "UPDATE reservation SET date_reservation = ?, is_valid = ? WHERE id_reservation = ?");
            LocalDate localDate = obj.getDateReservation();
            prepare.setDate(1, Date.valueOf(localDate));
            prepare.setBoolean(2, obj.isValid());
            prepare.setInt(3, obj.getIdReservation());
            prepare.executeUpdate();
            return "Reservation updated";
        } catch (SQLException exception) {
            System.out.println("Error updating reservation: " + exception.getMessage());
        }
        return null;
    }

}
