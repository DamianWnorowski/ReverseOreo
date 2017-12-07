package beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class FlightLegBeans implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String airlineId, flightNumber, dept, arr, price;
	private List<Object> list = new ArrayList<Object>();
	
	public FlightLegBeans(){
		
	}
	
	public void setList() {
		this.list.add(this.airlineId);
		this.list.add(this.flightNumber);
		this.list.add(this.dept);
		this.list.add(this.arr);
		this.list.add(this.price);
	}
	
	public List<Object> getList(){
		return this.list;
	}
	
	
	
	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getAirlineId() {
		return airlineId;
	}

	public void setAirlineId(String airlineId) {
		this.airlineId = airlineId;
	}

	public String getFlightNumber() {
		return flightNumber;
	}

	public void setFlightNumber(String flightNumber) {
		this.flightNumber = flightNumber;
	}


	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public String getArr() {
		return arr;
	}

	public void setArr(String arr) {
		this.arr = arr;
	}

	
}
