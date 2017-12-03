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
	   <li class="active"><a data-toggle="pill" href="#searchflight">Search Flights</a></li>
	   <li><a href="/ReverseOreo/flightlist">All Flights</a></li>
	   <li><a href="/ReverseOreo/auctions.jsp">Auctions</a></li>
	 </ul>
</div>
<div class="panel-body tab-content">
<div id="searchflight" class="tab-pane fade in active">
     <form class="form-horizontal" action="/action_page.php">
         <div class="form-group col-sm-6">
             <div class="col-sm-12">
                 <label for="origin">Origin:</label>
                 <input type="text" class="form-control" id="origin" placeholder="City or Airport" name="origin">
             </div>
         </div>
         <div class="form-group col-sm-6">
             <div class="col-sm-12">
                 <label for="destination">Destination:</label> 
                 <input type="text" class="form-control" id="destination" placeholder="City or Airport" name="destination">
             </div>
         </div>
         <div class="form-group col-sm-6">
             <div class="col-sm-6">
                 <label for="departing">Departing:</label>
                 <input type="text" class="form-control" id="departing" placeholder="mm/dd/yyyy" name="departing">
             </div>
         
             <div class="col-sm-6">
                 <label for="returning">Returning:</label>
                 <input type="text" class="form-control" id="returning" placeholder="mm/dd/yyyy" name="returning">
             </div>
         </div>
	  <div class="form-group col-sm-6">
	      <div class="col-sm-4">
	          <label for="ph">PH:</label>
	          <input type="text" class="form-control" id="ph" placeholder="ph" name="ph">
	      </div>
	      <div class="col-sm-4">
	          <label for="ph">PH:</label>
	          <input type="text" class="form-control" id="ph" placeholder="ph" name="ph">
	      </div>
	      <div class="col-sm-4">
	          <label for="ph">PH:</label>
	          <input type="text" class="form-control" id="ph" placeholder="ph" name="ph">
	      </div>
	  </div>
	<div class="form-group col-sm-12">        
		<div class="col-sm-4">
	    <button type="button" class="btn btn-default">Search</button>
		</div>
	</div>
  	</form>
</div>
</div>
</div>
</div>
	
</html>