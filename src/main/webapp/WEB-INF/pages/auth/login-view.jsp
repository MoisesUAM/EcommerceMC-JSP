
<%@taglib prefix="c" uri="jakarta.tags.core"%>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt"%>

<div class="container-fluid">
	<div class="row">
		<h2 class="text-center text-dark-emphasis">Bienvenido a nuestra Tienda con los mejores productos del mercado!</h2>
		<hr class="text-danger" />
		<section>
			<div class="container">
				<div class="row">
					<div class="col-sm-12 col-md-6">
						<div class="card border border-2 border-warning" style="min-width: 90%;">
							<div class="card-header bg-dark ">
								<h4 class="text-center text-white fw-bolder">Iniciar Sesión</h4>
							</div>
							<div class="card-body">
								<form action="login" class="needs-validation" method="post" novalidate>
									<div class="mb-3">
										<label for="username" class="form-label">Usuario | Email</label> <input type="text" class="form-control" id="username" name="username"
											placeholder="Ingresa tu usuario o email" required>
										<div class="invalid-feedback">Por favor ingresa tu usuario o email</div>
									</div>
									<div class="mb-3">
										<label for="password" class="form-label">Contraseña</label> <input type="password" class="form-control" id="password" name="password"
											placeholder="Ingresa tu contraseña" required>
										<div class="invalid-feedback">Por favor ingresa tu contraseña</div>
									</div>
									<hr class="text-danger" />
									<div class="mb-3">
										<button type="submit" class="btn btn-outline-dark">
											<i class="bi bi-arrow-right"></i>&nbsp; Iniciar Sesión
										</button>
									</div>
								</form>
							</div>
						</div>

					</div>
					<div class="col-sm-12 col-md-6"></div>
				</div>
			</div>
		</section>
	</div>
</div>
