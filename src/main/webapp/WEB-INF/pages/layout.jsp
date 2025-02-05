<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html lang="es">
<head>
<title>${pageParams.pageName}</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<link rel="shortcut icon" href="${pageContext.request.contextPath}/resources/images/main-icon.jpg" type="image/x-icon" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/main.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/cards-products.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/lib/sweetalert/sweetalert2.min.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/lib/bootstrap/bootstrap.min.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/lib/toastr/toastr.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/lib/Tables/datatables/media/css/jquery.dataTables.css" />
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/alerts-style.css" />
</head>
<body>
	<header>
		<jsp:include page="/WEB-INF/templates/header.jsp" />
	</header>
	<div class="row">
		<div class="d-flex">
			<jsp:include page="/WEB-INF/templates/sidebar.jsp" />
			<main class="content-main ps-3">
				<div class="row">
					<div class="col">
						<jsp:include page="${pageParams.contentPage}" />
					</div>
				</div>
			</main>
		</div>
	</div>
	<footer class="bg-dark sticky-bottom">
		<jsp:include page="/WEB-INF/templates/footer.jsp" />
	</footer>

	<div id="alertError" itemprop="${alerts.ERROR}"></div>
	<div id="alertSuccess" itemprop="${alerts.SUCCESS}"></div>
	<div id="alertWarning" itemprop="${alerts.WARNING}"></div>
	<div id="alertInfo" itemprop="${alerts.INFO}"></div>

	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/lib/jquery/jquery.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/lib/toastr/toastr.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/lib/Tables/datatables/media/js/jquery.dataTables.js"></script>
	<script type="application/javascript" src="${pageContext.request.contextPath}/resources/js/persons-functions.js"></script>
	<script type="application/javascript" src="${pageContext.request.contextPath}/resources/js/users-functions.js"></script>
	<script type="application/javascript" src="${pageContext.request.contextPath}/resources/js/roles-functions.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/lib/sweetalert/sweetalert2.all.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/lib/bootstrap/bootstrap.bundle.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/lib/moment/dist/moment.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/main.js"></script>
</body>
</html>