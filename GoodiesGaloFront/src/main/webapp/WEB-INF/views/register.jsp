<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%><%@ taglib
	uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<style>
body {
    font-family: Arial, Helvetica, sans-serif;
    background-image: url("img/wall2.jpg");
}

* {
    box-sizing: border-box;
    
}

/* Add padding to containers */
.container {
    padding: 16px;
   
   border: 2px solid red;
  border-radius: 8px;
  border-color:brown;
  border-width:5px;
  background-color:pink;
  
    
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
    border: 1px solid brown;
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

/* Add a blue text color to links */
a {
    color: dodgerblue;
}

/* Set a grey background color and center the text of the "sign in" section */
.signin {
    background-color: #f1f1f1;
    text-align: center;
}
</style>
</head>
<body>
<c:if test="${info}">
		<div class="alert alert-success">
			${message}
		</div>
	</c:if>

<div style="width:50%;height:50%;margin-left:25%;">
 <div class="col-12" style="margin-top: 1%">

<form:form action="addcustomer" method="post" modelAttribute="customerobject">
  <div class="container">
    <h1 style="text-align:center">Register</h1>
    <p> To create an account.</p>
    <hr>
    
     <label for="name"><b style="font-size:130%;">Name</b></label>
    <form:input type="text" placeholder="Enter Name" name="name" path="cust_Name"/>
    <form:errors path="cust_Name" cssStyle="color:Red"></form:errors><br>


    <label for="email"><b style="font-size:130%;">Email</b></label>
    <form:input type="text" placeholder="Enter Email" name="email" path="cust_Emailid"/>
     <form:errors path="cust_Emailid" cssStyle="color:Red"></form:errors><br>
     
     <label for="number"><b style="font-size:130%;">Contact Number</b></label>
    <form:input type="text" placeholder="Enter Number" name="number" path="cust_Phone"/>
     <form:errors path="cust_Phone" cssStyle="color:Red"></form:errors><br>
     
    <label for="psw"><b style="font-size:130%;">Password</b></label>
    <form:input type="password" placeholder="Enter Password" name="psw" path="cust_Password"/>
    <form:errors path="cust_Password" cssStyle="color:Red"></form:errors><br>

   
    <hr>
    

    <button type="submit" class="registerbtn">Register</button>
     
  </div>
  
 
</form:form>
</div>
</div>

</body>


</html>
