<nav class="navbar bg-dark navbar-expand-lg fixed-top" data-bs-theme="dark">
    <div class="container-fluid">
        <a class="navbar-brand" href="${pageContext.request.contextPath}/">
            <img alt="Logo" style="width: 30px; height: 30px; border-radius: 5px;" src="${pageContext.request.contextPath}/resources/images/main-icon.jpg">
            &nbsp;Store MC
        </a>
        <button class="navbar-toggler text-white" type="button" data-bs-toggle="collapse" data-bs-target="#navbarScroll" aria-controls="navbarScroll" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarScroll">
            <ul class="navbar-nav me-auto my-2 my-lg-0 navbar-nav-scroll" style="--bs-scroll-height: 100px;">
                <!-- Menú de navegación -->
                <li class="nav-item"><a class="nav-link active" aria-current="page" href="main">Principal</a></li>
                <!-- Menús desplegables -->
                <!-- ... (código del menú) ... -->
            </ul>
            <div class="d-flex justify-content-around">
                <div class="text-white me-5">Hola! moises@gmail.com</div>
                <div class="text-white ms-5">
                    <a href="login" class="text-white link-offset-1-hover text-decoration-none"><i class="bi bi-person-bounding-box"></i>&nbsp;Login</a>
                    <a class="text-white" href="${pageContext.request.contextPath}/"><i class="bi bi-box-arrow-in-left"></i>&nbsp;Salir</a>
                </div>
            </div>
        </div>
    </div>
</nav>