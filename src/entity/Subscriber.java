package entity;

import java.sql.Date;
import java.time.LocalDate;

public class Subscriber {

    private int idSubscriber;
    private String firstname;
    private String lastname;
    private String address;
    private int nbMaxBorrow;
    private int blame;
    private LocalDate notAllowedToBorrowUntil;
    private int idUser;

    public Subscriber() {
    }

    public Subscriber(String firstname, String lastname, String address) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.address = address;
    }

    public Subscriber(String firstName2, String lastName2, String address2, int idUser2) {
    }

    public int getIdSubscriber() {
        return idSubscriber;
    }

    public void setIdSubscriber(int idSubscriber) {
        this.idSubscriber = idSubscriber;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getNbMaxBorrow() {
        return nbMaxBorrow;
    }

    public void setNbMaxBorrow(int nbMaxBorrow) {
        this.nbMaxBorrow = nbMaxBorrow;
    }

    public int getBlame() {
        return blame;
    }

    public void setBlame(int blame) {
        this.blame = blame;
    }

    public LocalDate getNotAllowedToBorrowUntil() {
        return notAllowedToBorrowUntil;
    }

    public void setNotAllowedToBorrowUntil(LocalDate sqlDate) {
        this.notAllowedToBorrowUntil = sqlDate;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    @Override
    public String toString() {
        return "Subscriber [idSubscriber=" + idSubscriber + ", firstname=" + firstname + ", lastname=" + lastname
                + ", address=" + address + ", nbMaxBorrow=" + nbMaxBorrow + ", blame=" + blame
                + ", notAllowedToBorrowUntil=" + notAllowedToBorrowUntil + ", idUser=" + idUser + "]";
    }
}
