
/* <-------------ELEMENTOS DEL FORMULARIO-----------> */
const formRegistro = document.getElementById('formRegistro');
const formName = document.getElementById('name');
const formLastName = document.getElementById('lastName');
const formPhone = document.getElementById('phone');
const formEmail = document.getElementById('email');
const formPassword = document.getElementById('password');
const formPasswordConfirm = document.getElementById('passwordConfirm');

/* <-------- Alertas---------------->*/
let nameAlert = document.getElementById("nameAlert")
let lastNameAlert = document.getElementById("lastNameAlert")
let phoneAlert = document.getElementById("phoneAlert")
let emailAlert = document.getElementById("emailAlert")
let passAlert = document.getElementById("passAlert")
let confirmPassAlert = document.getElementById("confirmPassAlert")

let userArray = JSON.parse(localStorage.getItem('users')) ? JSON.parse(localStorage.getItem('users')) : [];

/* <----------- REGEX ------------> */
// Este regex sigue permitiendo letras (tanto mayúsculas como minúsculas), acentos, el carácter ñ en ambas mayúsculas y minúsculas, espacios, apóstrofes y guiones. 
let nombreRegex = /(?=.*(?:[A-Za-zÁÉÍÓÚáéíóúÑñ]{3}))[A-Za-zÁÉÍÓÚáéíóúÑñ\s'-]+$/;
// Solo acepta 10 números y no más de 3 ceros seguidos
let phoneRegex = /^(?!.*0{3})\d{10}$/;
// https://emailregex.com/
let emailRegex = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
// Mínimo ocho caracteres, al menos una letra inglesa mayúscula, una letra inglesa minúscula, un número y un carácter especial
let passRegex = /^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-])[^\s]{8,}$/;

/// Se da Click al botón de enviar
formRegistro.addEventListener("submit", validateForm);

function validateForm(event) {
    event.preventDefault();

    let isValid = true;

    // Validaciones
    if (!validacion(nombreRegex, formName, nameAlert)) {
        isValid = false;
    }

    if (!validacion(nombreRegex, formLastName, lastNameAlert)) {
        isValid = false;
    }

    if (!validacion(phoneRegex, formPhone, phoneAlert)
    ) {
        isValid = false;
    }
    if (!validacion(emailRegex, formEmail, emailAlert)) {
        isValid = false;
    }

    if (!validacion(passRegex, formPassword, passAlert)) {
        isValid = false;
    }


    if (formPasswordConfirm.value != formPassword.value || formPasswordConfirm.value == "") {
        console.log("No son iguales");
        confirmPassAlert.classList.remove("d-none")
        formPasswordConfirm.classList.add("is-invalid")
        isValid = false;
    } else {
        formPasswordConfirm.classList.add("is-valid")
        formPasswordConfirm.classList.remove("is-invalid")
        confirmPassAlert.classList.add("d-none")
    }
    console.log(isValid);
    if (isValid) {
        document.getElementById('newUser').disabled = true;
        // Crear objeto usuario
        let newUser = {
            nombre: formName.value.trim().replace(/\s+/g, ' '),
            apellido: formLastName.value.trim().replace(/\s+/g, ' '),
            telefono: formPhone.value,
            correo: formEmail.value.trim().toLowerCase(),
            contrasena: formPassword.value,
            rol: "CLIENTE"
        }
        addUser(newUser);
        
        Swal.fire({
            icon: "success",
            title: "¡Registro exitoso!",
            text: "¡Bienvenido a Joya del Caribe!",
            showConfirmButton: false,
        });
//        setTimeout(() => {
//            window.location.href = "../iniciosesion.html";
//        }, 2000);
    }
}

function addUser(userObject) {
//    // Agregar usuario al array de usuarios
//    userArray.push(userObject);
//    // Mandar el array de datos al localStorage
//    //          .agregarCosa Nombre de Cosa, lo volvemos string porque asi se leen los datos en el lS           
//    localStorage.setItem('userArray', JSON.stringify(userArray));
	URL = "/api/usuarios/"
    const promise = fetch(URL, 
    {
        method : 'POST',
        body: JSON.stringify(userObject),
        headers : {
            'Content-Type': 'application/json',
          }
    })

    promise
    .then((response) => {
        response.json()
            .then((json) => {
                console.log( "Success: " + json);
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
    if (!regex.test(form.value) || form.value.length < 3) {
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
