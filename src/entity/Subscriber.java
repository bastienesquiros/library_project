package entity;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Subscriber {
	
	private int idSubscriber;
	private String firstname;
	private String lastname;
	private String address;
	private int nbMaxBorrow;
	private int blame;
	private LocalDate notAllowedToBorrowUntil;
	private int idUser;
	
//	@ManyToOne
//	@JoinColumn(name = "idUser")
//	private User user;
	
   public Subscriber() {
   }
  
	public Subscriber(String firstname, String lastname, String address, int idUser) {
		this.firstname = firstname;
		this.lastname = lastname;
		this.address = address;
		this.nbMaxBorrow = 5;
		this.blame = 0;
		this.notAllowedToBorrowUntil = null;
		this.idUser = idUser;
	}
	
	public Subscriber(String firstname, String lastname, String address, String notAllowedToBorrowUntil, int idUser) {
		this.firstname = firstname;
		this.lastname = lastname;
		this.address = address;
		this.nbMaxBorrow = 5;
		this.blame = 0;
		this.notAllowedToBorrowUntil = LocalDate.parse(notAllowedToBorrowUntil);
		this.idUser = idUser;
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
	
	public void setNotAllowedToBorrowUntil(LocalDate notAllowedToBorrowUntil) {
		this.notAllowedToBorrowUntil = notAllowedToBorrowUntil;
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
