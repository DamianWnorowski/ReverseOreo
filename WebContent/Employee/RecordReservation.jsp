<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">



<form class="form-horizontal" action="RecordReservationServlet" method="post">
	<div class="form-group col-sm-6">	<!-- Customer Account Number -->
	    <div class="col-sm-12">
	        <label for="accountNumber">Customer Account Number:</label>
	        <input type="text" class="form-control" id="accountNumber" placeholder="Account Number" name="accountNumber">
	    </div>
	</div>
	<div class="form-group col-sm-6">	<!-- Last Name -->
	    <div class="col-sm-12">
	        <label for="bookingFee">Booking Fee:</label>
	        <input type="text" class="form-control" id="bookingFee" placeholder="Booking Fee" name="bookingFee">
	    </div>
	</div>
	<div class="form-group col-sm-6">	<!-- Employee Id -->
	    <div class="col-sm-12">
	        <label for="totalFare">Total Fare:</label>
	        <input type="text" class="form-control" id="totalFare" placeholder="Total Fare" name="totalFare">
	    </div>
	</div>
	<div class="form-group col-sm-6">	<!-- Employee Id -->
	    <div class="col-sm-12">
	        <label for="repId">Representative Id:</label>
	        <input type="text" class="form-control" id="repId" placeholder="Rep Id" name="repId">
	    </div>
	</div>
	
	<div class="form-group col-sm-12">        
		<div class="col-sm-4">
	    	<button type="submit" class="btn btn-default">Submit</button>
		</div>
	</div>
</form>