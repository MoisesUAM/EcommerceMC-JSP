
<jsp:include page="/WEB-INF/templates/header.jsp">
    <jsp:param name="pageName" value="Personas | StoreMC" />
</jsp:include>
<%@taglib prefix="c" uri="jakarta.tags.core"%>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt"%>


<div class="row">
	<div class="d-flex">
<jsp:include page="/WEB-INF/templates/sidebar.jsp" />
<main class="content-main">
    <div class="row">
        <h2 class="text-center text-dark-emphasis">Administracion / Registro de Personas</h2>
        <hr class="text-dark"/>
    </div>
    <div class="d-flex justify-content-center">
        <div class="container-sm">
            <div class="row">
                <div class="col-sm-8">
                    <div class="d-grid mb3">
                        <a role="button" href="#" class="btn btn-outline-dark w-50" ><i class="bi bi-plus">&nbsp;Agregar</i></a>
                    </div>
                </div>
                <div class="col-sm-4">
                    <div class="d-grid mb-3">
                        <input type="text" placeholder="Buscar" class="form-control">
                    </div>
                </div>
            </div>
            <div class="row">
              <table class="table table-stripped table-hover table-reposive">
                <thead class="table-dark">
                    <tr class="text-center">
                        <th>DNI</th>
                        <th>Nombres</th>
                        <th>Apellidos</th>
                        <th>Fecha Nacimiento</th>
                        <th>Nacionalidad</th>
                    </tr>
                </thead>
                <tbody>
<c:forEach items="${persons}" var="person">
                    <tr class="text-center">
                        <td>${person.dni}</td>
                        <td>${person.name}</td>
                        <td>${person.lastName}</td>
                        <td><fmt:formatDate pattern="dd MMMM YYYY" value="${person.birthDate}"></fmt:formatDate></td>
                        <td>${person.citizenship}</td>
                    </tr>
</c:forEach>
                </tbody>
             </table>
            </div>
        </div>
    </div> 
</main>
</div>
</div>
<jsp:include page="/WEB-INF/templates/footer.jsp">
    <jsp:param name="lessonName"
               value="Proyecto Ecommerce con Jakarta EE 10" />
</jsp:include>
