/* global Swal */

let tblPersons;


function deletePerson(idPersona, nombre) {
    Swal.fire({
        title: "Esta Seguro de esta Accion?",
        text: "Una vez confirmada no se puede revertir!",
        icon: "warning",
        showCancelButton: true,
        confirmButtonColor: "#3085d6",
        cancelButtonColor: "#d33",
        confirmButtonText: "Yes, delete it!"
    }).then((result) => {
        if (result.isConfirmed) {
            $.ajax({
                type: 'DELETE',
                url: 'persons-upsert?id=' + idPersona,
                success: function (response) {
                },
                error: function (response) {
                    alert('error');
                }
            });
            Swal.fire({
                title: "Elemento Borrado!",
                text: "La persona con nombre " + nombre + " fue eliminada con exito!",
                icon: "success"
            }).then((result) => {
                location.reload();
            });
        }

    });
}

$(function () {

    $.ajax({
        url: "/storemc/utils/data/getAllPersons",
        method: "GET"
    }).done(function (data) {
        const responseJson = data; // Aquí ya tienes acceso a la parte de responseJson
        console.log(responseJson);
        loadPersonTable(responseJson);
    });
});

function birthDate(dateToFormat) {
    return new Date(dateToFormat).toLocaleDateString('es-MX', {
        day: 'numeric',
        month: 'short',
        year: 'numeric'
    });
}

//Tabla con la libreria datatable

function loadPersonTable(jsonData) {
    tblPersons = $("#tblPersons").DataTable({
        data: jsonData,
        "language": {
            "lengthMenu": "Mostrar _MENU_ Registros Por Pagina",
            "zeroRecords": "Ningun Registro",
            "info": "Mostrar pagina _PAGE_ de _PAGES_",
            "infoEmpty": "no hay registros",
            "infoFiltered": "(filtered from _MAX_ total registros)",
            "search": "Buscar",
            "paginate": {
                "first": "Primero",
                "last": "Último",
                "next": "Siguiente",
                "previous": "Anterior"
            }
        },
        "columns": [
            {"data": "dni", "className": "dt-body-center"},
            {"data": "name", "className": "dt-body-center"},
            {"data": "lastName", "className": "dt-body-center"},
            {
                "data": "birthDate",
                "className": "dt-body-center",
                "render": function (data) {
                    return moment(data).format('DD MMM YYYY');
                }
            },
            {"data": "citizenship", "className": "dt-body-center"},
            {
                "data": "id",
                "render": function (data, type, row) {
                    return `
                      <div class="d-flex justify-content-around">
                          <a href="persons-upsert?id=${data}" role="button" class="btn btn-outline-primary" title="Editar" style="cursor:pointer;"><i class="bi bi-pencil-square"></i></a>
                          <a onclick="deletePerson('${row.id}','${row.name}')" role="button" class="btn btn-outline-danger" title="Eliminar" style="cursor:pointer;"><i class="bi bi-trash3-fill"></i></a>
                      </div>
                    `;
                }
            }
        ]
    });
}

