package beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class flight implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String airlineId, flightNo, noOfSeats, daysOperating, minLengthOfStay, maxLengthOfStay;
	private List<Object> list = new ArrayList<Object>();
	
	public flight(){

	}
	
	public void setList(){
		this.list.add(this.airlineId);
		this.list.add(this.flightNo);
		this.list.add(this.noOfSeats);
		this.list.add(this.daysOperating);
		this.list.add(this.minLengthOfStay);
		this.list.add(this.maxLengthOfStay);
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

	public String getFlightNo() {
		return flightNo;
	}

	public void setFlightNo(String flightNo) {
		this.flightNo = flightNo;
	}

	public String getNoOfSeats() {
		return noOfSeats;
	}

	public void setNoOfSeats(String noOfSeats) {
		this.noOfSeats = noOfSeats;
	}

	public String getDaysOperating() {
		return daysOperating;
	}

	public void setDaysOperating(String daysOperating) {
		this.daysOperating = daysOperating;
	}

	public String getMinLengthOfStay() {
		return minLengthOfStay;
	}

	public void setMinLengthOfStay(String minLengthOfStay) {
		this.minLengthOfStay = minLengthOfStay;
	}

	public String getMaxLengthOfStay() {
		return maxLengthOfStay;
	}

	public void setMaxLengthOfStay(String maxLengthOfStay) {
		this.maxLengthOfStay = maxLengthOfStay;
	}

	
	
}
