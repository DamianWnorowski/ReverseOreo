<%-- <%@ page language="java" contentType="text/html; charset=ISO-8859-1" --%>
<%-- pageEncoding="ISO-8859-1"%> --%>
<%-- <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> --%>
<!-- <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd"> -->

<!-- <html> -->

<!-- <head> -->
<!--     <title>Reverse Oreo</title> -->
<!--     <meta name="viewport" content="width=device-width, initial-scale=1"> -->
<!--     <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"> -->
<!--     <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script> -->
<!--     <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script> -->

<!-- </head> -->
    

<!-- <body> -->

<!-- <div class="container"> -->
<!-- <div class="col-sm-2"></div> -->
<!-- <div class="col-sm-8"> -->
<!-- <div class="panel panel-default"> -->
<!-- 	<div class="panel-heading"> -->
<!--     	<h3>All Flights</h3> -->
<!-- 	</div> -->
<!-- 	<div class="panel-body"> -->
		<table class="table table-striped">
			<thead>
		       <tr>
				  <th>Airplane Id</th>
		          <th>Airplane Name</th>
		       </tr>
			</thead>
			<tbody>
		       <c:forEach items="${airplaneList}" var="product" >
		          <tr>
					<td>${product.airplaneId}</td>
		            <td>${product.airplaneName}</td>
		          </tr>
		       </c:forEach>
			</tbody>
		</table>
<!-- 	</div> -->
<!-- </div> -->
<!-- </div> -->
<!-- </div> -->

<!-- </html> -->