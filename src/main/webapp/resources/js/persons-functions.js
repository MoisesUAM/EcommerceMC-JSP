/* global Swal */

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
                url: "person-upsert",
                data: idPersona,
                method: 'DELETE',
                success: function (response) {
                    //recargas la pagina para recargar la vista (por como lo tenes armado)
                    location.reload();
                },
                error: function (response) {
                    alert('error');
                }


            });
            Swal.fire({
                title: "Elemento Borrado!",
                text: "La persona con nombre " + nombre + " fue eliminada con exito!",
                icon: "success"
            });
        }
    });
}

