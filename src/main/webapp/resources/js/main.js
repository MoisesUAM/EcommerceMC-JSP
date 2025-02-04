(() => {
	'use strict'

	// Fetch all the forms we want to apply custom Bootstrap validation styles to
	const forms = document.querySelectorAll('.needs-validation')

	// Loop over them and prevent submission
	Array.from(forms).forEach(form => {
		form.addEventListener('submit', event => {
			if (!form.checkValidity()) {
				event.preventDefault()
				event.stopPropagation()
			}

			form.classList.add('was-validated')
		}, false)
	})
})()

$(function() {
	toastr.options = {
		"positionClass": "toast-bottom-center", // Posición en la esquina inferior derecha (puedes ajustar a bottom-left, bottom-center, etc.)
		"timeOut": 2500, // Duración en milisegundos (1.5 segundos)
		"extendedTimeOut": 1000, // Tiempo extra de duración si el mouse está sobre la alerta
		// Otras opciones de configuración que puedes personalizar
		"closeButton": false, // Mostrar botón de cierre
		"debug": false,
		"newestOnTop": false,
		"progressBar": true, // Mostrar barra de progreso
		"preventDuplicates": false,
		"pauseOnHover": true,
		"onclick": null,
		"showDuration": "300",
		"hideDuration": "1000",
		"showEasing": "swing",
		"hideEasing": "linear",
		"showMethod": "fadeIn",
		"hideMethod": "fadeOut",
		"tapToDismiss": false
	};
	
	debugger
	let error = $('#alertError').attr('itemprop');
	let success = $('#alertSuccess').attr('itemprop');
	let warning = $('#alertWarning').attr('itemprop');
	let info = $('#alertInfo').attr('itemprop');
	if (success) {
		toastr.success(success);
	}
	if (error) {
		toastr.error(error);
	}
	if (info) {
		toastr.info(info);
	}
	if (warning) {
		toastr.warning(warning);
	}
	error = null;
	success = null;
	warning = null;
	info = null;
});

