</div>
</div>
</main>
</div>
</div>

<footer class="bg-dark sticky-bottom">
    <div class="d-flex justify-content-around g-3 p-2">
        <div class="text-light">Copyright &copy; by Moises Coto, Inspirado en Curso Jakarta EE JSP version 10 Andres
            Guzman Udemy
        </div>
        <div class="text-light"><%= request.getParameter("lessonName") %>
        </div>
    </div>
</footer>

<script type="text/javascript" src="resources/lib/jquery/jquery.min.js"></script>
<script type="text/javascript" src="resources/lib/toastr/toastr.min.js"></script>
<script type="text/javascript" src="resources/lib/Tables/datatables/media/js/jquery.dataTables.js"></script>
<script type="application/javascript" src="resources/js/persons-functions.js"></script>
<script type="application/javascript" src="resources/js/users-functions.js"></script>
<script type="application/javascript" src="resources/js/usersRole-functions.js"></script>
<script type="text/javascript" src="resources/lib/sweetalert/sweetalert2.all.min.js"></script>
<script type="text/javascript" src="resources/lib/bootstrap/bootstrap.bundle.min.js"></script>
<script type="text/javascript" src="resources/lib/moment/dist/moment.js"></script>
<script type="text/javascript" src="resources/js/main.js"></script>
<c:if test="${alerts != null}">
    <input type="hidden" id="alert-success" value="${alerts.SUCCESS}">
    <input type="hidden" id="alert-error" value="${alerts.ERROR}">
    <input type="hidden" id="alert-info" value="${alerts.INFO}">
    <input type="hidden" id="alert-warning" value="${alerts.WARNING}">
</c:if>
</body>
</html>