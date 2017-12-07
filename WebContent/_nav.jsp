<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ page import="filters.User" %>


<nav class="navbar navbar-inverse">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="/ReverseOreo/HomePage.jsp">Reverse Oreo</a>
        </div>
        <ul class="nav navbar-nav">
        <!-- <li class="active"><a href="#">Home</a></li>
        <li><a href="#">Help</a></li> -->
        </ul>
        <ul class="nav navbar-nav navbar-right">
        	<%
        	if(session !=null){
        		User user = (User) session.getAttribute("user");
        		if(user != null){
        			if(user.getRole().equals("Customer")){
        				%>
            			<li><span class="navbar-text"><font color="white"><%=user.getUsername()%></font></span></li> 
            			<li><a href="/ReverseOreo/Customer/Home.jsp"><span class="glyphicon glyphicon-cog"></span>Dashboard</a></li>
            			<li><a href="/ReverseOreo/Customer/Settings.jsp"><span class="glyphicon glyphicon-user"></span>Profile</a></li>
            			<li><a href="/ReverseOreo/Help.jsp"><span class="glyphicon glyphicon-flag"></span>Help</a></li>
            			<li><a href="/ReverseOreo/LogoutServlet"><span class="glyphicon glyphicon-log-out"></span>Log Out</a></li>
            			<%
        			} else if(user.getRole().equals("Employee")){
        				%>
            			<li><span class="navbar-text"><font color="white"><%=user.getUsername()%></font></span></li> 
            			<li><a href="/ReverseOreo/Employee/Home.jsp"><span class="glyphicon glyphicon-cog"></span>Dashboard</a></li>
            			<li><a href="/ReverseOreo/LogoutServlet"><span class="glyphicon glyphicon-log-out"></span>Log Out</a></li>
            			<%
        			} else if(user.getRole().equals("Manager")){
        				%>
            			<li><span class="navbar-text"><font color="white"><%=user.getUsername()%></font></span></li> 
            			<li><a href="/ReverseOreo/Employee/Home.jsp"><span class="glyphicon glyphicon-cog"></span>Dashboard</a></li>
            			<li><a href="/ReverseOreo/Manager/Home.jsp"><span class="glyphicon glyphicon-cog"></span>Manager Dashboard</a></li>
            			<li><a href="/ReverseOreo/LogoutServlet"><span class="glyphicon glyphicon-log-out"></span>Log Out</a></li>
            			<%
        			}
        			
        		} else {
        			%>
        			<li><a href="/ReverseOreo/signup.jsp"><span class="glyphicon glyphicon-user"></span>Sign Up</a></li>
        			<li><a href="/ReverseOreo/Help.jsp"><span class="glyphicon glyphicon-flag"></span>Help</a></li>
        			<%
        		}
        	}
        	%>
        	
            
            <!-- <li><a href="/ReverseOreo/login.jsp"><span class="glyphicon glyphicon-log-in"></span>Login</a></li> -->
            
        </ul>
    </div>
</nav>