package beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class SalesInfoBeans implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String resrDate, resrNo, bookingFee, totalFare;
	private String id, firstName, lastName, email;
	private List<Object> list = new ArrayList<Object>();
	
	public SalesInfoBeans(){
		
	}
	
	public void setList(){
		this.list.add(this.resrDate);
		this.list.add(this.resrNo);
		this.list.add(this.bookingFee);
		this.list.add(this.totalFare);
		this.list.add(this.id);
		this.list.add(this.firstName);
		this.list.add(this.lastName);
		this.list.add(this.email);
	}
	
	public List<Object> getList(){
		return this.list;
	}

	public String getResrDate() {
		return resrDate;
	}

	public void setResrDate(String resrDate) {
		this.resrDate = resrDate;
	}

	public String getResrNo() {
		return resrNo;
	}

	public void setResrNo(String resrNo) {
		this.resrNo = resrNo;
	}

	public String getBookingFee() {
		return bookingFee;
	}

	public void setBookingFee(String bookingFee) {
		this.bookingFee = bookingFee;
	}

	public String getTotalFare() {
		return totalFare;
	}

	public void setTotalFare(String totalFare) {
		this.totalFare = totalFare;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	

}
