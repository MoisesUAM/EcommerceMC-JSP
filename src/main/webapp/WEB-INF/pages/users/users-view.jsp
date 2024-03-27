<%@taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<jsp:include page="/WEB-INF/templates/header.jsp">
    <jsp:param name="pageName" value="Usuarios | StoreMC"/>
</jsp:include>

<div class="d-flex justify-content-center">
    <div class="container">
        <div class="row">
            <h2 class="text-center text-dark-emphasis fw-bolder">Administracion / Registro de usuarios</h2>
        </div>
        <hr class="text-danger">
        <div class="card border border-1 border-primary">
            <div class="card-header">Listado de Usuarios</div>
            <div class="card-body">
                <div class="row-cols-6 mb-3">
                    <a href="users-upsert" role="button" class="btn btn-outline-dark"><i
                            class="bi bi-person-add"></i>&nbsp;Agregar
                        Usuario</a>
                </div>
                <div class="table-responsive">
                    <table id="tblUsers" class="table table-striped table-hover">
                        <thead>
                        <tr>
                            <th class="text-center">Usuario</th>
                            <th class="text-center">Email</th>
                            <th class="text-center">Estado</th>
                            <th class="text-center">Contrasena</th>
                            <th class="text-center"><i class="bi bi-gear-fill"></i> Acciones</th>
                        </tr>
                        </thead>
                    </table>
                </div>
            </div>
        </div>
    </div>
</div>


<jsp:include page="/WEB-INF/templates/footer.jsp">
    <jsp:param name="lessonName"
               value="Proyecto Ecommerce con Jakarta EE 10"/>
</jsp:include>