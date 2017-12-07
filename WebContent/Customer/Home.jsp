<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<html>

<jsp:include page="../_head.jsp"></jsp:include>
<jsp:include page="../_nav.jsp"></jsp:include>


<div class="container">
	<div class="panel panel-default">
		<div class="panel-heading"> 
			<ul class="nav nav-pills">
			   	<li class="active"><a data-toggle="pill" href="#resr-option" onClick="javascript:$('#curr-result').html('');$('#all-result').html('')">Reservations</a></li>
			   	<li><a data-toggle="pill" href="#flights-option" onClick="javascript:$('#sugg-result').html('');$('#best-result').html('')">Flights</a></li>
			   	<li><a data-toggle="pill" href="#bids-option">Bids</a></li>
			 </ul>
		</div>
		<div class="panel-body tab-content">
			<div id="resr-option" class="tab-pane fade in active">
				<jsp:include page="ReservationTab.jsp"></jsp:include>
			</div>
			
			<div id="flights-option" class="tab-pane fade">
				<jsp:include page="FlightTab.jsp"></jsp:include>
			</div>
			
			<div id="bids-option" class="tab-pane fade">
				<jsp:include page="BidTab.jsp"></jsp:include>
			</div>

		</div>	
		
			
	</div>
</div>
</html>