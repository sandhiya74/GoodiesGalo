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
				<a class="navbar-brand" href="${cr2}/home.html"></a> <img
					src="img/logo1.png" width="60" height="50"
					class="d-inline-block align-top"></a>
				<div class="collapse navbar-collapse" id="collapse_target">
					<ul class="navbar-nav mr-auto">

						<li class="nav=item"><a class="nav-link" href="${cr2}/home"><h6>Home</h6></a></li>
						
						<li class="nav-item" ><a class="nav-link" href="${cr2}/category"><h6>ManageCategory</h6></a></li>
						
						<li class="nav-item" ><a class="nav-link" href="${cr2}/product"><h6>ManageProducts</h6></a></li>
						
						<li class="nav-item" ><a class="nav-link" href="${cr2}/allproducts"><h6>Products</h6></a></li>
						
						<li class="nav-item" ><a class="nav-link" href="${cr2}/login"><h6>Login</h6></a></li>
						
						<li class="nav-item" ><a class="nav-link" href="${cr2}/register"><h6>Registration</h6></a></li>
						
						<li class="nav-item " ><a class="nav-link" href="${cr2}/aboutus"><h6>AboutUs</h6></a></li>
						
						<li class="nav-item" ><a class="nav-link" href="${cr2}/contactus"><h6>ContactUs</h6></a></li>


					</ul>

					<form class="form-inline my-2 my-lg-0">
						<input class="form-control mr-sm-2" type="search"
							placeholder="Search" aria-label="Search">
						<button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
					</form>

				</div>
		</div>