package beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MostActiveFlightsBeans implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String airlineId, flightNumber, totalResr;
	private List<Object> list = new ArrayList<Object>();
	
	public MostActiveFlightsBeans(){
		
	}
	
	public void setList(){
		this.list.add(this.airlineId);
		this.list.add(this.flightNumber);
		this.list.add(this.totalResr);
	}
	
	public List<Object> getList(){
		return this.list;
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

	public String getTotalResr() {
		return totalResr;
	}

	public void setTotalResr(String totalResr) {
		this.totalResr = totalResr;
	}
	
	


}
