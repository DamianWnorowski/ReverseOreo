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
			   	<li class="active"><a data-toggle="pill" href="#resr-option">Reservations</a></li>
			   	<li><a data-toggle="pill" href="#flights-option">Flights</a></li>
			   	<li><a data-toggle="pill" href="#bids-option">Bids</a></li>
<!-- 			   <li class="active"><a href="#employee-option">Employees</a></li> -->
<!-- 			   <li><a href="#sales-option">Sales</a></li> -->
<!-- 			   <li><a href="/ReverseOreo/flightlist">Flights</a></li> -->
<!-- 			   <li><a href="#resr-option">Reservations</a></li> -->
			 </ul>
		</div>
		<div class="panel-body tab-content">
			<div id="flights-option" class="tab-pane fade in active">
				
			</div>
			<div id="bids-option" class="tab-pane fade">
				
			</div>
		
			<div id="resr-option" class="tab-pane fade">
				<div class="col-sm-12">
					<form class="form-horizontal" action="ListAllResrServlet" method="post">
						<div class="form-group col-sm-12">
						    <div class="col-sm-4">
						        <label for="allResr">View All Reservations:</label>
						    </div>
						    <div class="col-sm-4">
						    	<button type="submit" class="btn btn-default">View</button>
							</div>
						</div>
					</form>
				</div>
			</div>

		</div>			
	</div>
</div>
</html>