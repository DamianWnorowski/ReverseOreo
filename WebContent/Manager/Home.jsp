<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<html>
<jsp:include page="_head.jsp"></jsp:include>
<jsp:include page="_nav.jsp"></jsp:include>

<div class="container">
	<div class="panel panel-default">
		<div class="panel-heading">
			<ul class="nav nav-pills">
			
				<li class="active"><a data-toggle="pill" href="#flight-option">Flights</a></li>
			   	<li><a data-toggle="pill" href="#sales-option">Sales</a></li>
			   	<li><a data-toggle="pill" href="#resr-option">Reservations</a></li>
<!-- 			   <li class="active"><a href="#employee-option">Employees</a></li> -->
<!-- 			   <li><a href="#sales-option">Sales</a></li> -->
<!-- 			   <li><a href="/ReverseOreo/flightlist">Flights</a></li> -->
<!-- 			   <li><a href="#resr-option">Reservations</a></li> -->
			 </ul>
		</div>
		<div class="panel-body tab-content">
			<div id="flight-option" class="tab-pane fade in active">
				<jsp:include page="FlightsInfo.jsp"></jsp:include>
			</div>
			<div id="sales-option" class="tab-pane fade">
				<jsp:include page="Sales.jsp"></jsp:include>
			</div>
		
			<div id="resr-option" class="tab-pane fade">
				<jsp:include page="ReservationList.jsp"></jsp:include>
			</div>
		</div>			
	</div>
</div>
</html>