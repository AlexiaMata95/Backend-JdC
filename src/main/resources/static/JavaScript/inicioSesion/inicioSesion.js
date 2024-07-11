/* <-------------ELEMENTOS DEL FORMULARIO-----------> */
const formRegistro = document.getElementById('formRegistro');
const formEmail = document.getElementById('email');
const formPassword = document.getElementById('password');

/* <-------- Alertas---------------->*/
let emailAlert = document.getElementById("emailAlert")
let passAlert = document.getElementById("passAlert")

/* <----------- REGEX ------------> */
// https://emailregex.com/
let emailRegex = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
// Mínimo ocho caracteres, al menos una letra inglesa mayúscula, una letra inglesa minúscula, un número y un carácter especial
let passRegex = /^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$ %^&*-]).{8,}$/;

/// Se da Click al botón de enviar
formRegistro.addEventListener("submit", validateForm);

function validateForm(event) {
    event.preventDefault();
    emailAlert.classList.add("d-none");
    passAlert.classList.add("d-none");

    let isValid = true;

    // Validaciones
    if (!validacion(emailRegex, formEmail, emailAlert)) {
        isValid = false;
    }

    if (!validacion(passRegex, formPassword, passAlert)) {
        isValid = false;
    }

    if (isValid) {
        let newUser = {
            correo: formEmail.value.trim().toLowerCase(),
            contrasena: formPassword.value,
        }

        let nuevoUser = inicioSesion(newUser);
    }
}

function validacion(regex, form, alert) {
    if (!regex.test(form.value) || form.value.length < 3) {
        alert.classList.remove("d-none")
        form.classList.add("is-invalid")
        return false;
    } else {
        form.classList.remove("is-invalid")
        return true;
    }
}

function inicioSesion(login) {
    const myHeaders = new Headers();
    myHeaders.append("Content-Type", "application/json");

    const raw = JSON.stringify(login);

    const requestOptions = {
        method: "POST",
        headers: myHeaders,
        body: raw,
        redirect: "follow"
    };

    fetch("/api/login/", requestOptions)
        .then((response) => response.json())
        .then((result) => {
            if (result.accessToken) {
                localStorage.setItem('token', `Bearer: ${result.accessToken}`);
                emailAlert.classList.add("d-none")
                passAlert.classList.add("d-none")

                Swal.fire({
                    icon: "success",
                    title: "¡Inicio de Sesión exitoso!",
                    text: "¡Bienvenido a Joya del Caribe!",
                    showConfirmButton: false,
                });
                setTimeout(() => {
                    window.location.href = "../index.html";
                }, 2000);

                // mandar el form email a localStorage
                localStorage.setItem("email", formEmail.value);
            } else {
                console.log("Correo electrónico o contraseña incorrectos.");

                formEmail.classList.remove("is-valid")
                formEmail.classList.add("is-invalid")
                formPassword.classList.remove("is-valid")
                formPassword.classList.add("is-invalid")
                passAlert.innerText = "Correo electrónico o contraseña incorrectos"
                passAlert.classList.remove("d-none")
            }
        })
        .catch((error) => {
            console.log(error)

        });
}