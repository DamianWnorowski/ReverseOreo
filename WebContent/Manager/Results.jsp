<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<jsp:include page="../_head.jsp"></jsp:include>
<jsp:include page="../_nav.jsp"></jsp:include>


<div class="container">
<div class="panel panel-default">
	<div class="panel-heading">
		<ul class="nav nav-pills">
		
			<li><a data-toggle="pill" href="#flight-option">Flights</a></li>
		   	<li><a data-toggle="pill" href="#sales-option">Sales</a></li>
		   	<li><a data-toggle="pill" href="#resr-option">Reservations</a></li>
		   	<li><a data-toggle="pill" href="#employee-option">Employees</a></li>
		   	<li class="active"><a data-toggle="pill" href="#results-option">Results</a></li>

		 </ul>
	</div>
	<div class="panel-body tab-content">
		<div id="flight-option" class="tab-pane fade">
			<jsp:include page="FlightsInfo.jsp"></jsp:include>
		</div>
		<div id="sales-option" class="tab-pane fade">
			<jsp:include page="Sales.jsp"></jsp:include>
		</div>
	
		<div id="resr-option" class="tab-pane fade">
			<jsp:include page="ReservationList.jsp"></jsp:include>
		</div>
		<div id="employee-option" class="tab-pane fade">
			<jsp:include page="AddNewEmployee.jsp"></jsp:include>
		</div>
	
		<div id="results-option" class="tab-pane fade in active">
			<table class="table table-striped">
				<thead>
			       <tr>
			       <c:forEach items="${colNames}" var="col">
			       		<th>${col}</th>
			       </c:forEach>
			       </tr>
				</thead>
				<tbody>
			       <c:forEach items="${rowVal}" var="val" >
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