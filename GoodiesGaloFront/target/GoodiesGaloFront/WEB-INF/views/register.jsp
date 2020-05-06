<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%><%@ taglib
	uri="http://www.springframework.org/tags/form" prefix="form"%>
<meta name="viewport" content="width=device-width, initial-scale=1">
<style>
body {
  font-family: Arial, Helvetica, sans-serif;
  background-image: url("images/wall6.jpg");
  margin-right: 250px;
  padding-left: 250px;
 
 }

* {
  box-sizing: border-box;
}

/* Add padding to containers */
.container {
 background:rgb(243, 193, 201);
	width:100%;
	max-width: 500px;
	margin:0 auto;
	padding: 20px;
	border-radius: 8px;
    border-style: solid;
  border-width: 5px;
  border-color:rgb(230, 87, 134);
  box-shadow: 0 0 0 0 !important;
  outline: 0 0 0 0  !important;
	    
   
}

/* Full-width input fields */
input[type=text], input[type=password] {
  width: 100%;
  padding: 15px;
  margin: 5px 0 22px 0;
  display: inline-block;
  border: none;
  background: #f1f1f1;
}

input[type=text]:focus, input[type=password]:focus {
  background-color: #ddd;
  outline: none;
}

/* Overwrite default styles of hr */
hr {
  border: 1px solid #f1f1f1;
  margin-bottom: 25px;
}

/* Set a style for the submit button */
.registerbtn {
  background-color: brown;
  color: white;
  padding: 16px 20px;
  margin: 8px 0;
  border: none;
  cursor: pointer;
  width: 100%;
  opacity: 0.9;
}

.registerbtn:hover {
  opacity: 1;
}



</style>
<body> 

  <c:if test="${info}">
		<div class="alert" role="alter">
			${message}
		</div>
	</c:if>
	
	

<form:form action="addcustomer" method="post" modelAttribute="customerobject">
  <div class="container">
    <p style="font-size:170%;font-family:algerian;text-align:center;"><ins>Register Page</ins></p>
    <hr>
    
    <label for="customername"><b  style="font-size:130%;"> Name</b></label>
    <form:input type="text" placeholder="Enter Your Name" name="customername" path="cust_Name"/>
    <form:errors path="cust_Name" cssstyle="color:red"></form:errors>
     

    <label for="email"><b>Email</b></label>
    <form:input type="text" placeholder="Enter Email" name="email" path="cust_Emailid"/>
    <form:errors path="cust_Emailid" cssstyle="color:red"></form:errors>

    <label for="number"><b>Contact Number</b></label>
    <form:input type="text" placeholder="Enter number" name="number"   path="cust_Phone"/>
     <form:errors path="cust_Phone" cssstyle="color:red"></form:errors>

    <label for="psw"><b> Password</b></label>
    <form:input type="password" placeholder=" Password" name="psw"      path="password"/>
     <form:errors path="password" cssstyle="color:red"></form:errors>
    <hr>
    

    <button type="submit" class="registerbtn">Register</button>
  </div>
  
  
</form:form>

</body>
