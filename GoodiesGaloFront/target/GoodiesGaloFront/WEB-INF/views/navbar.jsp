<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="script" href="js/jquery-3.4.1.min">
<link rel="script" href="js/bootstrap.min.js">
<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>	
<c:set var="cr2" value="${pageContext.request.contextPath}" />
</head>
<style>
.div li {
	font-size: 80%;
}
</style>
<body>

	<div class="container-fluide">
		<div class="navbar-header">

			<nav class="navbar navbar-expand-sm navbar-light"
				style="background-color: rgb(231, 120, 138)";>

				<button class="navbar-toggler" data-toggle="collapse"
					data-target="#collapse_target">
					<span class="navbar-toggler-icon"></span>
				</button>
				
				<img src="${cr2}/img/logo1.png" width="60" height="50"
					class="d-inline-block align-top"></a>
				<div class="collapse navbar-collapse" id="collapse_target">
					<c:choose>
					<c:when test="${adminrole}">
					<ul class="navbar-nav mr-auto">

			<li class="nav=item"><a class="nav-link" href="${cr2}/home"><h6>Home</h6></a></li>
						
			<li class="nav-item" ><a class="nav-link" href="${cr2}/admin/category"><h6>ManageCategory</h6></a></li>
						
			<li class="nav-item" ><a class="nav-link" href="${cr2}/admin/product"><h6>ManageProducts</h6></a></li>
						
						
			<li class="nav-item " ><a class="nav-link" href="${cr2}/aboutus"><h6>AboutUs</h6></a></li>
						
			<li class="nav-item" ><a class="nav-link" href="${cr2}/contactus"><h6>ContactUs</h6></a></li>

            <li class="nav-item" >Hi ${sessionScop.username }<a class="nav-link" href=""><h6>Logout</h6></a></li>

					</ul>
					
					
					</c:when>
					<c:when test="${userrole }">
					</c:when>
					<c:otherwise>
			<li class="nav=item"><a class="nav-link" href="${cr2}/home"><h6>Home</h6></a></li>
						
			<li class="nav-item" ><a class="nav-link" href="${cr2}/allproduct"><h6>Products</h6></a></li>
			
			<li class="nav-item " ><a class="nav-link" href="${cr2}/aboutus"><h6>AboutUs</h6></a></li>
			
		    <li class="nav-item" ><a class="nav-link" href="${cr2}/contactus"><h6>ContactUs</h6></a></li>
		    
			 <li class="nav-item" ><a class="nav-link" href="login"><h6>Login</h6></a></li>
			 
			  <li class="nav-item" ><a class="nav-link" href="${cr2}/register"><h6>Register</h6></a></li>
					
					
					</c:otherwise>
					</c:choose>
					<form class="form-inline my-2 my-lg-0">
						<input class="form-control mr-sm-2" type="search"
							placeholder="Search" aria-label="Search">
						<button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
					</form>

				</div>
		</div>