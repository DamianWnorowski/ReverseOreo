<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<script language="javascript" type="text/javascript">
$(document).ready(function(){
    //  When user clicks on tab, this code will be executed
    $("nav nav-pills li").click(function() {
        //  First remove class "active" from currently active tab
        $("nav nav-pills li").removeClass('active');

        //  Now add class "active" to the selected/clicked tab
        $(this).addClass("active");

        //  Hide all tab content
        $("display:none").hide();

        //  Here we get the href value of the selected tab
        var selected_tab = $(this).find("a").attr("href");

        //  Show the selected tab content
        $(selected_tab).fadeIn();

        //  At the end, we add return false so that the click on the link is not executed
        return false;
    });
});
</script>

<html>
<jsp:include page="_head.jsp"></jsp:include>
<jsp:include page="_nav.jsp"></jsp:include>

<div class="container">
<div class="panel panel-default">
	<div class="panel-heading">
		<ul class="nav nav-pills">
		   <li class="active"><a href="#employee-option">Employees</a></li>
		   <li><a href="EmployeeListServlet">Sales</a></li>
		   <li><a href="#flights-option">Flights</a></li>
		 </ul>
	</div>
	
	<div id="employee-option" class="managertabs">
	
	</div>
	
	<div id="sales-option" class="managertabs">
	</div>
	
	<div id="flights-option" class="managertabs">
	</div>
	
</div>
</div>
</html>