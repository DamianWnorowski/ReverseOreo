<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<form class="form-horizontal" action="ListByFlightServlet" method="post">
	<div class="form-group col-sm-12">
	    <div class="col-sm-12">
	        <label for="flightNumber">Reservations by Flight:</label>
	    </div>
	    <div class="col-sm-6">
	        <input type="text" class="form-control" id="flightNumber" placeholder="Flight Number" name="flightNumber">
	    </div>
	    <div class="col-sm-6">
	    	<button type="submit" class="btn btn-default">Search</button>
		</div>
	</div>
</form>

<form class="form-horizontal" action="ListResrByNameServlet">
	<div class="form-group col-sm-12">
	    <div class="col-sm-12">
	        <label >Reservation By Customer Name:</label> 
	    </div>
	    <div class="col-sm-5">
	        <input type="text" class="form-control" id="firstName" placeholder="First Name" name="firstName">
	    </div>
	
		<div class="form-group col-sm-5">
			<input type="text" class="form-control" id="lastName" placeholder="Last Name" name="lastName">
		</div>
	       
		<div class="col-sm-2">
		    <button type="submit" class="btn btn-default">Search</button>
		</div>

	</div>
</form>