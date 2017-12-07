<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<script src="//ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
<script>
function getBestFlight() {
	var url = "GetBestSellingFlight.jsp?choice=best";
	$.post(url, function(data){
		$('body').find('#best-result').html(data);
	});
}

function getSuggFlight() {
	var url = "GetBestSellingFlight.jsp?choice=sugg";
	$.post(url, function(data){
		$('body').find('#sugg-result').html(data);
	});
}

</script>

	<div class="form-group col-sm-12">
	    <div class="col-sm-12">
	        <label for="bestSellingFlights">Best Selling Flights:</label>
	    </div>
	    <div class="col-sm-6">
	    	<button type="button" onClick="getBestFlight()" class="btn btn-default">View</button>
		</div>
	</div>
	
<div class="panel-body tab-content">
	<div id="best-result" ></div>
</div>



	<div class="form-group col-sm-12">
	    <div class="col-sm-12">
	        <label for="flightSugg">Flight Suggestions:</label>
	    </div>
	    <div class="col-sm-6">
	    	<button type="button" class="btn btn-default">View</button>
		</div>
	</div>
	
<div class="panel-body tab-content">
	<div id="sugg-result" ></div>
</div>

