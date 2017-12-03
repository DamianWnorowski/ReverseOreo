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
     <jsp:include page="searchflight.jsp"></jsp:include>
</div>
</div>
</div>
</div>
	
</html>