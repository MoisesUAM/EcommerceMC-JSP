let tblUsers;


$(function () {

    $.ajax({
        url: "/storemc/utils/data/getAllUsers",
        method: "GET"
    }).done(function (data) {
        const responseJson = data; // Aquí ya tienes acceso a la parte de responseJson
        console.log(responseJson);
        loadTblUsers(responseJson);
    });

});


function loadTblUsers(jsonData) {

    tblUsers = $('#tblUsers').dataTable({
        data: jsonData,
        "language": {
            "lengthMenu": "Mostrar _MENU_ Registros Por Pagina",
            "zeroRecords": "Ningun Registro",
            "info": "Mostrar pagina _PAGE_ de _PAGES_",
            "infoEmpty": "No hay registros",
            "infoFiltered": "(filtrado de _MAX_ registros totales)",
            "search": "Buscar",
            "paginate": {
                "first": "Primero",
                "last": "Último",
                "next": "Siguiente",
                "previous": "Anterior"
            }
        },
        columns: [
            {"data": "userName", "className": "dt-body-center"},
            {
                "data": "email", "render": function (data, type, row) {
                    return `<p title="${row.person.name + ' dni=' + row.person.dni}">${row.email}</p>`;
                }, className: "dt-body-center"
            },
            {
                "data": "active", "render": function (data) {
                    if (data) {
                        return "Activo";
                    } else {
                        return "Inactivo";
                    }
                }, className: "dt-body-center"
            },
            {
                "data": "password", "render": function () {
                    return "********";
                }, className: "dt-body-center"
            },
            {
                "data": "id", "render": function (data, type, row) {
                    return `
                      <div class="d-flex justify-content-around">
                          <a href="users-upsert?id=${data}" role="button" class="btn btn-outline-primary" title="Editar" style="cursor:pointer;"><i class="bi bi-pencil-square"></i></a>
                          <a onclick="deleteUser('${row.id}','${row.person.name}')" role="button" class="btn btn-outline-danger" title="Eliminar" style="cursor:pointer;"><i class="bi bi-trash3-fill"></i></a>
                      </div>
                    `;
                }, className: "dt-body-center"
            }
        ]
    });
}

