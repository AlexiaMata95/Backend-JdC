/* <----------- BOTONES ------------> */
let btnCrear = document.getElementById('btn-crear');
let btnImagen = document.getElementById('btn-img');

/* <----------- FORMULARIO ------------> */
const formName = document.getElementById('nombre');
const formCategory = document.getElementById('categoria');
const formPrice = document.getElementById('precio');
const formDiscount = document.getElementById('descuento');
const formType = document.getElementById('tipo');
const formDescription = document.getElementById('descripcion');

/* <----------- ALERTAS ------------> */

let nameAlert = document.getElementById("nameAlert")
let categoryAlert = document.getElementById("categoryAlert")
let priceAlert = document.getElementById("priceAlert")
let discountAlert = document.getElementById("discountAlert")
let typeAlert = document.getElementById("typeAlert")
let descriptionAlert = document.getElementById("descriptionAlert")

/* <----------- REGEX ------------> */
// Este regex sigue permitiendo letras (tanto mayúsculas como minúsculas), acentos, el carácter ñ en ambas mayúsculas y minúsculas, espacios, apóstrofes y guiones. 
let nombreRegex = /[a-zA-Z0-9áéíóúÁÉÍÓÚüÜñÑ¿¡.,;:()\-_&%$#@"'<>+*=/\[\]?!\s]+/;
let precioRegex = /^(?!0+(?:\.0+)?$)[0-9]+(?:\.[0-9]*)?$/; //Validar precio, que tenga al menos un digito y pueda o no estar acompañado de decimales
let descuentoRegex = /^(?:100|\d{1,2})$/;

/// Se da Click al botón de enviar
btnCrear.addEventListener("click", validateForm);

///btn agregar img
let widget_cloudinary;
let urlImg = "";
btnImagen.addEventListener('click', () => {
    widget_cloudinary.open();
}, false);

widget_cloudinary = cloudinary.createUploadWidget({
    cloudName: 'dqfqn6tnq',
    uploadPreset: 'zrqhoanw'
}, (err, result) => {
    if (!err && result && result.event === 'success') {
        console.log('Imagen subida con éxito', result.info);
        urlImg = result.info.secure_url;
        console.log(urlImg);
    }
});

function validateForm(event) {
    event.preventDefault();

    let isValid = true;

    // Validaciones
    if (!validacion(nombreRegex, formName, nameAlert)) {
        isValid = false;
    }

    if (!validacion(nombreRegex, formCategory, categoryAlert)) {
        isValid = false;
    }

    if (!validacion(precioRegex, formPrice, priceAlert)
    ) {
        isValid = false;
    }
    if (!validacion(descuentoRegex, formDiscount, discountAlert)) {
        isValid = false;
    }

    if (!validacion(nombreRegex, formType, typeAlert)) {
        isValid = false;
    }

    if (!validacion(nombreRegex, formDescription, descriptionAlert)) {
        isValid = false;
    }

    if (!urlImg) {
        Swal.fire({
            icon: "error",
            title: "¡Error!",
            text: "¡Debe seleccionar una imagen!",
            showConfirmButton: false,
            timer: 2000
        });
        isValid = false;
    }

    if (isValid) {
        // let productos = JSON.parse(localStorage.getItem('productos'));
        // console.log(productos);
        // sendData(); //push a arreglo de json
        let objetoProducto = {
            "nombre": formName.value.trim().replace(/\s+/g, ' '),
            "producto": formType.value.trim().replace(/\s+/g, ' '),
            "precio": parseFloat(formPrice.value).toFixed(2),
            "imagen": urlImg,
            "categoria": formCategory.value.trim().replace(/\s+/g, ' '),
            "descripcion": formDescription.value.trim().replace(/\s+/g, ' '),
            "descuento": parseInt(formDiscount.value) / 100
        }

        let token = localStorage.getItem('token');
        sendData(objetoProducto, token);
        // imprimir token de localStorage
        

        

        // Limpiar formulario
        formName.value = "";
        formCategory.value = "";
        formPrice.value = "";
        formDiscount.value = "";
        formType.value = "";
        formDescription.value = "";
        urlImg = "";

        // Limpiar alertas
        formName.classList.remove("is-valid");
        formCategory.classList.remove("is-valid");
        formPrice.classList.remove("is-valid");
        formDiscount.classList.remove("is-valid");
        formType.classList.remove("is-valid");
        formDescription.classList.remove("is-valid");
    }

}
function sendData(objetoProducto, token) {
    const myHeaders = new Headers();
    myHeaders.append("Authorization", token);
    myHeaders.append("Content-Type", "application/json");

    const raw = JSON.stringify(objetoProducto);

    const requestOptions = {
        method: "POST",
        headers: myHeaders,
        body: raw,
        redirect: "follow"
    };

    fetch("/api/productos/", requestOptions)
        .then((response) => response.text())
        .then((result) => {
            // si es nulo el result, es porque no se pudo agregar el producto
            if (!result) {
                Swal.fire({
                    icon: "error",
                    title: "Producto duplicado",
                    text: "El producto que intentas agregar ya existe en el inventario.",
                    showConfirmButton: true,
                    confirmButtonText: "Entendido",
                    timer: 3000,
                    timerProgressBar: true,
                    customClass: {
                        popup: 'popup-class',
                        title: 'title-class',
                        confirmButton: 'confirm-button-class'
                    }
                });
                
            } else{
                // obtener token de localStorage
                let token = localStorage.getItem('token');

                if (token) {
                    Swal.fire({
                        icon: "success",
                        title: "¡Envío exitoso!",
                        text: "¡El producto se ha agregado con éxito!",
                        showConfirmButton: true,
                        confirmButtonText: "Cerrar",
                        timer: 3000,
                        timerProgressBar: true,
                        customClass: {
                            popup: 'success-popup-class',
                            title: 'success-title-class',
                            confirmButton: 'success-confirm-button-class'
                        }
                    });
                } else{
                    Swal.fire({
                        icon: "error",
                        title: "¡Error!",
                        text: "¡Incia sesión como Administrador!",
                        showConfirmButton: true,
                        confirmButtonText: "Cerrar",
                        timer: 3000,
                        timerProgressBar: true,
                        customClass: {
                            popup: 'popup-class',
                            title: 'title-class',
                            confirmButton: 'confirm-button-class'
                        }
                    });
                }


                
                
            }
        })
        .catch((error) => console.error(error));
}

function validacion(regex, form, alert) {
    if (!regex.test(form.value)) {
        alert.classList.remove("d-none")
        form.classList.add("is-invalid")
        return false;
    } else {
        form.classList.add("is-valid")
        form.classList.remove("is-invalid")
        alert.classList.add("d-none")
        return true;
    }
}
