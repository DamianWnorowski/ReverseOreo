<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">



<html>
<jsp:include page="_head.jsp"></jsp:include>
<jsp:include page="_nav.jsp"></jsp:include>


<head>
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
<script src="js/jquery-1.11.3.js" charset="utf-8"></script>

<script type="text/javascript">
function editEmployee(){
	document.getElementById("employee-content").style.display='inline';
};

function checkVis(){
	var display = document.getElementById("employee-content").style.display;
	if(display =='inline' || display == ""){
		document.getElementById("employee-content").style.display='none';	//Hide the employee table
	}
};


</script>
</head>

<div class="container">
<div class="panel panel-default">
	<div class="panel-heading">
		<ul class="nav nav-pills">
		   <li class="active"><a data-toggle="tab" href="#employee-option" onClick="checkVis()")>Employees</a></li>
		   <li><a data-toggle="tab" href="#sales-option">Sales</a></li>
		   <li><a data-toggle="tab" href="#flights-option">Flights</a></li>
		 </ul>
	</div>
<div class="panel-body tab-content">	
	<div id="employee-option" class="tab-pane fade in active">
		<ul>
		   <li><a id="addEmployee" href="javascript:alert('time to add employee');">Add an Employee</a></li>
		   <li><a id="editEmployee" href="EmployeeListServlet" onClick="editEmployee()">Delete/Edit an Employee</a></li>
		 </ul>
		 <div id="employee-content">
		 	<jsp:include page="_table.jsp"></jsp:include>
		 </div>
	</div>
	
	<div id="sales-option" class="tab-pane fade">
		<ul>
		   <li><a href="javascript:alert('ssales report');">Monthly Sales Report</a></li>
		   <li><a href="javascript:alert('time to edit employee');">Top Buyer</a></li>
		   <li><a href="javascript:alert('ssales report');">Top Representative</a></li>
		   <li><a href="javascript:alert('time to edit employee');">Get Revenue</a></li>
		 </ul>
	</div>
	
	<div id="flights-option" class="tab-pane fade">
		<ul>
		   <li><a href="javascript:alert('ssales report');">All Flights</a></li>
		   <li><a href="javascript:alert('time to edit employee');">Most Active Flights</a></li>
		   <li><a href="javascript:alert('ssales report');">Flight Roster</a></li>
		   <li><a href="javascript:alert('time to edit employee');">Flights by Airport</a></li>
		   <li><a href="javascript:alert('time to edit employee');">Flight Status</a></li>
		 </ul>
	</div>
	</div>
</div>
</div>
</html>