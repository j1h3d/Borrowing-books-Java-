<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:if test="${role != 'client'}">
    <c:redirect url = "login.jsp"/>
</c:if>

<%@ page import="java.util.List" %>
<%@ page import="beans.Categorie" %>


<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8" />
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
<link href="css/index-styles.css" rel="stylesheet" />
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
						class="nav-link py-3 px-0 px-lg-3 rounded" href="#categories">Catalogue</a></li>
					<li class="nav-item mx-0 mx-lg-1"><a
						class="nav-link py-3 px-0 px-lg-3 rounded" href="CartServlet">Your Cart <i class="fas fa-shopping-cart"></i></a></li>
					<li class="nav-item mx-0 mx-lg-1"><a
						class="nav-link py-3 px-0 px-lg-3 rounded" href="LogoutServlet">Logout</a></li>
					<li class="nav-item mx-0 mx-lg-1"><a
						class="nav-link py-3 px-0 px-lg-3 rounded" href="ProfileEditServlet"><%=session.getAttribute("username")%></a></li>
				</ul>
			</div>
		</div>
	</nav>
	<!-- Portfolio Section-->
	<section class="page-section portfolio" id="categories">
		<div class="container">
			<!-- Portfolio Section Heading-->
			<h2
				class="page-section-heading text-center text-uppercase text-secondary mb-0 mt-4">Categories</h2>
			<!-- Icon Divider-->
			<div class="divider-custom">
				<div class="divider-custom-line"></div>
				<div class="divider-custom-icon">
					<i class="fas fa-star"></i>
				</div>
				<div class="divider-custom-line"></div>
			</div>
			<!-- Portfolio Grid Items-->
			<%
            List<Categorie> categories = (List<Categorie>) request.getAttribute("categories");
			if (categories!=null){
            	 %>
			<div class="row justify-content-center">
			<%for (Categorie category : categories) { %>
				<!-- Portfolio Item 1-->
				<div class="col-md-6 col-lg-4 mb-5">
					<div class="portfolio-item mx-auto" data-bs-toggle="modal"
						data-bs-target="#portfolioModal<%= category.getId()%>">
						<div
							class="portfolio-item-caption d-flex align-items-center justify-content-center h-100 w-100">
							<div
								class="portfolio-item-caption-content text-center text-white">
								<i class="fas fa-eye fa-3x"></i>
							</div>
						</div>
						<img class="img-fluid" src="<%= category.getCat_image()%>"
							alt="..." />
					</div>
				</div>
				
				<div class="portfolio-modal modal fade" id="portfolioModal<%= category.getId()%>"
					tabindex="-1" aria-labelledby="portfolioModal<%= category.getId()%>" aria-hidden="true">
					<div class="modal-dialog modal-xl">
						<div class="modal-content">
							<div class="modal-header border-0">
								<button class="btn-close" type="button" data-bs-dismiss="modal"
									aria-label="Close"></button>
							</div>
							<div class="modal-body text-center pb-5">
								<div class="container">
									<div class="row justify-content-center">
										<div class="col-lg-6">
											<!-- Portfolio Modal - Title-->
											<h3
												class="portfolio-modal-title text-secondary text-uppercase mb-0"><%= category.getCategory_name()%></h3>
											<!-- Icon Divider-->
											<div class="divider-custom">
									<div class="divider-custom-line"></div>
									<div class="divider-custom-icon">
										<i class="fas fa-star"></i>
									</div>
							  				<div class="divider-custom-line"></div>
						  				</div>
						  				<!-- Portfolio Modal - Image-->
					  					<img class="img-fluid rounded mb-5"
					  						src="<%= category.getCat_image()%>" alt="..." />
					  					<!-- Portfolio Modal - Text-->
					  						<p class="mb-4"><%= category.getDescription()%></p>
					  						<a class="btn btn-primary" href="DiscoverBooksServlet?categoryId=<%= category.getId() %>"
					  							>Discover <%= category.getCategory_name()%> books
					  						</a>
				  						</div>
			  						</div>
			  					</div>
		  					</div>
		  				</div>
	  				</div>
				</div>
				<% } %>
			</div>
			<% } %>
			
		</div>
	</section>
	
	
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
