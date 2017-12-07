package beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ReservationPassengerListBeans implements Serializable{
	private static final long serialVersionUID = 1L;

	private String ResrNo, Id, AccountNo, SeatNo, Classx, Meal;
	private List<Object> list = new ArrayList<Object>();
	
	public ReservationPassengerListBeans(){
		
	}
	
	public void setList(){
		this.list.add(this.ResrNo);
		this.list.add(this.Id);
		this.list.add(this.AccountNo);
		this.list.add(this.SeatNo);
		this.list.add(this.Classx);
		this.list.add(this.Meal);
	}
	
	public List<Object> getList(){
		return this.list;
	}

	public String getResrNo() {
		return ResrNo;
	}

	public void setResrNo(String ResrNo) {
		this.ResrNo = ResrNo;
	}

	public String getId() {
		return Id;
	}

	public void setId(String Id) {
		this.Id = Id;
	}

	public String getAccountNo() {
		return AccountNo;
	}

	public void setAccountNo(String AccountNo) {
		this.AccountNo = AccountNo;
	}

	public String getSeatNo() {
		return SeatNo;
	}

	public void setSeatNo(String SeatNo) {
		this.SeatNo = SeatNo;
	}

	public String getTheClass() {
		return Classx;
	}

	public void setTheClass(String Classx) {
		this.Classx = Classx;
	}

	public String getMeal() {
		return Meal;
	}

	public void setMeal(String Meal) {
		this.Meal = Meal;
	}

	

}
