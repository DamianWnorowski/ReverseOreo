package beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class EmployeeInfo implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String firstName, lastName, address, city, state, zipcode, id, ssn, rate, isManager, startDate;
	private List<Object> list = new ArrayList<Object>();
	
	public EmployeeInfo(){
		
	}
	
	public void setList(){
		this.list.add(this.firstName);
		this.list.add(this.lastName);
		this.list.add(this.address);
		this.list.add(this.city);
		this.list.add(this.state);
		this.list.add(this.zipcode);
		this.list.add(this.id);
		this.list.add(this.ssn);
		this.list.add(this.rate);
		this.list.add(this.isManager);
		this.list.add(this.startDate);
	}
	
	public List<Object> getList(){
		return this.list;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getSsn() {
		return ssn;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
	}

	public String getRate() {
		return rate;
	}

	public void setRate(String rate) {
		this.rate = rate;
	}

	public String getIsManager() {
		return isManager;
	}

	public void setIsManager(String isManager) {
		this.isManager = isManager;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	
	
}
