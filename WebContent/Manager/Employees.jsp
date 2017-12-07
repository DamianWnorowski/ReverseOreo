<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<form class="form-horizontal" action="" method="post">
	<div class="form-group col-sm-12">
	    <div class="col-sm-4">
	        <label for="flightNumber">Add Employee:</label>
	    </div>
	    <div class="col-sm-4">
	    	<button type="submit" class="btn btn-default"></button>
		</div>
	</div>
</form>

<form class="form-horizontal" action="MostActiveFlightsServlet" method="post">
	<div class="form-group col-sm-12">
	    <div class="col-sm-4">
	        <label for="flightNumber">Most Active Flights:</label>
	    </div>
	    <div class="col-sm-4">
	    	<button type="submit" class="btn btn-default">View</button>
		</div>
	</div>
</form>

<form class="form-horizontal" action="AirlineRunTimeScheduleServlet" method="post">
	<div class="form-group col-sm-12">
	    <div class="col-sm-4">
	        <label for="flightNumber">Flights On-Time/Delayed:</label>
	    </div>
	    <div class="col-sm-4">
	    	<button type="submit" class="btn btn-default">View</button>
		</div>
	</div>
</form>

<form class="form-horizontal" action="FlightsAtAirportServlet" method="post">
	<div class="form-group col-sm-12">
	    <div class="col-sm-12">
	        <label >List All Flights at Airport:</label> 
	    </div>
	    <div class="col-sm-6">
	        <input type="text" class="form-control" id="airport" placeholder="Airport" name="airport">
	    </div>
	    <div class="col-sm-6">
	    	<button type="submit" class="btn btn-default">Search</button>
		</div>
	</div>
</form>