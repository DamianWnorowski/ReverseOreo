<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<script src="//ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
<script>
function getCurrentBid() {
	var bid = document.getElementById("bidNo").value
	var url = "GetBidInfo.jsp?choice=curr&bid=" + bid;
	$.post(url, function(data){
		$('body').find('#curr-bid-result').html(data);
	});
}

function getBidHist() {
	var bid = document.getElementById("bidNo").value;
	var url = "GetBidInfo.jsp?choice=hist&bid=" + bid;
	$.post(url, function(data){
		$('body').find('#bid-hist-result').html(data);
	});
}

</script>

<form class="form-horizontal" action="javascript:getCurrentBid();">
	<div class="form-group col-sm-12">
	    <div class="col-sm-12">
	        <label >My Current Bid:</label> 
	    </div>
	    <div class="col-sm-5">
	        <input type="text" class="form-control" id="bidNo" placeholder="Bid Number" name="bidNo">
	    </div>
	    
		<div class="col-sm-2">
		    <button type="submit" class="btn btn-default">Search</button>
		</div>

	</div>
</form>

<div class="panel-body tab-content">
	<div id="curr-bid-result" ></div>
</div>

<form class="form-horizontal" action="javascript:getBidHist();">
	<div class="form-group col-sm-12">
	    <div class="col-sm-12">
	        <label >Bid History:</label> 
	    </div>
	    <div class="col-sm-5">
	        <input type="text" class="form-control" id="bidNo" placeholder="Bid Number" name="bidNo">
	    </div>
	    
		<div class="col-sm-2">
		    <button type="submit" class="btn btn-default">Search</button>
		</div>

	</div>
</form>

<div class="panel-body tab-content">
	<div id="bid-hist-result" ></div>
</div>
