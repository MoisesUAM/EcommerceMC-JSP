<jsp:include page="/WEB-INF/templates/header.jsp">
    <jsp:param name="pageName" value="Personas | StoreMC"/>
</jsp:include>
<%@taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>

<div class="container">
    <div class="row">
        <h2 class="text-center text-dark-emphasis">Administracion / Registro de Personas</h2>
        <hr class="text-dark"/>
    </div>
    <div class="d-flex justify-content-center">
        <div class="container-sm">
            <div class="row">
                <div class="col-sm-8">
                    <div class="d-grid mb3">
                        <a role="button" href="persons-upsert" class="btn btn-outline-dark w-25"><i
                                class="bi bi-bag-plus"></i>&nbsp;Agregar</a>
                    </div>
                </div>
            </div>
            <hr class="text-danger">
            <div class="row">
                <table id="tblPersons"
                       class="cell-border compact stripe hover row-border">
                    <thead>
                    <tr class="text-center">
                        <th>DNI</th>
                        <th>Nombres</th>
                        <th>Apellidos</th>
                        <th>Fecha Nacimiento</th>
                        <th>Nacionalidad</th>
                        <th><i class="bi bi-gear-fill"></i> Acciones</th>
                    </tr>
                    </thead>
                </table>
            </div>
        </div>
    </div>
</div>

<jsp:include page="/WEB-INF/templates/footer.jsp">
    <jsp:param name="lessonName"
               value="Proyecto Ecommerce con Jakarta EE 10"/>
</jsp:include>
