<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

<jsp:include page="_head.jsp"></jsp:include>
    
<jsp:include page="_nav.jsp"></jsp:include>




<div class="container">
    <h1>Sign Up</h1>
    
    <form class="form-horizontal" action="SignUpServlet" method="post">
   
        <div class="form-group col-sm-12">
            <div class="col-sm-6">
                <label for="username">Username:</label>
                <input type="text" class="form-control" id="username" placeholder="Username" name="username">
            </div>
        </div>
        <div class="form-group col-sm-12">
            <div class="col-sm-6">
                <label for="userpassword">Password:</label> 
                <input type="password" class="form-control" id="userpassword" placeholder="Password" name="userpassword">
            </div>
        </div>
        <div class="form-group col-sm-12">        
            <div class="col-sm-4">
                <button type="submit" value="Create" class="btn btn-default">Submit</button>
                <!-- <button type="submit" class="btn btn-default">Submit</button> -->
            </div>
        </div>    
    </form>

</div>


</html>