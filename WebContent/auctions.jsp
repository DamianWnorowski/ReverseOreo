<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>

<jsp:include page="_head.jsp"></jsp:include>
<jsp:include page="_nav.jsp"></jsp:include>

<div class="container">
      <div class="panel panel-default">
<div class="panel-heading">
	<ul class="nav nav-pills">
	   <li><a href="/ReverseOreo/">Search Flights</a></li>
	   <li><a href="/ReverseOreo/flightlist">All Flights</a></li>
	   <li class="active"><a href="/ReverseOreo/auctions.jsp">Auctions</a></li>
	 </ul>
</div>
<div class="panel-body tab-content">
<div id="auctions" class="tab-pane fade in active">
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
</div>
</div>
</div>
</html>
	
	
	
	
	