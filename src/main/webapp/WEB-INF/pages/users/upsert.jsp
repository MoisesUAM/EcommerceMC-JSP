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
                    <div class="card-header text-bg-success fw-bold">Agregar nuevo Usuario</div>
                </c:if>
                <c:if test="${user.id != null}">
                    <div class="card-header text-bg-info fw-bolder">Actualizar Usuario</div>
                </c:if>
                <div class="card-body">
                    <form action="users-upsert" method="post" class="needs-validation" novalidate
                          oninput="password2.setCustomValidity(password2.value !== password1.value ? 'Las contraseñas no coinciden' : '')">
                        <input type="hidden" name="userId" value="${user.id}">
                        <div class="mb-3">
                            <label for="userName" class="form-label">Nombre de Usuario</label>
                            <input type="text" class="form-control" id="userName" name="userName" required="true"
                                   value="${user.userName}"/>
                            <div class="invalid-feedback">El campo nombre de usuario es obligatorio</div>
                        </div>
                        <div class="mb-3">
                            <label for="email" class="form-label">Correo Electronico</label>
                            <input type="email" class="form-control" id="email" name="email" required="true"
                                   value="${user.email}"/>
                            <div class="invalid-feedback">El campo email es obligatorio</div>
                        </div>
                        <div class="mb-3">
                            <label for="password1" class="form-label">Contraseña</label>
                            <input type="password" class="form-control" id="password1" name="password1" required="true"
                                   value="${user.password}"/>
                            <div class="invalid-feedback">El campo contraseña es obligatorio</div>
                        </div>
                        <div class="mb-3">
                            <label for="password2" class="form-label">Confirme su Contraseña</label>
                            <input type="password" class="form-control" id="password2" name="password2"
                                   required="true" value="${user.id == null ? '' : user.password}"/>
                            <div class="invalid-feedback">El campo contraseña es obligatorio</div>
                        </div>
                        <div class="mb-3">
                            <select name="personId" id="personId" class="form-select"
                                    aria-label="Asignar usuario a persona" required>
                                <c:if test="${user.id == null}">
                                    <option class="text-danger" selected disabled value="">--Asignar usuario a
                                        persona--
                                    </option>
                                    <c:forEach items="${persons}" var="person">
                                        <option value="${person.id}">${person.dni}&nbsp;${person.name}&nbsp;${person.lastName}</option>
                                    </c:forEach>
                                </c:if>
                                <c:if test="${user.id != null}">
                                    <option selected
                                            value="${user.person.id}">${user.person.dni}&nbsp;${user.person.name}&nbsp;${user.person.lastName}</option>
                                    <c:forEach items="${persons}" var="person">
                                        <option value="${person.id}">${person.dni}&nbsp;${person.name}&nbsp;${person.lastName}</option>
                                    </c:forEach>
                                </c:if>
                            </select>
                            <div class="invalid-feedback">Seleccione una persona a la cual se le asigna el usuario</div>
                        </div>
                        <hr class="text-danger"/>
                        <div class="mb-3 form-check form-switch">
                            <c:if test="${user.id == null}">
                                <input type="checkbox" checked
                                       class="form-check-input" id="isActive"
                                       name="isActive"
                                       role="checkbox"/>
                            </c:if>
                            <c:if test="${user.id != null}">
                                <input type="checkbox" ${user.active ? 'checked' : ''}
                                       class="form-check-input" id="isActive"
                                       name="isActive" role="menuitemcheckbox"/>
                            </c:if>
                            <label class="form-check-label" for="isActive">Estado = <span
                                    class="text-${user.active ? 'success' : 'danger'} fw-bolder"> ${user.active ? 'Activo' : 'Inactivo'}</span></p>
                            </label>
                            <div class="invalid-feedback">Debe indicar si el usuario es activo</div>
                        </div>
                        <hr class="text-danger">
                        <div class="d-flex justify-content-around gap-2">
                            <button type="submit" class="btn btn-outline-primary"><i
                                    class="bi bi-floppy2-fill"></i>&nbsp;Agregar
                            </button>
                            <a href="users" role="button" class="btn btn-outline-warning"><i
                                    class="bi bi-arrow-return-left"></i>&nbsp;Regresar</a>
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