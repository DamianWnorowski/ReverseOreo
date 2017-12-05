<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

<jsp:include page="_head.jsp"></jsp:include>  
<jsp:include page="_nav.jsp"></jsp:include>




<div class="container">
    <h1>Sign Up</h1>
    
    <form class="form-horizontal" action="SignUpServlet" method="post">
   
        <div class="form-group col-sm-6">
            <div class="col-sm-12">
                <label for="username">Username:</label>
                <input type="text" class="form-control" id="username" placeholder="Username" name="username">
            </div>
        </div>
        <div class="form-group col-sm-6">
            <div class="col-sm-12">
                <label for="userpassword">Password:</label> 
                <input type="password" class="form-control" id="userpassword" placeholder="Password" name="userpassword">
            </div>
        </div>
		<div class="form-group col-sm-6">	<!-- First name -->
		    <div class="col-sm-12">
		        <label for="fname">First Name:</label>
		        <input type="text" class="form-control" id="fname" placeholder="First Name" name="fname">
		    </div>
		</div>
		<div class="form-group col-sm-6">	<!-- Last Name -->
		    <div class="col-sm-12">
		        <label for="lname">Last Name:</label>
		        <input type="text" class="form-control" id="lname" placeholder="Last Name" name="lname">
		    </div>
		</div>
		<div class="form-group col-sm-6">	<!-- SSN -->
		    <div class="col-sm-12">
		        <label for="email">Email:</label>
		        <input type="text" class="form-control" id="email" placeholder="xxx-xx-xxxx" name="email">
		    </div>
		</div>
		<div class="form-group col-sm-6">	<!-- Phone num -->
		    <div class="col-sm-12">
		        <label for="phonenum">Phone Number:</label>
		        <input type="text" class="form-control" id="phonenum" placeholder="(123) 456-7890" name="phonenum">
		    </div>
		</div>
		
		<div class="form-group col-sm-6">
		<div class="col-sm-12">
		    <label for="address1">Address 1:</label>
		    <input type="text" class="form-control" id="address1" placeholder="" name="address1">
		</div>
		</div>
		
		<div class="form-group col-sm-6">
		<div class="col-sm-12">
		    <label for="city">City:</label>
		    <input type="text" class="form-control" id="city" placeholder="" name="city">
		</div>
		</div>
		
		<div class="form-group col-sm-6">
		<div class="col-sm-4">
		    <label for="state">State:</label>
		    <br></br>
		    <select name="state">
				<option value="AL">AL</option>
				<option value="AK">AK</option>
				<option value="AZ">AZ</option>
				<option value="AR">AR</option>
				<option value="CA">CA</option>
				<option value="CO">CO</option>
				<option value="CT">CT</option>
				<option value="DE">DE</option>
				<option value="DC">DC</option>
				<option value="FL">FL</option>
				<option value="GA">GA</option>
				<option value="HI">HI</option>
				<option value="ID">ID</option>
				<option value="IL">IL</option>
				<option value="IN">IN</option>
				<option value="IA">IA</option>
				<option value="KS">KS</option>
				<option value="KY">KY</option>
				<option value="LA">LA</option>
				<option value="ME">ME</option>
				<option value="MD">MD</option>
				<option value="MA">MA</option>
				<option value="MI">MI</option>
				<option value="MN">MN</option>
				<option value="MS">MS</option>
				<option value="MO">MO</option>
				<option value="MT">MT</option>
				<option value="NE">NE</option>
				<option value="NV">NV</option>
				<option value="NH">NH</option>
				<option value="NJ">NJ</option>
				<option value="NM">NM</option>
				<option value="NY">NY</option>
				<option value="NC">NC</option>
				<option value="ND">ND</option>
				<option value="OH">OH</option>
				<option value="OK">OK</option>
				<option value="OR">OR</option>
				<option value="PA">PA</option>
				<option value="RI">RI</option>
				<option value="SC">SC</option>
				<option value="SD">SD</option>
				<option value="TN">TN</option>
				<option value="TX">TX</option>
				<option value="UT">UT</option>
				<option value="VT">VT</option>
				<option value="VA">VA</option>
				<option value="WA">WA</option>
				<option value="WV">WV</option>
				<option value="WI">WI</option>
				<option value="WY">WY</option>
			</select>
		</div> 
		</div>
		<div class="col-sm-6">
		    <label for="zipcode">Zip Code:</label>
		    <input type="text" class="form-control" id="zipcode" placeholder="12345" name="zipcode">
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