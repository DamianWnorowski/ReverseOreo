<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<html>
<script>
	function getAllFlights() {
		var url = "AllFlights.jsp";
		var xhttp = new XMLHttpRequest();
		xhttp.onreadystatechange = function() {
			if (this.readyState == 4 && this.status == 200) {
				$('body').find('#flight-list').html(this.responseText);
			}
		};
		xhttp.open("GET", url, true);
		xhttp.send();
	}
</script>

<jsp:include page="_head.jsp"></jsp:include>
<jsp:include page="_nav.jsp"></jsp:include>

<div class="container">
	<div class="panel panel-default">
		<div class="panel-heading">

			<!-- Home Tabs -->
			<ul class="nav nav-pills" id="homepage-nav">
				<li><a data-toggle="pill" data-target ="#flight-search">Search
						Flights</a></li>
				<li><a id="allflightsbtn" data-toggle="pill" data-target="#flight-list" onclick="getAllFlights()">All
						Flights</a></li>
				<li><a data-toggle="pill" data-target="#auctions">Auctions</a></li>
				<li class="active"><a data-toggle="pill" data-target="#results">Results</a></li>
			</ul>
		</div>

		<!-- Content of the Home tabs -->
		<div class="panel-body tab-content">
			<div id="flight-search" class="tab-pane fade">
				<form class="form-horizontal" action="/action_page.php">
					<div class="form-group col-sm-4">
						<div class="col-sm-12">
							<label for="origin">Origin:</label> <input type="text"
								class="form-control" id="origin" placeholder="Airport"
								name="origin">
						</div>
					</div>
					<div class="form-group col-sm-4">
						<div class="col-sm-12">
							<label for="destination">Destination:</label> <input type="text"
								class="form-control" id="destination"
								placeholder="Airport" name="destination">
						</div>
					</div>
					<div class="col-sm-4">
				        <label for="flightNumber">Trip</label>
					    <select name="month">
							<option value="oneway">One way</option>
							<option value="round">Round Trip</option>						
						</select>
				    </div>
<!-- 					<div class="form-group col-sm-6"> -->
<!-- 						<div class="col-sm-6"> -->
<!-- 							<label for="departing">Departing:</label> <input type="text" -->
<!-- 								class="form-control" id="departing" placeholder="mm/dd/yyyy" -->
<!-- 								name="departing"> -->
<!-- 						</div> -->

<!-- 						<div class="col-sm-6"> -->
<!-- 							<label for="returning">Returning:</label> <input type="text" -->
<!-- 								class="form-control" id="returning" placeholder="mm/dd/yyyy" -->
<!-- 								name="returning"> -->
<!-- 						</div> -->
<!-- 					</div> -->
<!-- 					<div class="form-group col-sm-6"> -->
<!-- 						<div class="col-sm-4"> -->
<!-- 							<label for="ph">PH:</label> <input type="text" -->
<!-- 								class="form-control" id="ph" placeholder="ph" name="ph"> -->
<!-- 						</div> -->
<!-- 						<div class="col-sm-4"> -->
<!-- 							<label for="ph">PH:</label> <input type="text" -->
<!-- 								class="form-control" id="ph" placeholder="ph" name="ph"> -->
<!-- 						</div> -->
<!-- 						<div class="col-sm-4"> -->
<!-- 							<label for="ph">PH:</label> <input type="text" -->
<!-- 								class="form-control" id="ph" placeholder="ph" name="ph"> -->
<!-- 						</div> -->
<!-- 					</div> -->
					<div class="form-group col-sm-12">
						<div class="col-sm-4">
							<button type="button" class="btn btn-default">Search</button>
						</div>
					</div>
				</form>
			</div>


			  
			<div id="flight-list" class="tab-pane fade"></div>
			
			
			
			<div id="auctions" class="tab-pane fade">
				<table class="table table-striped">
					<thead>
						<tr>
							<th>A1</th>
							<th>A2</th>
						</tr>
					</thead>
					<tbody>

					</tbody>
				</table>
			</div>
			
			<div id="results" class="tab-pane fade in active">
			<table class="table table-striped">
				<thead>
					<tr>
						<c:forEach items="${colNames}" var="col">
							<th>${col}</th>
						</c:forEach>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${rowVal}" var="val">
						<tr>
							<c:forEach items="${val.list}" var="attr">
								<td>${attr}</td>
							</c:forEach>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			</div>
			
		</div>
	</div>
</div>
</html>