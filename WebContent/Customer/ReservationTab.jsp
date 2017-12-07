<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<form class="form-horizontal" action="ListAllResrServlet" method="post">
	<div class="form-group col-sm-12">
	    <div class="col-sm-5">
	        <label for="allActiveReservations">Current Reservations:</label>
	    </div>
	    <div class="col-sm-5">
	    	<button type="submit" class="btn btn-default">View</button>
		</div>
	</div>
</form>

<form class="form-horizontal" action="ListAllResrServlet" method="post">
	<div class="form-group col-sm-12">
	    <div class="col-sm-5">
	        <label for="allReservations">All Reservations:</label>
	    </div>
	    <div class="col-sm-5">
	    	<button type="View" class="btn btn-default">View</button>
		</div>
	</div>
</form>

<form class="form-horizontal" action="ListResrByNameServlet">
	<div class="form-group col-sm-12">
	    <div class="col-sm-12">
	        <label >Get Itinerary:</label> 
	    </div>
	    <div class="col-sm-5">
	        <input type="text" class="form-control" id="ResrNo" placeholder="Reservation Number" name="ResrNo">
	    </div>
	    
		<div class="col-sm-2">
		    <button type="submit" class="btn btn-default">Search</button>
		</div>

	</div>
</form>