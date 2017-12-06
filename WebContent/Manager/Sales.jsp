<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<form class="form-horizontal" action="EmployeeRevenueServlet" method="post">
	<div class="form-group col-sm-12">
	    <div class="col-sm-4">
	        <label for="rep">Customer Representative with most Revenue:</label>
	    </div>
	    <div class="col-sm-4">
	    	<button type="submit" class="btn btn-default">View</button>
		</div>
	</div>
</form>
<form class="form-horizontal" action="CustomerRevenueServlet" method="post">
	<div class="form-group col-sm-12">
	    <div class="col-sm-4">
	        <label for="cust">Customer with most Revenue:</label>
	    </div>
	    <div class="col-sm-4">
	    	<button type="submit" class="btn btn-default">View</button>
		</div>
	</div>
</form>
<form class="form-horizontal" action="SalesReportServlet" method="post">
	<div class="form-group col-sm-12">
	    <div class="col-sm-4">
	        <label for="flightNumber">Sales Report by Month:</label>
		    <select name="month">
				<option value="1">Jan</option>
				<option value="2">Feb</option>
				<option value="3">March</option>
				<option value="4">April</option>
				<option value="5">May</option>
				<option value="6">June</option>
				<option value="7">July</option>
				<option value="8">Aug</option>
				<option value="9">Sept</option>
				<option value="10">Oct</option>
				<option value="11">Nov</option>
				<option value="12">Dec</option>
				
			</select>
	    </div>
	    <div class="col-sm-6">
	    	<button type="submit" class="btn btn-default">View</button>
		</div>
	</div>
</form>
<form class="form-horizontal" action="RevenueSummaryServlet" method="post">
	<div class="form-group col-sm-12">
	    <div class="col-sm-12">
	        <label for="flightNumber">Revenue Summary:</label>
	    </div>
	    <div class="col-sm-6">
	        <input type="text" class="form-control" id="searchValue" name="searchValue">
	    </div>
	    <div class="col-sm-4">
		    <label for="state">Search By:</label>
		    <select name="searchBy">
				<option value="flight">Flight</option>
				<option value="city">City</option>
				<option value="customer">Customer</option>
			</select>
		</div> 
	    <div class="col-sm-2">
	    	<button type="submit" class="btn btn-default">Search</button>
		</div>
	</div>
</form>
