<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%><%@ taglib
	uri="http://www.springframework.org/tags/form" prefix="form"%>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
  <c:set var="cr2" value="${pageContext.request.contextPath}" />
<style>
body {
	font-family: Calibri;
	background-color: white;
}

* {
	box-sizing: border-box;
}
/* Add padding to containers */
.container {
	padding: 16px;
	background-color: white;
}
/* Full-width input fields */
input[type=text] {
	width: 100%;
	padding: 10px;
	margin: 5px 0 22px 0;
	display: inline-block;
	border: none;
	background: #f1f1f1;
	font-size: 100%;
}

input[type=text]:focus, input[type=password]:focus, input[type=email]:focus,
	input[type=tel]:focus {
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
	padding: 4px 8px;
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
	color: brown;
}
/* Set a grey background color and center the text of the "sign in" section */
.signin {
	background-color: pink;
	text-align: center;
}
table {
	width: 100%;
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
		<c:if test="${edit}">
				<c:set var="url" value="${cr2}/admin/updatecategory"></c:set>
			</c:if>
			<c:if test="${!edit}">
				<c:set var="url" value="${cr2}/admin/addcategory"></c:set>
			</c:if>
			
		<form:form action="${url}" method="post" modelAttribute="categoryobject">
		<c:if test="${edit}">
					<form:hidden id="inputEmail" class="form-control"
						placeholder="category " path="cat_Id" />
						</c:if>
				
			<div class="container">
				<p
					style="font-size: 170%; font-family: algerian; text-align: center;">
					<ins>Categories</ins>
				</p>
				<p style="font-size: 130%;">Please Enter The Category Details.</p>
				<hr>
				
				<label for="category_Name"><b style="font-size: 140%;">Category
						Name</b></label>
				<form:input type="text" placeholder="Enter The Category Name" name="category_Name" path="cat_Name" />
				<form:errors path="cat_Name" cssstyle="color:red"></form:errors>
				<button type="submit" class="registerbtn" style="font-size: 120%;">Submit</button>
				<br> <br>
				<hr>
			</div>
		</form:form>
	</div>
	
	<div class="row" style="margin-bottom: 3%;">
			<div class="table-responsive table-bordered movie-table">
				<table class="table movie-table">
					
						<tr class="movie-table-head">
							<th>Category Id</th>
							<th>Category Name</th>
							<th>Edit/Delete</th>
						</tr>
					
					
						<c:forEach items="${categorylist}" var="c">
							<tr>
								<td>${c.cat_Id}</td>
								<td>${c.cat_Name}</td>
								 <td>
								 <div class="row">
								 <div class="col-6">
								 <a href="${cr2}/admin/deletecategory?catname=${c.cat_Name }" class="btn btn-danger">Delete</a>
								 </div>
								 <div class="col-6">
								 <a href="${cr2}/admin/getdatatoedit?catname=${c.cat_Name }" class="btn btn-success">Edit</a>
								 </div>
								 </div>
								 </td>

							</tr>
						</c:forEach>
				
				</table>
			</div>
		</div>
		