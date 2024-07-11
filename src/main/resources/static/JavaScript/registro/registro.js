
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

    if (isValid) {
        //document.getElementById('newUser').disabled = true;
        // Crear objeto usuario
        let newUser = {
            nombre: formName.value.trim().replace(/\s+/g, ' '),
            apellido: formLastName.value.trim().replace(/\s+/g, ' '),
            telefono: formPhone.value,
            correo: formEmail.value.trim().toLowerCase(),
            contrasena: formPassword.value,
            rol: "ADMINISTRADOR"
        }
        addUser(newUser);
    }
}

function addUser(userObject) {
    const myHeaders = new Headers();
    myHeaders.append("Content-Type", "application/json");

    const raw = JSON.stringify(userObject);

    const requestOptions = {
        method: "POST",
        headers: myHeaders,
        body: raw,
        redirect: "follow"
    };

    fetch("/api/usuarios/", requestOptions)
        .then((response) => response.text())
        .then((result) => {
            if (!result) {
                Swal.fire({
                    icon: 'error',
                    title: '¡Error!',
                    text: 'El usuario ya existe.',
                    showConfirmButton: true,
                    confirmButtonText: 'Entendido',
                    customClass: {
                        popup: 'error-popup-class',
                        title: 'error-title-class',
                        confirmButton: 'error-confirm-button-class'
                    }
                });
                
                formEmail.classList.add("is-invalid");
                formEmail.value = "";
            } else{
                Swal.fire({
                    icon: 'success',
                    title: '¡Registro exitoso!',
                    text: 'Redirigiendo a la página de inicio de sesión...',
                    showConfirmButton: false,
                    timer: 3000,
                    timerProgressBar: true,
                    customClass: {
                        popup: 'success-popup-class',
                        title: 'success-title-class',
                        text: 'success-text-class'
                    }
                }).then(() => {
                    window.location.href = "../../iniciosesion.html";
                });
                
            }
        })
        .catch((error) => console.error(error));
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
