<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:if test="${role != 'client'}">
    <c:redirect url = "login.jsp"/>
</c:if>

<html>
<head>
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<meta name="description" content="" />
<meta name="author" content="" />
<title>Books Wander</title>
<!-- Favicon-->
<link rel="icon" type="image/x-icon" href="assets/favicon.ico" />
<!-- Font Awesome icons (free version)-->
<script src="https://use.fontawesome.com/releases/v5.15.4/js/all.js"
	crossorigin="anonymous"></script>
<!-- Google fonts-->
<link href="https://fonts.googleapis.com/css?family=Montserrat:400,700"
	rel="stylesheet" type="text/css" />
<link
	href="https://fonts.googleapis.com/css?family=Lato:400,700,400italic,700italic"
	rel="stylesheet" type="text/css" />
<!-- Core theme CSS (includes Bootstrap)-->
<link href="css/admin-styles.css" rel="stylesheet" />
</head>
<body id="page-top">
	<!-- Navigation-->
	<nav
		class="navbar navbar-expand-lg bg-secondary text-uppercase fixed-top"
		id="mainNav">
		<div class="container">
			<a class="navbar-brand" href="#page-top">Books Wander</a>
			<button
				class="navbar-toggler text-uppercase font-weight-bold bg-primary text-white rounded"
				type="button" data-bs-toggle="collapse"
				data-bs-target="#navbarResponsive" aria-controls="navbarResponsive"
				aria-expanded="false" aria-label="Toggle navigation">
				Menu <i class="fas fa-bars"></i>
			</button>
			<div class="collapse navbar-collapse" id="navbarResponsive">
				<ul class="navbar-nav ms-auto">
					<li class="nav-item mx-0 mx-lg-1"><a
						class="nav-link py-3 px-0 px-lg-3 rounded" href="home">Catalogue</a></li>
					<li class="nav-item mx-0 mx-lg-1"><a
						class="nav-link py-3 px-0 px-lg-3 rounded" href="CartServlet">Your Cart <i class="fas fa-shopping-cart"></i></a></li>
					<li class="nav-item mx-0 mx-lg-1"><a
						class="nav-link py-3 px-0 px-lg-3 rounded" href="LogoutServlet">Logout</a></li>
					<li class="nav-item mx-0 mx-lg-1"><a
						class="nav-link py-3 px-0 px-lg-3 rounded" href=""><%=session.getAttribute("username")%></a></li>
				</ul>
			</div>
		</div>
	</nav>
	<!-- Contact Section-->
	<section class="page-section" id="clients">
		<div class="container">
			<!-- Contact Section Heading-->
			<h2
				class="page-section-heading text-center text-uppercase text-secondary mb-0 mt-4">Orders</h2>
			<!-- Icon Divider-->
			<div class="divider-custom">
				<div class="divider-custom-line"></div>
				<div class="divider-custom-icon">
					<i class="fas fa-star"></i>
				</div>
				<div class="divider-custom-line"></div>
			</div>
			<c:choose><c:when test="${reservations.size() >= 1}">
			<table class="table table-bordered rounded">
  				<thead class="bg-primary text-white">
  				  <tr>
  				    <th>ID</th>
  				    <th>Start rent</th>
  				    <th>End rent</th>
  				    <th>State</th>
  				    <th>Action</th>
  				  </tr>
  				</thead>
  				<tbody>
					<c:forEach var="reservation" items="${reservations}">
						<tr>
							<td><c:out value="${reservation.id}" /></td>
							<td><c:out value="${reservation.start_rent}" /></td>
							<td><c:out value="${reservation.end_rent}" /></td>
							<td><c:out value="${reservation.state}" /></td>
                    <td class="bg-danger text-center">
  						<a href="DeleteOrder?reservationId=<c:out value='${reservation.id}'/>&bienId=<c:out value='${reservation.id_bien}'/>" class="delete-user-link">
    						<i class="fas fa-trash-alt trash-icon"></i>
  						</a>
					</td>
                </tr>
	</c:forEach>
  </tbody>
</table>
</c:when>
<c:otherwise>
	<h2 class="page-section-heading2 text-center text-uppercase text-secondary mb-0 mt-4">No reservations found !!</h2>
</c:otherwise>
</c:choose>
		</div>
	</section>
	<!-- Footer-->
	<footer class="footer text-center">
		<div class="container">
			<div class="row">
				
			</div>
		</div>
	</footer>
	<!-- Bootstrap core JS-->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
	<!-- Core theme JS-->
	<script src="js/scripts.js"></script>
	<!-- * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *-->
	<!-- * *                               SB Forms JS                               * *-->
	<!-- * * Activate your form at https://startbootstrap.com/solution/contact-forms * *-->
	<!-- * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *-->
	<script src="https://cdn.startbootstrap.com/sb-forms-latest.js"></script>
</body>
</html>
