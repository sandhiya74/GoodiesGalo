<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="cr2" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<script>
	$(document).ready(function() {
		$('[data-toggle="tooltip"]').tooltip();
	});
</script>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<style>

.card {
	margin-top: 3%;
	height: 350px;
}

.mytext
{
color: red;
font-style: oblique;
}

.card-text
{
   margin-top: 2%;
}

.card-img-top {
	height: 150px;
	widht: 150px;
}

.card-title {
	white-space: nowrap;
	text-overflow: ellipsis;
	overflow: hidden;

}

</style>
</head>
<body>


	<div class="container">

		<div class="row">
			<c:forEach items="${productlist}" var="p">
				<div class="col-3">
					<div class="card"> 
						<img src="${cr2}/pimg/${p.pro_Id}.jpeg" class="card-img-top" />
						<div class="card-body">
							<div class="col-12">
								<p class="card-title" data-toggle="tooltip"
									title="${p.pro_Name}">${p.pro_Name}</p>
							</div>
								<div class="col-12">
									<p class="card-text">
										Price:  <span class="mytext">&#8377 ${p.pro_Price}</span>
									</p>
								</div>
								<div class="col-12">
									<c:if test="${p.pro_Stock > 5}">
										<p class="card-text">
											Stock:<span class="mytext">  In Stock</span>
										</p>
									</c:if>
									<c:if test="${p.pro_Stock < 5 }">
										<p class="card-text">
											Stock:<span class="mytext">  Only  ${p.pro_Stock}  Available</span>
										</p>
									</c:if>
								</div>

							<div class="row">
								<div class="col-6">
									<a href="${cr2}/addtocart?productid=${p.pro_Id}" class="btn btn-success" style="background-color: rgb(231, 120, 138)">Add to cart</a>
								</div>
								<div class="col-6">
									<a href="${cr2}/productdetails?prodid=${p.pro_Id}" class="btn btn-warning"  style="background-color: brown">View Details</a>
								</div>
							</div>
						</div>
					</div>
				</div>
			</c:forEach>
		</div>

	</div>


</body>
</html>