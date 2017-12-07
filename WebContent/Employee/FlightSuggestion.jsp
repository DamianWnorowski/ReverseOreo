<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ page import="java.io.*"%>
<%@ page import="java.sql.*"%>
<%@ page import="servlets.MySQLConnUtils"%>
<%@ page import="java.util.ArrayList, java.util.List"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>



<form class="form-horizontal" action="FlightSuggestionServlet" method="post">
	<div class="form-group col-sm-6">	<!-- Customer Account Number -->
	    <div class="col-sm-12">
	        <label for="accountNumber">Customer Account Number:</label>
	        <input type="text" class="form-control" id="accountNumber" placeholder="Account Number" name="accountNumber">
	    </div>
	</div>
	
	<div class="form-group col-sm-12">        
		<div class="col-sm-4">
	    	<button type="Submit" class="btn btn-default">Submit</button>
		</div>
	</div>
</form>

	
	
