package entity;

import java.util.Date;

public class Subscriber {
	
	private int idSubscriber;
	private String firstname;
	private String lastname;
	private String adress;
	private int nbMaxBorrow;
	private int blame;
	private Date notAllowedToBorrowUntil;
	private int idUser;
	
//	@ManyToOne
//	@JoinColumn(name = "idUser")
//	private User user;
	
   public Subscriber() {
   }
  
   public Subscriber(int idSubscriber, String firstname, String lastname, String adress, int nbMaxBorrow, int blame,
   		Date notAllowedToBorrowUntil, int idUser) {
   	this.idSubscriber = idSubscriber;
   	this.firstname = firstname;
   	this.lastname = lastname;
   	this.adress = adress;
   	this.nbMaxBorrow = nbMaxBorrow;
   	this.blame = blame;
   	this.notAllowedToBorrowUntil = notAllowedToBorrowUntil;
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
	
	public String getAdress() {
		return adress;
	}
	
	public void setAdress(String adress) {
		this.adress = adress;
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
	
	public Date getNotAllowedToBorrowUntil() {
		return notAllowedToBorrowUntil;
	}
	
	public void setNotAllowedToBorrowUntil(Date notAllowedToBorrowUntil) {
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
				+ ", adress=" + adress + ", nbMaxBorrow=" + nbMaxBorrow + ", blame=" + blame
				+ ", notAllowedToBorrowUntil=" + notAllowedToBorrowUntil + ", idUser=" + idUser + "]";
	}
}
