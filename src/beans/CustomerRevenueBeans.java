package beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class CustomerRevenueBeans implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String firstName, lastName, id, totalRevenue;
	private List<Object> list = new ArrayList<Object>();

	public  CustomerRevenueBeans() {
		
	}
	
	public void setList(){
		this.list.add(this.firstName);
		this.list.add(this.lastName);
		this.list.add(this.id);
		this.list.add(this.totalRevenue);
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

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}


	public String getTotalRevenue() {
		return totalRevenue;
	}

	public void setTotalRevenue(String totalRevenue) {
		this.totalRevenue = totalRevenue;
	}
	
	


}
