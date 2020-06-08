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

.mytext {
	color: red;
	font-style: oblique;
}

.card-text {
	margin-top: 2%;
	max-height:200px;
}

.card-img-top {
	max-height: 120px;
	max-widht: 110px;
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

    <c:if test="${empty orderlist}">
      <div>No Active Orders</div>
    </c:if>

		<div class="row" style:"margin-top:10%">
			<c:forEach items="${orderlist}" var="p">
				<div class="col-12">
					<div class="card">
						<div class="card-body">
							<div class="row">
								<div class="col-3">
									<img src="${cr2}/pimg/${p.product_Details.pro_Id}.jpeg"
										class="card-img-top" />
								</div>
								<div class="col-4">
								<p class="card-title" data-toggle="tooltip"
									title="${p.product_Details.pro_Name}">${p.product_Details.pro_Name}</p>
							</div>
							<div class="col-3">
								<p class="card-text">
									Price: <span class="mytext">&#8377
										${p.product_Details.pro_Price}</span>
								</p>
							</div>
							<div class="col-3">
							<a class="btn btn-danger" href="${cr2}/user/viewdetails?oid=${p.order_Id }">ViewDetails</a>
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