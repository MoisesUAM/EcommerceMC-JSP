<%@taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<jsp:include page="/WEB-INF/templates/header.jsp">
    <jsp:param name="pageName" value="Roles | StoreMC"/>
</jsp:include>

<div class="d-flex justify-content-center">
    <div class="container">
        <div class="row">
            <h2 class="text-center text-dark-emphasis fw-bolder">Administracion / Roles de Usuario</h2>
        </div>
        <hr class="text-danger">
        <div class="card border border-1 border-primary">
            <div class="card-header">Listado de Roles</div>
            <div class="card-body">
                <div class="row-cols-6 mb-3">
                    <button type="button" class="btn btn-outline-dark" data-bs-toggle="modal"
                            data-bs-target="#roleAddModal"><i
                            class="bi bi-person-add"></i>&nbsp;Agregar
                        Role
                    </button>
                </div>
                <div class="table-responsive">
                    <table id="tblUsers" class="table table-striped table-hover">
                        <thead>
                        <tr>
                            <th class="text-center">Nombre de Rol</th>
                            <th class="text-center">Estado</th>
                            <th class="text-center"><i class="bi bi-gear-fill"></i> Acciones</th>
                        </tr>
                        </thead>
                    </table>
                </div>
            </div>
        </div>
    </div>
</div>

<!-- Modal -->
<div class="modal fade" id="roleAddModal" tabindex="-1" aria-labelledby="roleAddModalLabel" aria-hidden="true">
<div class="modal-dialog modal-dialog-centered">
    <div class="modal-content">
        <div class="modal-header">
            <h1 class="modal-title fs-5" id="roleAddModalLabel">Agregar Rol</h1>
            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
        </div>
        <div class="modal-body">
            <div class="row">
                <div class="col-12">
                    <label for="roleName" class="form-label">Nombre de Rol</label>
                    <input type="text" class="form-control" id="roleName" name="roleName">
                </div>
            </div>
        </div>
        <div class="modal-footer">
            <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cancelar</button>
            <button type="button" class="btn btn-primary" onclick="addRole()">Guardar</button>
        </div>
    </div>
</div>
<jsp:include page="/WEB-INF/templates/footer.jsp">
    <jsp:param name="lessonName"
               value="Proyecto Ecommerce con Jakarta EE 10"/>
</jsp:include>