
/* <-------------ELEMENTOS DEL FORMULARIO-----------> */
const formRegistro = document.getElementById('formRegistro');
const formEmail = document.getElementById('email');
const formPassword = document.getElementById('password');

/* <-------- Alertas---------------->*/
let emailAlert = document.getElementById("emailAlert")
let passAlert = document.getElementById("passAlert")

let userArray = JSON.parse(localStorage.getItem('users')) ? JSON.parse(localStorage.getItem('users')) : [];

/* <----------- REGEX ------------> */
// https://emailregex.com/
let emailRegex = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
// Mínimo ocho caracteres, al menos una letra inglesa mayúscula, una letra inglesa minúscula, un número y un carácter especial
let passRegex = /^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$ %^&*-]).{8,}$/;

/// Se da Click al botón de enviar
formRegistro.addEventListener("submit", validateForm);

function validateForm(event) {
    event.preventDefault();

    let isValid = true;

    // Validaciones
    if (!validacion(emailRegex, formEmail, emailAlert)) {
        isValid = false;
    }

    if (!validacion(passRegex, formPassword, passAlert)) {
        isValid = false;
    }

    // console.log(isValid);
    if (isValid) {
        emailAlert.classList.add("d-none")
        passAlert.classList.remove("alert-info")
        passAlert.classList.add("alert-danger")
        // Crear objeto usuario
        let newUser = {
            email: formEmail.value.trim().toLowerCase(),
            password: formPassword.value,
        }

        userExists = true;
        // Obtener usuarios de localStorage
        //let storedUsers = JSON.parse(localStorage.getItem('userArray')) || [];
        //console.log(storedUsers);
        // Buscar si el usuario existe y la contraseña coincide
        //let userExists = storedUsers.find(user => user.email === formEmail.value.trim().toLowerCase() && user.password === formPassword.value);

        if (userExists) {
            //let token = inicioSesion(newUser.email, newUser.password);
            // mandar la respuesta de la api (token) a localStorage
            //localStorage.setItem('token', token);

            inicioSesion(newUser.email, newUser.password);
            addUser(newUser);
            document.getElementById('newUser').disabled = true;

            emailAlert.classList.add("d-none")
            passAlert.classList.add("d-none")
            console.log("Inicio de sesión exitoso");

            Swal.fire({
                icon: "success",
                title: "¡Inicio de Sesión exitoso!",
                text: "¡Bienvenido a Joya del Caribe!",
                showConfirmButton: false,
            });
            setTimeout(() => {
                window.location.href = "../index.html";
            }, 2000);

        } else {
            console.log("Correo electrónico o contraseña incorrectos.");


            formEmail.classList.remove("is-valid")
            formEmail.classList.add("is-invalid")
            formPassword.classList.remove("is-valid")
            formPassword.classList.add("is-invalid")
            passAlert.innerText = "Correo electrónico o contraseña incorrectos"
            passAlert.classList.remove("d-none")
        }
    }
}

function addUser(userObject) {
    // Agregar usuario al array de usuarios
    userArray.push(userObject);
    // Mandar el array de datos al localStorage
    //          .agregarCosa Nombre de Cosa, lo volvemos string porque asi se leen los datos en el lS           
    localStorage.setItem('userLogin', JSON.stringify(userArray));
}

function validacion(regex, form, alert) {
    if (!regex.test(form.value) || form.value.length < 3) {
        alert.classList.remove("d-none")
        form.classList.add("is-invalid")
        return false;
    } else {
        // form.classList.add("is-valid")
        form.classList.remove("is-invalid")
        alert.classList.remove("d-none")
        alert.classList.add("alert-info")
        alert.classList.remove("alert-danger")
        alert.innerText = `El campo ingresado cumple con los requisitos de formato.`;
        return true;
    }
}

function inicioSesion(correo, contrasena) {
    const myHeaders = new Headers();
    myHeaders.append("Content-Type", "application/json");

    const raw = JSON.stringify({
        "correo": correo,
        "contrasena": contrasena
    });

    const requestOptions = {
        mode: 'no-cors',
        method: "POST",
        headers: myHeaders,
        body: raw,
        redirect: "follow"
    };

    fetch("http://13.58.46.147/api/login/", requestOptions)
        .then((response) => response.text())
        .then((result) => console.log(result))
        .catch((error) => console.error(error));
}