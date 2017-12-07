package beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class AirlineScheduleBeans implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String airlineId, flightNumber, onTime;
	private List<Object> list = new ArrayList<Object>();
	
	public AirlineScheduleBeans(){
		
	}
	
	public void setList(){
		this.list.add(this.airlineId);
		this.list.add(this.flightNumber);
		this.list.add(this.onTime);
	}

	public List<Object> getlist(){
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

	public String getOnTime() {
		return onTime;
	}

	public void setOnTime(String onTime) {
		this.onTime = onTime;
	}

	
	

}
