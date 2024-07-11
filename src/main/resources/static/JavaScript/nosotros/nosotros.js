let nombre = document.getElementById("nombre-form"); //Nombre
let correo = document.getElementById("correo-form"); //correo
let telefono = document.getElementById("telefono-form"); //telefono
let comentario = document.getElementById("comentario-form"); //comentario

let btnEnviar = document.getElementById("btn-enviar"); //botón de enviar.

let alertaValidaciones = document.getElementById("alertaValidaciones"); //mensaje de error
let alertaTexto = document.getElementById("alerta-txt"); //mensaje de error


let isValid = true; //sólo cuando todo es válido.
let contador = true; //Sólo una vez.
let blankRegex = /^\S*$/;
let erCorreo = /^[-\w.%+]{1,64}@(?:[A-Z0-9-]{1,63}\.){1,125}[A-Z]{2,63}$/i;
let erTelefono =/^[1-9]\d{9}$/;//número de teléfono no comience con cero, tenga exactamente 10 dígitos y no permita dejar el espacio vacío.
let erComentario = /^(?=.*\S).{4,200}$/; //el texto contenga al menos una palabra (no esté vacío) y tenga entre 1 y 200 caracteres. Además, permite acentos, puntos y comas.
let erNombre = /^(?=.*\S).{3,50}$/; //nombre no esté vacío, permita acentos, comas, puntos, mayúsculas, minúsculas y tenga entre 1 y 50 caracteres


/// Se da Click al botón de enviar
btnEnviar.addEventListener("click", function (event) {
    event.preventDefault();
    alertaTexto.innerHTML = ``;
    alertaValidaciones.style.display = "none";
    nombre.style.border = "solid 0.01rem #450920";
    correo.style.border = "solid 0.01rem #450920";
    telefono.style.border = "solid 0.01rem #450920";
    comentario.style.border = "solid 0.01rem #450920";
    isValid = true;
    /*if ((nombre.value.length < 3 && contador == true) || !blankRegex.test(nombre.value)) { //validación para nombre
        alertaTexto.innerHTML += `<p>El <b style="color: red;">Nombre</b> no es correcto.</p>`;
        alertaValidaciones.style.display = "block";
        nombre.style.border = "solid red medium";
        isValid = false;
    }*/
    if (!erNombre.test(nombre.value) && contador == true) { //validación para nombre
        alertaTexto.innerHTML += `<p>El <b style="color: red;">Nombre</b> no es correcto, esta vacío o tiene menos de 3 letras.</p>`;
        alertaValidaciones.style.display = "block";
        nombre.style.border = "solid red medium";
        isValid = false;
    }


    if (!erCorreo.test(correo.value) && contador == true) { //validación para correo
        alertaTexto.innerHTML += `<p>El <b style="color: red;">Correo electrónico</b> no es correcto.</p>`;
        alertaValidaciones.style.display = "block";
        correo.style.border = "solid red medium";
        isValid = false;
    }
    if (!erTelefono.test(telefono.value) && contador == true) { //validación para telefono
        alertaTexto.innerHTML += `<p>El <b style="color: red;">Teléfono</b> no es correcto, no puede dejarse vacío o empezar con cero y debe tener 10 dígitos.</p>`;
        alertaValidaciones.style.display = "block";
        telefono.style.border = "solid red medium";
        isValid = false;
    }
    /*if (((comentario.value.length < 4 || comentario.value.length > 150) && contador == true) || !blankRegex.test(comentario.value)) { //validación para comentario
        alertaTexto.innerHTML += `<p>El <b style="color: red;">Comentario</b> no es correcto.</p>`;
        alertaValidaciones.style.display = "block";
        comentario.style.border = "solid red medium";
        isValid = false;
    }*/
    if (!erComentario.test(comentario.value) && contador == true) { //validación para comentario
        alertaTexto.innerHTML += `<p>El <b style="color: red;">Comentario</b> no debe estar vacío o debe poner una frase más larga y puede contener 200 carácteres.</p>`;
        alertaValidaciones.style.display = "block";
        comentario.style.border = "solid red medium";
        isValid = false;
    }



    if (isValid && contador) {

        (function () {
            emailjs.init({
                publicKey: "cmJyxtBQKn2YS9e4G",
            });
        })();

        let serviceID = "service_2rr4m9e";
        let templateID = "template_vdxekd4";

        params = {
            nombre_: nombre.value,
            correo_: correo.value.toLowerCase(),
            telefono_: telefono.value,
            comentario_: comentario.value
        }


        //Enviar Correo.
        emailjs.send(serviceID, templateID, params).then(() => {
            alertaTexto.innerHTML = ``;
            alertaValidaciones.style.display = "none";
            nombre.style.border = "solid 0.01rem #450920";
            correo.style.border = "solid 0.01rem #450920";
            telefono.style.border = "solid 0.01rem #450920";
            comentario.style.border = "solid 0.01rem #450920";
            nombre.value = '';
            correo.value = '';
            telefono.value = '';
            comentario.value = '';
            btnEnviar.style.opacity = 0.5;
            btnEnviar.innerText = "Enviado";
            contador = false;
        }).catch();

    }

});




window.addEventListener("load", function (event) {
    event.preventDefault();

});