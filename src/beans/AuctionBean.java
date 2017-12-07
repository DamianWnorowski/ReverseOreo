/**
 * 
 */
package beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author nefer
 *
 */
public class AuctionBean implements Serializable {
	private static final long serialVersionUID = 1L;

	private String AccountNo, AirlineId, FlightNo, Classx, Date, NYOP;
	private List<Object> list = new ArrayList<Object>();

	/**
	 * 
	 */
	public AuctionBean() {
		// TODO Auto-generated constructor stub
	}
	

	public String getAccountNo() {
		return AccountNo;
	}

	public void setAccountNo(String accountNo) {
		AccountNo = accountNo;
	}

	public String getAirlineId() {
		return AirlineId;
	}

	public void setAirlineId(String airlineId) {
		AirlineId = airlineId;
	}

	public String getFlightNo() {
		return FlightNo;
	}

	public void setFlightNo(String flightNo) {
		FlightNo = flightNo;
	}

	public String getClassx() {
		return Classx;
	}

	public void setClassx(String classx) {
		Classx = classx;
	}

	public String getDate() {
		return Date;
	}

	public void setDate(String date) {
		Date = date;
	}

	public String getNYOP() {
		return NYOP;
	}

	public void setNYOP(String nYOP) {
		NYOP = nYOP;
	}

	public List<Object> getList() {
		return list;
	}

	public void setList(List<Object> list) {
			this.list.add(this.AccountNo);
			this.list.add(this.AirlineId);
			this.list.add(this.AirlineId);
			this.list.add(this.FlightNo);
			this.list.add(this.Classx);
			this.list.add(this.Date);
			this.list.add(this.NYOP);
	}

}
