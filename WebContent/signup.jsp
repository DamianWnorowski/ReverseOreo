<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

<jsp:include page="_head.jsp"></jsp:include>
    
<jsp:include page="_nav.jsp"></jsp:include>




<div class="container">
    <h1>Sign Up</h1>
    
    <form class="form-horizontal" action="/action_page.php">
        <div class="form-group col-sm-12">
            <div class="col-sm-6">
                <label for="Username">Username:</label>
                <input type="text" class="form-control" id="Username" placeholder="Username" name="Username">
            </div>
        </div>
        <div class="form-group col-sm-12">
            <div class="col-sm-6">
                <label for="Password">Password:</label> 
                <input type="text" class="form-control" id="Password" placeholder="Password" name="Password">
            </div>
        </div>
        <div class="form-group col-sm-12">
                <div class="col-sm-6">
                    <label for="Address">Address:</label> 
                    <input type="text" class="form-control" id="Address" placeholder="Address" name="Password">
                </div>
            </div>
        <div class="form-group col-sm-12">        
            <div class="col-sm-4">
                <button type="button" class="btn btn-default">Submit</button>
                <!-- <button type="submit" class="btn btn-default">Submit</button> -->
            </div>
        </div>    
    </form>

</div>


</html>