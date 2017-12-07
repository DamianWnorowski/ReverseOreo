<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<html>
<script>
	function getEmailList() {
		var url = "MailingList.jsp";
		var xhttp = new XMLHttpRequest();
		xhttp.onreadystatechange = function() {
			if (this.readyState == 4 && this.status == 200) {
				$('body').find('#mailinglist').html(this.responseText);
			}
		};
		xhttp.open("GET", url, true);
		xhttp.send();
	}
	
	function getEditCustomer() {
		var url = "EditCustomer.jsp";
		var xhttp = new XMLHttpRequest();
		xhttp.onreadystatechange = function() {
			if (this.readyState == 4 && this.status == 200) {
				$('body').find('#editcustomers').html(this.responseText);
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
			<ul class="nav nav-pills">
			
				<li class="active"><a data-toggle="pill" href="#reservation">Record Reservation</a></li>
			   	<li><a data-toggle="pill" data-target="#editcustomers" onclick="getEditCustomer()">Edit Customers</a></li>
			   	<li><a data-toggle="pill" data-target="#mailinglist" onclick="getEmailList()">Customer Mailing List</a></li>
			   	<li><a data-toggle="pill" href="#flightsuggestions">Flight Suggestions</a></li>
			 </ul>
		</div>
		<div class="panel-body tab-content">
			<div id="reservation" class="tab-pane fade in active">
				<jsp:include page="RecordReservation.jsp"></jsp:include>
			</div>
			<div id="editcustomers" class="tab-pane fade"></div>
		
			<div id="mailinglist" class="tab-pane fade"></div>
			
			<div id="flightsuggestions" class="tab-pane fade">
				
			</div>
		</div>			
	</div>
</div>
</html>