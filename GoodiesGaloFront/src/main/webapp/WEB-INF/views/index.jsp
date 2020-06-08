<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
	integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
	crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"
	integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n"
	crossorigin="anonymous"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"
	integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6"
	crossorigin="anonymous"></script>
<body>
	<jsp:include page="navbar.jsp"></jsp:include>
	<div style="min-height: 500px;">
		<c:if test="${indexpage}">
			<jsp:include page="home.jsp"></jsp:include>
		</c:if>
		<c:if test="${contactuspage}">
			<jsp:include page="contactus.jsp"></jsp:include>
		</c:if>
		<c:if test="${aboutuspage}">
			<jsp:include page="aboutus.jsp"></jsp:include>
		</c:if>
		<c:if test="${loginpage}">
			<jsp:include page="login.jsp"></jsp:include>
		</c:if>
		<c:if test="${registerpage}">
			<jsp:include page="register.jsp"></jsp:include>
		</c:if>
		<c:if test="${categorypage}">
			<jsp:include page="category.jsp"></jsp:include>
		</c:if>
		<c:if test="${productpage}">
			<jsp:include page="product.jsp"></jsp:include>
		</c:if>
		<c:if test="${cust_productpage}">
			<jsp:include page="allproducts.jsp"></jsp:include>
		</c:if>
		<c:if test="${productdetails}">
			<jsp:include page="productdetails.jsp"></jsp:include>
		</c:if>
		<c:if test="${cartpage}">
			<jsp:include page="viewcart.jsp"></jsp:include>
		</c:if>
		<c:if test="${addresspage}">
			<jsp:include page="addresspage.jsp"></jsp:include>
		</c:if>
		<c:if test="${orderpage}">
			<jsp:include page="orderspage.jsp"></jsp:include>
		</c:if>
		<c:if test="${oneorderpage}">
			<jsp:include page="oneorderpage.jsp"></jsp:include>
		</c:if>

	</div>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>