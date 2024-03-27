<%@taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>

<jsp:include page="/WEB-INF/templates/header.jsp">
    <jsp:param name="pageName" value="Usuarios Upsert | StoreMC"/>
</jsp:include>

<div class="d-flex justify-content-center">
    <div class="container-fluid">
        <div class="row">
            <h2 class="text-center text-dark-emphasis fw-bolder">Administracion / Registro de usuarios</h2>
        </div>
        <hr class="text-danger">
        <div class="d-flex justify-content-center">
            <div class="card border border-dark-subtle" style="min-width: 400px; max-width: 550px">
                <c:if test="${user.id == null}">
                    <div class="card-header">Agregar nuevo Usuario</div>
                </c:if>
                <c:if test="${user.id != null}">
                    <div class="card-header">Actualizar Usuarios</div>
                </c:if>
                <div class="card-body">
                    <form action="users-upsert" method="post" class="needs-validation" novalidate>
                        <input type="hidden" name="id" value="${user.id}">
                        <div class="mb-3">
                            <label for="userName" class="form-label">Nombre de Usuario</label>
                            <input type="text" class="form-control" id="userName" name="userName" required="true"
                                   value="${user.userName}"/>
                            <div class="invalid-feedback">El campo nombre de usuario es obligatorio</div>
                        </div>
                        <div class="mb-3 form-check form-switch">
                            <input type="checkbox" class="form-check-input" id="isActive" name="isActive"
                                   role="switch"/>
                            <label class="form-check-label" for="isActive">Estado Activo/Inactivo</label>
                            <div class="invalid-feedback">Debe indicar si el usuario es activo</div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>

<jsp:include page="/WEB-INF/templates/footer.jsp">
    <jsp:param name="lessonName"
               value="Proyecto Ecommerce con Jakarta EE 10"/>
</jsp:include>