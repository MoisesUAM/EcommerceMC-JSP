
<jsp:include page="/WEB-INF/templates/header.jsp">
	<jsp:param name="pageName" value="Bienvienido | StoreMC" />
</jsp:include>
<%@taglib prefix="c" uri="jakarta.tags.core"%>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt"%>


<div class="row">
	<div class="d-flex">
		<jsp:include page="/WEB-INF/templates/sidebar.jsp" />
		<main class="content-main">
			<div class="container-fluid">
				<div class="row">
					<h2 class="text-center text-dark-emphasis">Bienvenido a
						nuestra Tienda con los mejores productos del mercado!</h2>
					<hr class="text-danger" />
					<section class="section-products">
						<div class="container">
							<div class="row justify-content-center text-center">
								<div class="col-md-8 col-lg-6">
									<div class="header">
										<h3>Featured Product</h3>
										<h2>Popular Products</h2>
									</div>
								</div>
							</div>
							<div class="row">
								<!-- Single Product -->
								<div class="col-md-6 col-lg-4 col-xl-3">
									<div id="product-1" class="single-product">
										<div class="part-1">
											<ul>
												<li><a href="#"><i class="fas fa-shopping-cart"></i></a></li>
												<li><a href="#"><i class="fas fa-heart"></i></a></li>
												<li><a href="#"><i class="fas fa-plus"></i></a></li>
												<li><a href="#"><i class="fas fa-expand"></i></a></li>
											</ul>
										</div>
										<div class="part-2">
											<h3 class="product-title">Here Product Title</h3>
											<h4 class="product-old-price">$79.99</h4>
											<h4 class="product-price">$49.99</h4>
										</div>
									</div>
								</div>
								<!-- Single Product -->
								<div class="col-md-6 col-lg-4 col-xl-3">
									<div id="product-2" class="single-product">
										<div class="part-1">
											<span class="discount">15% off</span>
											<ul>
												<li><a href="#"><i class="fas fa-shopping-cart"></i></a></li>
												<li><a href="#"><i class="fas fa-heart"></i></a></li>
												<li><a href="#"><i class="fas fa-plus"></i></a></li>
												<li><a href="#"><i class="fas fa-expand"></i></a></li>
											</ul>
										</div>
										<div class="part-2">
											<h3 class="product-title">Here Product Title</h3>
											<h4 class="product-price">$49.99</h4>
										</div>
									</div>
								</div>
								<!-- Single Product -->
								<div class="col-md-6 col-lg-4 col-xl-3">
									<div id="product-3" class="single-product">
										<div class="part-1">
											<ul>
												<li><a href="#"><i class="fas fa-shopping-cart"></i></a></li>
												<li><a href="#"><i class="fas fa-heart"></i></a></li>
												<li><a href="#"><i class="fas fa-plus"></i></a></li>
												<li><a href="#"><i class="fas fa-expand"></i></a></li>
											</ul>
										</div>
										<div class="part-2">
											<h3 class="product-title">Here Product Title</h3>
											<h4 class="product-old-price">$79.99</h4>
											<h4 class="product-price">$49.99</h4>
										</div>
									</div>
								</div>
								<!-- Single Product -->
								<div class="col-md-6 col-lg-4 col-xl-3">
									<div id="product-4" class="single-product">
										<div class="part-1">
											<span class="new">new</span>
											<ul>
												<li><a href="#"><i class="fas fa-shopping-cart"></i></a></li>
												<li><a href="#"><i class="fas fa-heart"></i></a></li>
												<li><a href="#"><i class="fas fa-plus"></i></a></li>
												<li><a href="#"><i class="fas fa-expand"></i></a></li>
											</ul>
										</div>
										<div class="part-2">
											<h3 class="product-title">Here Product Title</h3>
											<h4 class="product-price">$49.99</h4>
										</div>
									</div>
								</div>
								<!-- Single Product -->
								<div class="col-md-6 col-lg-4 col-xl-3">
									<div id="product-1" class="single-product">
										<div class="part-1">
											<ul>
												<li><a href="#"><i class="fas fa-shopping-cart"></i></a></li>
												<li><a href="#"><i class="fas fa-heart"></i></a></li>
												<li><a href="#"><i class="fas fa-plus"></i></a></li>
												<li><a href="#"><i class="fas fa-expand"></i></a></li>
											</ul>
										</div>
										<div class="part-2">
											<h3 class="product-title">Here Product Title</h3>
											<h4 class="product-old-price">$79.99</h4>
											<h4 class="product-price">$49.99</h4>
										</div>
									</div>
								</div>
								<!-- Single Product -->
								<div class="col-md-6 col-lg-4 col-xl-3">
									<div id="product-2" class="single-product">
										<div class="part-1">
											<span class="discount">15% off</span>
											<ul>
												<li><a href="#"><i class="fas fa-shopping-cart"></i></a></li>
												<li><a href="#"><i class="fas fa-heart"></i></a></li>
												<li><a href="#"><i class="fas fa-plus"></i></a></li>
												<li><a href="#"><i class="fas fa-expand"></i></a></li>
											</ul>
										</div>
										<div class="part-2">
											<h3 class="product-title">Here Product Title</h3>
											<h4 class="product-price">$49.99</h4>
										</div>
									</div>
								</div>
								<!-- Single Product -->
								<div class="col-md-6 col-lg-4 col-xl-3">
									<div id="product-3" class="single-product">
										<div class="part-1">
											<ul>
												<li><a href="#"><i class="fas fa-shopping-cart"></i></a></li>
												<li><a href="#"><i class="fas fa-heart"></i></a></li>
												<li><a href="#"><i class="fas fa-plus"></i></a></li>
												<li><a href="#"><i class="fas fa-expand"></i></a></li>
											</ul>
										</div>
										<div class="part-2">
											<h3 class="product-title">Here Product Title</h3>
											<h4 class="product-old-price">$79.99</h4>
											<h4 class="product-price">$49.99</h4>
										</div>
									</div>
								</div>
								<!-- Single Product -->
								<div class="col-md-6 col-lg-4 col-xl-3">
									<div id="product-4" class="single-product">
										<div class="part-1">
											<span class="new">new</span>
											<ul>
												<li><a href="#"><i class="fas fa-shopping-cart"></i></a></li>
												<li><a href="#"><i class="fas fa-heart"></i></a></li>
												<li><a href="#"><i class="fas fa-plus"></i></a></li>
												<li><a href="#"><i class="fas fa-expand"></i></a></li>
											</ul>
										</div>
										<div class="part-2">
											<h3 class="product-title">Here Product Title</h3>
											<h4 class="product-price">$49.99</h4>
										</div>
									</div>
								</div>
							</div>
						</div>
					</section>
				</div>
			</div>
		</main>
	</div>
</div>
<jsp:include page="/WEB-INF/templates/footer.jsp">
	<jsp:param name="lessonName"
		value="Proyecto Ecommerce con Jakarta EE 10" />
</jsp:include>