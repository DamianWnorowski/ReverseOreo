<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<script src="//ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
<script>
function getCurrResr() {
	var url = "GetResrList.jsp?all=no";
	var aj = $.post(url, function(data){
		$('body').find('#curr-result').html(data);
	}, 'html');
	
	aj.always(function() {
	  });
}

function getAllResr() {
	var url = "GetResrList.jsp?all=yes";
	$.post(url, function(data){
		$('body').find('#all-result').html(data);
	}).aj.always(function() {
	  });
}

</script>


<div class="form-group col-sm-12">
	    <div class="col-sm-5">
	        <label for="allActiveReservations">Current Reservations:</label>
	    </div>
	    <div class="col-sm-5">
	    	<button type="button" class="btn btn-default" onclick="getCurrResr()">View</button>
		</div>
</div>

<div class="panel-body tab-content">
	<div id="curr-result" ></div>
</div>


	<div class="form-group col-sm-12">
	    <div class="col-sm-5">
	        <label for="allReservations">All Reservations:</label>
	    </div>
	    <div class="col-sm-5">
	    	<button type="button" onClick="getAllResr()" class="btn btn-default">View</button>
		</div>
	</div>
	
<div class="panel-body tab-content">
	<div id="all-result" ></div>
</div>


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

<br></br>
		