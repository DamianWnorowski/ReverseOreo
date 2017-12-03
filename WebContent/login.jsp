<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

<jsp:include page="_head.jsp"></jsp:include> 
<jsp:include page="_nav.jsp"></jsp:include>


<div class="container">
<h1>Log in</h1>

<div class="container">
	<div class="row">
	<div class="Absolute-Center is-Responsive ">
	
	<div class="col-sm-5 ">
    <div class="panel panel-default">
	<div class="panel-heading">
	    <h3>Customer</h3>
	</div>
	<div class="panel-body">
	    <form action="" id="loginForm">
	        <div class="form-group input-group">
	            <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
	            <input class="form-control" type="text" name='username' placeholder="username"/>          
	        </div>
	        <div class="form-group input-group">
	            <span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
	            <input class="form-control" type="password" name='password' placeholder="password"/>     
	        </div>
	    
	        <div class="form-group">
	            <button type="button" class="btn btn-def btn-block">Login</button>
	        </div>
	    </form>   
	</div>     
    </div>
	</div>  
	<div class="col-sm-1"></div>
	<div class="col-sm-5">
    <div class="panel panel-default">
	<div class="panel-heading">
	    <h3>Employee</h3>
	</div>
	<div class="panel-body">
	    <form action="" id="loginForm">
	        <div class="form-group input-group">
	            <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
	            <input class="form-control" type="text" name='username' placeholder="username"/>          
	        </div>
	        <div class="form-group input-group">
	            <span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
	            <input class="form-control" type="password" name='password' placeholder="password"/>     
	        </div>
	    
	        <div class="form-group">
	            <button type="button" class="btn btn-def btn-block">Login</button>
	        </div>
	    </form>        
	</div>
    </div>  
	</div>    
   	</div>
</div>
</div>
</div>

</html>