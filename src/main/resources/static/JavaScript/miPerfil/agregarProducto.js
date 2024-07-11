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
        let productos = JSON.parse(localStorage.getItem('productos'));
        console.log(productos);
        // sendData(); //push a arreglo de json
        let objetoProducto = {
            "id": productos.length + 1,
            "name": formName.value.trim().replace(/\s+/g, ' '),
            "product": formType.value.trim().replace(/\s+/g, ' '),
            "description": formDescription.value.trim().replace(/\s+/g, ' '),
            "price": parseFloat(formPrice.value).toFixed(2),
            "category": formCategory.value.trim().replace(/\s+/g, ' '),
            "img": urlImg,
            "discount": parseInt(formDiscount.value)
        }
        // agregar objetoProducto a productos
        productos.push(objetoProducto);
        localStorage.setItem('productos', JSON.stringify(productos));


        Swal.fire({
            icon: "success",
            title: "¡Envío exitoso!",
            text: "¡Producto agregado con exito!",
            showConfirmButton: false,
            timer: 2000
        });

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
function sendData() {
    const promise = fetch('../../JSONS/productos.json', { method: 'GET' });
    promise
        .then((response) => {
            response.json()
                .then((productObj) => {
                    productObj.productos.push(
                        {
                            "id": productObj.productos.length + 1,
                            "name": formName.value,
                            "product": formType.value,
                            "description": formDescription.value,
                            "price": formPrice.value,
                            "category": formCategory.value,
                            "img": urlImg,
                            "discount": formDiscount.value
                        }
                    );
                    console.log(productObj.productos[productObj.productos.length - 1]);
                })
                .catch((error) => {
                    console.log('Hubo un problema con el JSON ' + error);
                });
        })
        .catch((error) => {
            console.log('Hubo un problema con la solicitud ' + error);
        });
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

// fetch de productos, si no existe en localStorage
function getData() {
    const promise = fetch('../JSONS/productosURL.json', { method: 'GET' });
    promise
        .then((response) => {
            response.json()
                .then((productObj) => {
                    // pasar productObj al localStorage
                    localStorage.setItem('productos', JSON.stringify(productObj.productos));
                    productosLocal = JSON.parse(localStorage.getItem('productos'));
                    listarProductos(productosLocal);
                })
                .catch((error) => {
                    console.log('Hubo un problema con el JSON ' + error);
                });
        })
        .catch((error) => {
            console.log('Hubo un problema con la solicitud ' + error);
        });
}

// verificar si existe productos en el localStorage
if (!localStorage.getItem('productos')) {
    getData();
}

