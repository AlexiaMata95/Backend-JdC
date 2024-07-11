let diana = document.getElementById("diana-txt");
let esdras = document.getElementById("esdras-txt");
let alan = document.getElementById("alan-txt");
let javier = document.getElementById("javier-txt");
let jesus = document.getElementById("jesus-txt");
let ana = document.getElementById("ana-txt");
let brian = document.getElementById("brian-txt");
let alexia = document.getElementById("alexia-txt");

let btnDiana = document.getElementById("btn-diana");
let btnEsdras = document.getElementById("btn-esdras");
let btnAlan = document.getElementById("btn-alan");
let btnJavier = document.getElementById("btn-javier");
let btnJesus = document.getElementById("btn-jesus");
let btnAna = document.getElementById("btn-ana");
let btnBrian = document.getElementById("btn-brian");
let btnAlexia = document.getElementById("btn-alexia");

let btnState = [false, false, false, false, false, false, false, false];

btnDiana.addEventListener("click", function (event) {
    event.preventDefault();
    if (btnState[0]) {
        diana.innerHTML = `
        <p class="desc-txt" style="height: 5.4rem;">Desarrolladora Full Stack, con intereses de integrarme al mundo del
        desarrollo web ...</p>`;
        //console.log("texto corto");
        btnState[0] = false;
    } else {
        diana.innerHTML = `
        <p class="desc-txt" style="height: 9rem;">Desarrolladora Full Stack, con intereses de integrarme al mundo del desarrollo web y las TI aprovechando mis habilidades adquiridas a lo largo de mi formación académica.</p>`;
        //console.log("texto largo");
        btnState[0] = true;
    }
});

btnEsdras.addEventListener("click", function (event) {
    event.preventDefault();
    if (btnState[1]) {
        esdras.innerHTML = `
        <p class="desc-txt" style="height: 5.4rem;">El desarrollo web me ha permitido desarrollar persistencia y
        resposabilidad personal ...</p>`;
        //console.log("texto corto");
        btnState[1] = false;
    } else {
        esdras.innerHTML = `
        <p class="desc-txt" style="height: 9rem;">El desarrollo web me ha permitido desarrollar persistencia y resposabilidad personal al buscar soluciones creativas mediante la programación y el diseño.</p>`;
        //console.log("texto largo");
        btnState[1] = true;
    }
});

btnAlan.addEventListener("click", function (event) {
    event.preventDefault();
    if (btnState[2]) {
        alan.innerHTML = `
        <p class="desc-txt" style="height: 5.4rem;">Desarrollador Java Full Stack Junior con un fuerte interés en la
        tecnología y la ...</p>`;
        //console.log("texto corto");
        btnState[2] = false;
    } else {
        alan.innerHTML = `
        <p class="desc-txt"style="height: 9rem;">Desarrollador Java Full Stack Junior con un fuerte interés en la tecnología y la programación, busco aportar mi experiencia y habilidades al éxito de proyectos innovadores.</p>`;
        //console.log("texto largo");   
        btnState[2] = true;
    }
});

btnJavier.addEventListener("click", function (event) {
    event.preventDefault();
    if (btnState[3]) {
        javier.innerHTML = `
        <p class="desc-txt" style="height: 4.2rem;">Soy un apasionado desarrollador Full Stack Java Jr con estudios
        en ingeniería de ...</p>`;
        //console.log("texto corto");
        btnState[3] = false;
    } else {
        javier.innerHTML = `
        <p class="desc-txt" style="height: 11rem;">Soy un apasionado desarrollador Full Stack Java Jr con estudios en ingeniería de software y en ingeniería mecánica.  he adquirido experiencia en el desarrollo de aplicaciones web y tengo habilidades tanto en el frontend como en el backend.</p>`;
        //console.log("texto largo");
        btnState[3] = true;
    }
});

btnJesus.addEventListener("click", function (event) {
    event.preventDefault();
    if (btnState[4]) {
        jesus.innerHTML = `
        <p class="desc-txt" style="height: 4.2rem;">Profesional y apasionado realizando los proyectos y
        proyecciones de un trabajo ...</p>`;
        //console.log("texto corto");
        btnState[4] = false;
    } else {
        jesus.innerHTML = `
        <p class="desc-txt" style="height: 11rem;">Profesional y apasionado  realizando los proyectos y proyecciones  de un trabajo demostrando mejores resultados  quedando a la apertura de seguir conociendo, entusiasmado por lo nuevo.</p>`;
        //console.log("texto largo");
        btnState[4] = true;
    }
});

btnAna.addEventListener("click", function (event) {
    event.preventDefault();
    if (btnState[5]) {
        ana.innerHTML = `
        <p class="desc-txt" style="height: 4.2rem;">Cuento con una alta capacidad para resolver problemas de manera
        eficiente y colaborar ...</p>`;
        //console.log("texto corto");
        btnState[5] = false;
    } else {
        ana.innerHTML = `
        <p class="desc-txt" style="height: 11rem;">Cuento con una alta capacidad para resolver problemas de manera eficiente y colaborar con equipos. Busco agregar valor y desarrollar mis habilidades dentro de futuros proyectos.</p>`;
        //console.log("texto largo");
        btnState[5] = true;
    }
});

/**btnBrian.addEventListener("click", function (event) {
    event.preventDefault();
    if (btnState[6]) {
        brian.innerHTML = `
        <p class="desc-txt" style="height: 4rem;">¡Hola! Soy analista de datos, desarrollador de video-juegos y
        artista digital en ...</p>`;
        //console.log("texto corto");
        btnState[6] = false;
    } else {
        brian.innerHTML = `
        <p class="desc-txt" style="height: 8.4rem;">¡Hola! Soy analista de datos, desarrollador de video-juegos y artista digital en México. Me gusta la programación creativa para expresarme de forma artística.</p>`;
        //console.log("texto largo");
        btnState[6] = true;
    }
});*/

btnAlexia.addEventListener("click", function (event) {
    event.preventDefault();
    if (btnState[7]) {
        alexia.innerHTML = `
        <p class="desc-txt" style="height: 4rem;">Soy Alexia Mata, desarrolladora Fullstack con habilidades para crear aplicaciones ...</p>
        `;
        //console.log("texto corto");
        btnState[7] = false;
    } else {
        alexia.innerHTML = `
        <p class="desc-txt" style="height: 8.4rem;">Soy Alexia Mata, desarrolladora Fullstack con habilidades para crear aplicaciones web dinámicas y escalables. Me interesan la ciberseguridad y las redes neuronales artificiales</p>
        `;
        //console.log("texto largo");
        btnState[7] = true;
    }
});