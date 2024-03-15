<%@taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title><%=request.getParameter("pageName")%>
    </title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <link rel="shortcut icon" href="resources/images/main-icon.jpg"
          type="image/x-icon"/>
    <link rel="stylesheet" href="resources/css/main.css"/>
    <link rel="stylesheet" href="resources/css/cards-products.css"/>
    <link rel="stylesheet" href="resources/lib/sweetalert/sweetalert2.min.css"/>
    <link rel="stylesheet" href="resources/lib/bootstrap/bootstrap.min.css"/>
    <link rel="stylesheet" href="resources/lib/toastr/toastr.css"/>
    <link rel="stylesheet"
          href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css"/>
</head>
<body>
<header>
    <nav class="navbar bg-dark navbar-expand-lg fixed-top" data-bs-theme="dark">
        <div class="container-fluid">
            <a class="navbar-brand" href="${pageContext.request.contextPath}/"><img alt="Logo"
                                                                                    style="width: 30px; height: 30px; border-radius: 5px;"
                                                                                    src="resources/images/main-icon.jpg">
                &nbsp;Store MC</a>
            <button class="navbar-toggler text-white" type="button"
                    data-bs-toggle="collapse" data-bs-target="#navbarScroll"
                    aria-controls="navbarScroll" aria-expanded="false"
                    aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarScroll">
                <ul class="navbar-nav me-auto my-2 my-lg-0 navbar-nav-scroll"
                    style="--bs-scroll-height: 100px;">
                    <li class="nav-item"><a class="nav-link active"
                                            aria-current="page" href="main">Principal</a></li>
                    <!-- Menu administracion -->
                    <li class="nav-item dropdown"><a
                            class="nav-link dropdown-toggle" role="button"
                            data-bs-toggle="dropdown" aria-expanded="false">Administracion</a>
                        <ul class="dropdown-menu">
                            <li><a class="dropdown-item" href="#"><i
                                    class="bi bi-building-gear"></i>&nbsp;Empresas</a></li>
                            <li>
                                <hr class="dropdown-divider text-danger">
                            </li>
                            <li><a class="dropdown-item" href="#"><i
                                    class="bi bi-shop-window"></i>&nbsp;Almacenes</a></li>
                            <li><a class="dropdown-item" href="#"><i
                                    class="bi bi-buildings"></i>&nbsp;Departamentos</a></li>
                            <li><a class="dropdown-item" href="#"><i
                                    class="bi bi-tags"></i>&nbsp;Categorias</a></li>
                            <li><a class="dropdown-item" href="#"><i
                                    class="bi bi-c-circle"></i>&nbsp;Marcas</a></li>
                            <li><a class="dropdown-item" href="#"><i
                                    class="bi bi-upc-scan"></i>&nbsp;Productos</a></li>
                        </ul>
                    </li>
                    <!-- fin menu administracion -->
                    <!-- Menu Transacciones -->
                    <li class="nav-item dropdown"><a
                            class="nav-link dropdown-toggle" role="button"
                            data-bs-toggle="dropdown" aria-expanded="false">Transacciones</a>
                        <ul class="dropdown-menu">
                            <li><a class="dropdown-item" href="#"><i class="bi bi-receipt"></i>&nbsp;Ordenes de
                                Compra</a></li>
                            <li>
                                <hr class="dropdown-divider text-danger">
                            </li>
                            <li><a class="dropdown-item" href="#"><i class="bi bi-node-minus"></i>&nbsp;Recepcion de
                                Productos</a></li>
                            <li><a class="dropdown-item" href="#"><i class="bi bi-bezier2"></i>&nbsp;Recuentos</a></li>
                            <li><a class="dropdown-item" href="#"><i class="bi bi-calendar2-range"></i>&nbsp;Movimientos</a>
                            </li>
                            <li><a class="dropdown-item" href="#"><i class="bi bi-arrow-left-right"></i>&nbsp;Transferencias</a>
                            </li>
                            <li><a class="dropdown-item" href="#"><i class="bi bi-sliders2-vertical"></i>&nbsp;Miscelanios</a>
                            </li>
                        </ul>
                    </li>
                    <!-- fin menu administracion -->
                    <!-- Menu administracion -->
                    <li class="nav-item dropdown"><a
                            class="nav-link dropdown-toggle" role="button"
                            data-bs-toggle="dropdown" aria-expanded="false">Acceso</a>
                        <ul class="dropdown-menu">
                            <li><a class="dropdown-item" href="#"><i class="bi bi-toggles"></i>&nbsp;Roles</a></li>
                            <li>
                                <hr class="dropdown-divider text-danger">
                            </li>
                            <li><a class="dropdown-item" href="#"><i class="bi bi-people-fill"></i>&nbsp;Usuarios</a>
                            </li>
                        </ul>
                    </li>
                    <!-- fin menu administracion -->
                </ul>
                <div class="d-flex justify-content-around">
                    <div class="text-white me-5">Hola! moises@gmail.com</div>
                    <div class="text-white ms-5">
                        <a class="text-white" href="${pageContext.request.contextPath}/"><i
                                class="bi bi-box-arrow-in-left"></i>&nbsp;Salir</a>
                    </div>
                </div>
            </div>
        </div>
    </nav>
</header>