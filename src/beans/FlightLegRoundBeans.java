package beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class FlightLegRoundBeans implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String airlineIdDest, flightNumberDest, airlineIdBack, flightNumberBack, price;
	private List<Object> list = new ArrayList<Object>();
	
	public FlightLegRoundBeans(){
		
	}
	
	public void setList() {
		this.list.add(this.airlineIdDest);
		this.list.add(this.flightNumberDest);
		this.list.add(this.airlineIdBack);
		this.list.add(this.flightNumberBack);
		this.list.add(this.price);
	}
	
	public List<Object> getList(){
		return this.list;
	}

	public String getAirlineIdDest() {
		return airlineIdDest;
	}

	public void setAirlineIdDest(String airlineIdDest) {
		this.airlineIdDest = airlineIdDest;
	}

	public String getFlightNumberDest() {
		return flightNumberDest;
	}

	public void setFlightNumberDest(String flightNumberDest) {
		this.flightNumberDest = flightNumberDest;
	}

	public String getAirlineIdBack() {
		return airlineIdBack;
	}

	public void setAirlineIdBack(String airlineIdBack) {
		this.airlineIdBack = airlineIdBack;
	}

	public String getFlightNumberBack() {
		return flightNumberBack;
	}

	public void setFlightNumberBack(String flightNumberBack) {
		this.flightNumberBack = flightNumberBack;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}
	
	
	
}
