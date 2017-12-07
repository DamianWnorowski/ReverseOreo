package beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class CustomerBeans implements Serializable{
	private static final long serialVersionUID = 1L;

	private String id, accountNumber, creditCard, email, date, rating;
	private List<Object> list = new ArrayList<Object>();
	
	public void setList(){
		this.list.add(this.id);
		this.list.add(this.accountNumber);
		this.list.add(this.creditCard);
		this.list.add(this.email);
		this.list.add(this.date);
		this.list.add(this.rating);
	}
	
	public List<Object> getList(){
		return this.list;
	}
	
	
	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getCreditCard() {
		return creditCard;
	}
	public void setCreditCard(String creditCard) {
		this.creditCard = creditCard;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getRating() {
		return rating;
	}
	public void setRating(String rating) {
		this.rating = rating;
	}

	
	

}
