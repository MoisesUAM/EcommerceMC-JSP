<jsp:include page="/WEB-INF/templates/header.jsp">
    <jsp:param name="pageName" value="Personas Upsert | StoreMC"/>
</jsp:include>
<%@taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<div class="container">
    <div class="row">
        <h2 class="text-center text-dark-emphasis">Administracion / Registro de Personas</h2>
        <hr class="text-dark"/>
        <br>
        <div class="d-flex justify-content-center">
            <div class="card border border-dark-subtle" style="min-width: 400px; max-width: 550px">
                <c:if test="${person.id == null || person == null}">
                    <div class="card-header text-bg-success fw-bold">Agregar nuevo Registro o Persona</div>
                </c:if>
                <c:if test="${person.id != null}">
                    <div class="card-header text-bg-info fw-bolder">Actualizar Persona</div>
                </c:if>
                <div class="card-body">
                    <form class="needs-validation" action="persons-upsert" method="post" novalidate>
                        <input type="hidden" name="idPerson" id="idPerson" value="${person.id}">
                        <div class="mb-3">
                            <label for="dniPerson" class="form-label">DNI</label>
                            <input type="text" class="form-control" id="dniPerson" name="dniPerson"
                                   required value="${person.dni}"/>
                            <div class="invalid-feedback">El campo DNI es obligatorio</div>
                        </div>
                        <div class="mb-3">
                            <label for="namePerson" class="form-label">Nombre</label>
                            <input type="text" class="form-control" id="namePerson" name="namePerson"
                                   required value="${person.name}"/>
                            <div class="invalid-feedback">El campo nombre es obligatorio</div>
                        </div>
                        <div class="mb-3">
                            <label for="lastNamePerson" class="form-label">Apellidos</label>
                            <input type="text" class="form-control" id="lastNamePerson" name="lastNamePerson"
                                   required value="${person.lastName}"/>
                            <div class="invalid-feedback">El campo apellidos es obligatorio</div>
                        </div>
                        <div class="mb-3">
                            <label for="birthDatePerson" class="form-label">Fecha
                                Nacimiento</label>
                            <input type="date" name="birthDatePerson" id="birthDatePerson" class="form-control"
                                   value="${birthDayFormatted}" required>
                            <div class="invalid-feedback">La fecha es un campo obligatorio</div>
                        </div>
                        <div class="mb-3">
                            <label for="citizenshipPerson" class="form-label">Nacionalidad</label>
                            <input type="text" name="citizenshipPerson" id="citizenshipPerson"
                                   class="form-control" value="${person.citizenship}" required>
                            <div class="invalid-feedback">El campo nacionalidad es obligatorio es un campo
                                obligatorio
                            </div>
                        </div>
                        <hr class="text-danger">
                        <div class="d-flex justify-content-around gap-2">
                            <button type="submit" class="btn btn-outline-primary"><i
                                    class="bi bi-floppy2-fill"></i>&nbsp;Agregar
                            </button>
                            <a href="persons" role="button" class="btn btn-outline-warning"><i
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
