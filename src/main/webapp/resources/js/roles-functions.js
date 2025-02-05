let tblRoles;


$(function() {

	$.ajax({
		url: "/storemc/utils/data/getAllRoles",
		method: "GET"
	}).done(function(data) {
		const responseJson = data; // Aquí ya tienes acceso a la parte de responseJson
		console.log(responseJson);
		loadTblRoles(responseJson);
	});

	$("#btnRolUpsertCancel").click(function() {
		$("#roleAddModalLabel").text("Agregar Rol");
	});
});

function loadTblRoles(jsonData) {

	tblRoles = $('#tblRoles').dataTable({
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
			{ "data": "roleName", "className": "dt-body-center" },
			{ "data": "roleDescription", "className": "dt-body-center" },
			{
				"data": "active", "render": function(data) {
					if (data) {
						return "Activo";
					} else {
						return "Inactivo";
					}
				}, className: "dt-body-center"
			},
			{
				"data": "id", "render": function(data, type, row) {
					return `
                      <div class="d-flex justify-content-around">
                          <a onclick="editRole('${row.id}','${row.roleName}','${row.roleDescription}',${JSON.stringify(row.active)})" role="button" class="btn btn-outline-primary" title="Editar" style="cursor:pointer;"><i class="bi bi-pencil-square"></i></a>
                          <a onclick="deleteRole('${row.id}','${row.roleName}')" role="button" class="btn btn-outline-danger" title="Eliminar" style="cursor:pointer;"><i class="bi bi-trash3-fill"></i></a>
                      </div>
                    `;
				}, className: "dt-body-center"
			}
		]
	});
}

function editRole(id, roleName, roleDescription, active) {

	
	console.log('id =' + id);
	console.log('roleName =' + roleName);
	console.log('roleDescription =' + roleDescription);
	console.log('Es activo?  =' + active);

	$('#roleId').val(id);
	$('#roleName').val(roleName);
	$('#roleDescription').val(roleDescription);

	$('#roleActive').prop('checked', active);

	$('#roleAddModalLabel').text('Editar Rol');
	$('#roleAddModal').modal('show');

}


function deleteRole(id, name) {
	Swal.fire({
		title: '¿Estas seguro?',
		text: 'No podras revertir esto!',
		icon: 'warning',
		showCancelButton: true,
		confirmButtonColor: '#3085d6',
		cancelButtonColor: '#d33',
		confirmButtonText: 'Si, Eliminar a ' + name + '!'
	}).then((result) => {
		if (result.isConfirmed) {
			$.ajax({
				url: 'role?id=' + id,  // Url that will be called
				type: 'DELETE',
				success: function(response) {
				},
				error: function(response) {
				}
			});
			Swal.fire({
				title: 'Elemento Borrado!',
				text: 'La el usuario ' + name + ' fue eliminada con exito!',
				icon: 'success'
			}).then((result) => {
				toastr.info('El usuario ' + name + ' fue eliminado con exito!');
				location.reload();
			});
		}
	});

}

$(function() {
	$('#roleActive').change(function() {
		if ($(this).is(':checked')) {
			$('#roleActiveSpan').text('Activo');
			$('#roleActiveSpan').removeClass('text-secondary').addClass('text-success');
		} else {
			$('#roleActiveSpan').text('Inactivo');
			$('#roleActiveSpan').removeClass('text-success').addClass('text-secondary');
		}
	});

	$('#roleAddModal').on('shown.bs.modal', function() {
		if ($('#roleActive').is(':checked')) {
			$('#roleActiveSpan').text('Activo');
			$('#roleActiveSpan').removeClass('text-secondary').addClass('text-success');
		} else {
			$('#roleActiveSpan').text('Inactivo');
			$('#roleActiveSpan').removeClass('text-success').addClass('text-secondary');
		}
	})
});

