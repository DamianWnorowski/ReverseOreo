package beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class RevenueSummaryBeans implements Serializable{
	private static final long serialVersionUID = 1L;
	
	String summaryBy, bookingFee;
	
	private List<Object> list = new ArrayList<Object>();
	public RevenueSummaryBeans(){
		
	}
	
	public void setList(){
		this.list.add(this.summaryBy);
		this.list.add(this.bookingFee);
	}
	
	public List<Object> getList(){
		return this.list;
	}
	
	public String getSummaryBy() {
		return summaryBy;
	}
	public void setSummaryBy(String summaryBy) {
		this.summaryBy = summaryBy;
	}
	public String getBookingFee() {
		return bookingFee;
	}
	public void setBookingFee(String bookingFee) {
		this.bookingFee = bookingFee;
	}
	
	
	
}
