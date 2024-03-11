
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
            <div class="d-flex justify-content-around">
              <div class="row-cols-4 mb-3">
                   <a role="button" href="#" class="btn btn-outline-dark"><i class="bi bi-plus">&nbsp;Agregar</i></a>
              </div>
              <div class="row-cols-6">
                <form action="">
                    <div class="mb-3">
                        <input type="text" placeholder="Buscar" class="form-control">
                    </div>
                </form>
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
                    <tr class="text-center">
                        <td>111420483</td>
                        <td>Moises Andres</td>
                        <td>Coto Salazar</td>
                        <td>20 may 1982</td>
                        <td>Costa Rica</td>
                    </tr>
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
