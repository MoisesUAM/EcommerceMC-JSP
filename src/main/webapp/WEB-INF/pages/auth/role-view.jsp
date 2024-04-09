<%@taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<jsp:include page="/WEB-INF/templates/header.jsp">
    <jsp:param name="pageName" value="Roles | StoreMC"/>
</jsp:include>
<div class="container">
    <div class="row">
        <h2 class="text-center text-dark-emphasis fw-bolder">Administracion / Registro de Roles</h2>
    </div>
    <hr class="text-danger"/>
</div>
<div class="d-flex justify-content-center">
    <div class="container-sm">
        <div class="row-cols-6 mb-3">
            <button type="button" class="btn btn-outline-dark" data-bs-toggle="modal"
                    data-bs-target="#roleAddModal"><i
                    class="bi bi-person-add"></i>&nbsp;Agregar
                Role
            </button>
        </div>
        <hr class="text-danger">
        <div class="row">
            <div class="table-responsive">
                <table id="tblRoles" class="table table-striped table-hover">
                    <thead>
                    <tr>
                        <th class="text-center">Nombre de Rol</th>
                        <th class="text-center">Descripción</th>
                        <th class="text-center">Estado</th>
                        <th class="text-center"><i class="bi bi-gear-fill"></i> Acciones</th>
                    </tr>
                    </thead>
                </table>
            </div>
        </div>
    </div>
</div>

<!-- Modal -->
<div class="modal fade" id="roleAddModal" tabindex="-1" aria-labelledby="roleAddModalLabel" aria-hidden="true">
<div class="modal-dialog modal-dialog-centered">
    <div class="modal-content">
        <div class="modal-header bg-dark">
            <h1 class="modal-title fs-5 text-light" id="roleAddModalLabel">Agregar Rol</h1>
            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
        </div>
        <div class="modal-body">
            <div class="row">
                <form action="role" method="post" class="needs-validation" novalidate>
                    <input type="hidden" id="roleId" name="roleId"/>
                    <div class="col-12">
                        <div class="mb-3">
                            <label for="roleName" class="form-label">Nombre de Rol</label>
                            <input type="text" class="form-control" id="roleName" name="roleName" required/>
                            <div class="invalid-feedback">El campo nombre de rol es obligatorio</div>
                        </div>
                        <div class="mb-3">
                            <label for="roleDescription" class="form-label">Descripcion del Rol</label>
                            <input type="text" class="form-control" id="roleDescription" name="roleDescription"
                                   required/>
                            <div class="invalid-feedback">El campo nombre de rol es obligatorio</div>
                        </div>
                        <div class="mb-3 form-check form-switch">
                            <input type="checkbox" checked
                                   class="form-check-input" id="isActive"
                                   name="isActive"
                                   role="checkbox"
                                   required/>
                            <label class="form-check-label" for="isActive">Estado = <span
                                    class="text-success fw-bolder">Activo</span></p>
                            </label>
                            <div class="invalid-feedback">Debe indicar si el rol es activo</div>
                        </div>
                    </div>
                    <button type="button" class="btn btn-outline-dark" data-bs-dismiss="modal" id="btnRolUpsertCancel">
                        <i
                                class="bi bi-arrow-return-left"></i>&nbsp;Cancelar
                    </button>
                    <button type="submit" class="btn btn-outline-warning"><i
                            class="bi bi-floppy"></i>&nbsp;Guardar
                    </button>
                    <hr class="text-danger"/>
                </form>
            </div>
        </div>
        <div class="modal-footer">
        </div>
    </div>
</div>
<jsp:include page="/WEB-INF/templates/footer.jsp">
    <jsp:param name="lessonName"
               value="Proyecto Ecommerce con Jakarta EE 10"/>
</jsp:include>