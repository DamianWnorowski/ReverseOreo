package beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class FlightLegBeans implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String airlineId, flightNumber, legNumber, dept, arr, arrTime, deptTime;
	private List<Object> list = new ArrayList<Object>();
	
	public FlightLegBeans(){
		
	}
	
	public void setList() {
		this.list.add(this.airlineId);
		this.list.add(this.flightNumber);
		this.list.add(this.legNumber);
		this.list.add(this.dept);
		this.list.add(this.arr);
		this.list.add(this.arrTime);
		this.list.add(this.deptTime);
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

	public String getLegNumber() {
		return legNumber;
	}

	public void setLegNumber(String legNumber) {
		this.legNumber = legNumber;
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

	public String getArrTime() {
		return arrTime;
	}

	public void setArrTime(String arrTime) {
		this.arrTime = arrTime;
	}

	public String getDeptTime() {
		return deptTime;
	}

	public void setDeptTime(String deptTime) {
		this.deptTime = deptTime;
	}

	
	
}
