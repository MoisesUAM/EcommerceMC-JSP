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

$(function () {
    let success = $("#alert-success").val();
    let error = $("#alert-error").val();
    let info = $("#alert-info").val();
    let warning = $("#alert-warning").val();
    if (success !== "") {
        toastr.success(success);
    }
    if (error !== "") {
        toastr.error(error);
    }
    if (info !== "") {
        toastr.info(info);
    }
    if (warning !== "") {
        toastr.warning(warning);
    }
});

