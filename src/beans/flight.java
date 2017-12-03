package beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class flight implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String airplaneId;
	private String airplaneName;
	private List<Object> list = new ArrayList<Object>();
	
	public flight(){

	}

	
	public String getAirplaneName(){
		return this.airplaneName;
	}
	
	public List<Object> getList(){
		return this.list;
	}
	
	public void setAirplaneName(String airplaneName){
		this.airplaneName = airplaneName;
	}
	
	public String getAirplaneId(){
		return this.airplaneId;
	}
	
	public void setAirplaneId(String airplaneId){
		this.airplaneId = airplaneId;
	}
	
	public void setList(){
		this.list.add(this.airplaneId);
		this.list.add(this.airplaneName);
	}
}
