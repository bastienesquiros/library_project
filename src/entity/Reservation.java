package entity;

import java.time.LocalDate;

public class Reservation {
    private int idReservation;
    private boolean isValid;
    private LocalDate dateReservation;

    public Reservation() {
    }

    public Reservation(LocalDate dateReservation) {
        this.dateReservation = dateReservation;
    }

    public int getIdReservation() {
        return idReservation;
    }

    public void setIdReservation(int idReservation) {
        this.idReservation = idReservation;
    }

    public boolean isValid() {
        return isValid;
    }

    public void setValid(boolean isValid) {
        this.isValid = isValid;
    }

    public LocalDate getDateReservation() {
        return dateReservation;
    }

    public void setDateReservation(LocalDate dateReservation) {
        this.dateReservation = dateReservation;
    }

    @Override
    public String toString() {
        return "Reservation [idReservation=" + idReservation + ", isValid=" + isValid + ", dateReservation="
                + dateReservation + "]";
    }

}
