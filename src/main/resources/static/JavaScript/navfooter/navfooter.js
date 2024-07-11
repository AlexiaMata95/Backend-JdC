let main = document.getElementsByTagName('main')[0];

// obtener token de localStorage
let token = localStorage.getItem('token');
// obtener email de localStorage
let email = localStorage.getItem('email');

function buscarUsuario(token) {
    return new Promise((resolve, reject) => {
        const myHeaders = new Headers();
        myHeaders.append("Authorization", token);

        const requestOptions = {
            method: "GET",
            headers: myHeaders,
            redirect: "follow"
        };

        fetch("/api/usuarios/", requestOptions)
            .then((response) => response.json())
            .then((result) => {
                
                if (token && email) {
                    let encontrado = false; // Indicador si se encontró el usuario
                    result.forEach(usuario => {
                        if(usuario.correo == email){
                            nombreCuenta = usuario.nombre;
                            console.log("Nombre de la cuenta: "+usuario.nombre);
                            console.log("Correo de la cuenta: "+usuario.correo);
                            encontrado = true;
                        }
                    });
                    if (!encontrado) {
                        nombreCuenta = "Iniciar Sesión";
                    }
                    resolve(nombreCuenta); // Resuelve la promesa con el valor de nombreCuenta
                } else {
                    reject("Token o email no proporcionado");
                }
            })
            .catch((error) => {
                console.error(error);
                reject(error); // Rechaza la promesa si hay un error
            });
    });
}

async function iniciar() {
    try {
        const nombre = await buscarUsuario(token); // Espera a que buscarUsuario se complete
        // Actualiza el DOM directamente aquí
        document.querySelector('#nombreCuenta').textContent = nombre;
    } catch (error) {
        console.error("Error al buscar usuario:", error);
    }
}

// Llama a iniciar en el momento adecuado, por ejemplo, después de cargar el DOM
if(token && email){
    document.addEventListener('DOMContentLoaded', iniciar);
}



    main.insertAdjacentHTML('beforebegin', `
        <div class="border-bottom py-2 bg-light">
        <div class="container">
            <div class="row">
                <div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
                    <span class="d-none d-lg-inline-block d-md-inline-block d-sm-inline-block d-xs-none me-3"><strong><i
                                class="bi bi-envelope-open-fill"></i> info@joyadelcaribe.com</strong></span>
                    <span class="me-3">
                        <strong><i class="bi bi-telephone-fill"></i> +52-55-1234-5678</strong></span>
                </div>
                <div
                    class="col-lg-6 col-md-6 col-sm-12 col-xs-12 d-none d-lg-block d-md-block-d-sm-block d-xs-none text-end">
                    <span class="me-3">Obtén un 20% de descuento en tu primer pedido. <a class="text-muted" href="../../registro.html"> Regístrate.</a></span>
                </div>
            </div>
        </div>
    </div>
    <nav class="navbar navbar-expand-lg bg-white sticky-top navbar-light shadow-sm p-0">
        <div class="container">
            <a class="navbar-brand" href="../../index.html"><img src="../../src/assets/profilePictures/Logo.png" alt="Logo"
                    style="width: 100px;"></a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavDropdown"
                aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class=" collapse navbar-collapse" id="navbarNavDropdown">
                <ul class="navbar-nav ms-auto ">
                    <li class="nav-item">
                        <a class="nav-link mx-2 text-uppercase" aria-current="page"
                            href="../../index.html">Inicio</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link mx-2 text-uppercase" href="../../producto.html">Productos</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link mx-2 text-uppercase" href="../../nosotros.html">Nosotros</a>
                    </li>
                    <li class="nav-item" id="agregarProducto">
                        <a class="nav-link mx-2 text-uppercase" href="../../miPerfil.html">Agregar Producto</a>
                    </li>
                </ul>
                    <ul class="navbar-nav ms-auto">
                        <div class="dropdown mb-3">
                            <a class="btn btn-secondary dropdown-toggle mx-2 text-uppercase" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                                <i class="bi bi-person-check-fill"></i> <span id="nombreCuenta">Cuenta</span>
                            </a>
                            <ul class="dropdown-menu">
                                <li><a class="dropdown-item" href="../../iniciosesion.html">Iniciar Sesión</a></li>
                                <li><a class="dropdown-item" href="../../registro.html">Registrarse</a></li>
                                <li><hr class="dropdown-divider"></li>
                                <li><a class="dropdown-item" onclick="cerrarSesion();" href="../../iniciosesion.html"><i class="bi bi-box-arrow-right"></i> Cerrar Sesión</a></li>
                            </ul>
                        </div>
                    </ul>
            </div>
        </div>
    </nav>
        `);

    main.insertAdjacentHTML('afterend',`
        <footer class="footer-section">
        <!-- row de bootstrap para definir una fila horizontal -->
        <!-- mx-auto es un margin en x de auto para centrar el contenido -->
        <!-- pt-5 es un padding en la parte superior de 5 -->
        <div class="container row mx-auto pt-5">
            <!-- col-md-6 col-lg-4 es una columna de 6 en dispositivos medianos y 4 en grandes -->
            <!-- px-5 py-3 es un padding en x de 5 y en y de 3 -->
            <div class="col-md-6 col-lg-4 px-5 py-3">
                <!-- La etiqueta i es un icono de bootstrap -->
                <h5><i class="bi bi-bag-check px-2"></i>JOYA DEL CARIBE</h5>
                <!-- La etiqueta ul es una lista no ordenada -->
                <!-- dflex y flex-column son clases de bootstrap para alinear los elementos en columna -->
                <ul class="d-flex flex-column">
                    <!-- La etiqueta i es un icono de bootstrap -->
                    <a href="./iniciosesion.html"><i class="bi bi-caret-right-fill"></i><strong>Iniciar sesión</strong></a>
                    <a href="./miPerfil.html"><i class="bi bi-caret-right-fill"></i><strong>Mi cuenta</strong></a>
                    <a href="./micarrito.html"><i class="bi bi-caret-right-fill"></i><strong>Mis pedidos</strong></a>
                </ul>
                <p>
                    Somos una empresa mexicana 100% comprometida con la comercialización de cosméticos y productos de
                    cuidado personal. Nos destacamos por nuestras fórmulas innovadoras, tecnología de vanguardia e
                    ingredientes de la más alta calidad.</p>
            </div>
            <div class="col-md-6 col-lg-4 px-5 py-3">
                <h5><i class="bi bi-truck px-2"></i>COSTOS Y TIEMPOS DE ENTREGA</h5>
                <p>El costo de envío a México comienza desde $120 MXN (dependiendo del peso de los productos). Enviamos
                    productos en stock en un plazo de 24 horas. <strong><a href="">(Consultar detalles)</a></strong></p>
                <h5><i class="bi bi-patch-check px-2"></i>DEVOLUCIÓN O CAMBIO</h5>
                <p>Los productos comprados se pueden devolver o cambiar dentro de los 14 días posteriores a la entrega.
                    <strong><a href="">(Consultar detalles)</a></strong></p>
            </div>
            <div class="col col-lg-4 px-5 py-3">
                <!-- la etiqueta i es un icono de bootstrap -->
                <h5><i class="bi bi-envelope px-2"></i>¿QUIERES MÁS DE JOYA DEL CARIBE?</h5>
                <p>Recibe los lanzamientos de productos, ofertas e historias más importantes directamente en tu
                    teléfono, además de un 20% de descuento en tu próximo pedido.</p>
                <form>
                    <!-- form-control es una clase de bootstrap para dar estilo a los inputs -->
                    <input type="email" placeholder="Correo electrónico" class="form-control" id="correo-footer">
                    <!-- btn y btn-light es una clase de bootstrap para dar estilo a los botones -->
                    <!-- mt-2 es un margin top de 2 y w-100 es un width de 100% -->
                    <button type="button" class="btn btn-light mt-2 w-100"
                        style="color: #450920;" id="btn-subscribir"><strong>Suscribirse</strong></button>
                </form>
                <!-- d-flex es una clase de bootstrap para alinear los elementos en fila -->
                <!-- justify-content-between es una clase de bootstrap para alinear los elementos con espacio entre ellos -->
                <div class="py-3 d-flex justify-content-between">
                    <!-- fs-3 es una clase de bootstrap para dar un tamaño de fuente de 3 -->
                    <a href="https://www.facebook.com/" target="_blank"><i class="bi bi-facebook fs-3"></i></a>
                    <a href="https://www.instagram.com/" target="_blank"><i class="bi bi-instagram fs-3"></i></a>
                    <a href="https://x.com/" target="_blank"><i class="bi bi-twitter-x fs-3"></i></a>
                    <a href="https://www.tiktok.com/" target="_blank"><i class="bi bi-tiktok fs-3"></i></a>
                    <a href="https://www.pinterest.com/" target="_blank"><i class="bi bi-pinterest fs-3"></i></a>
                    <a href="https://www.youtube.com/" target="_blank"><i class="bi bi-youtube fs-3"></i></a>
                </div>
            </div>
        </div>
        <!-- text-center es una clase de bootstrap para centrar el texto -->
        <div class="container text-center">
            <p><strong>© 2024 Joya del Caribe. Todos los derechos reservados.</strong></p>
        </div>
        <!-- la clase footerPago es una clase de CSS para cambiar el color de fondo -->
        <div class="footerPago p-3">
            <!-- d-flex es una clase de bootstrap para alinear los elementos en fila -->
            <!-- flex-wrap es una clase de bootstrap para que los elementos se ajusten al tamaño del contenedor -->
            <!-- justify-content-center es una clase de bootstrap para alinear los elementos al centro -->
            <div class="d-flex flex-wrap justify-content-center">
                <img src="src/assets/footer/PayPal.svg" alt="Icono PayPal" class="py-2 px-3">
                <img src="src/assets/footer/Apple.svg" alt="Icono Apple" class="py-2 px-3">
                <img src="src/assets/footer/Visa.svg" alt="Icono Visa" class="py-2 px-3">
                <img src="src/assets/footer/Amex.svg" alt="Icono Amex" class="py-2 px-3">
                <img src="src/assets/footer/Mastercard.svg" alt="Icono Mastercard" class="py-2 px-3">
                <img src="src/assets/footer/Maestro.svg" alt="Icono Maestro" class="py-2 px-3">
            </div>
        </div>
    </footer>
        `);

function initializeFooterButton() {
    let correof = document.getElementById("correo-footer"); //correo
    let btnSub = document.getElementById("btn-subscribir"); //botón de enviar.

    let isValidf = true;
    let contadorf = true;
    let erCorreof = /^[-\w.%+]{1,64}@(?:[A-Z0-9-]{1,63}\.){1,125}[A-Z]{2,63}$/i;

    if (btnSub && correof) {
        btnSub.addEventListener("click", function (event) {
            event.preventDefault();
            correof.style.border = "";
            isValidf = true;
            if (!erCorreof.test(correof.value) && contadorf == true) { //validación para correo
                correof.style.border = "solid red medium";
                isValidf = false;
            }

            if (isValidf && contadorf) {
                console.log(correof.value.toLowerCase())
                correof.value = "";
                correof.style.border = "";
                btnSub.innerHTML = `<strong>Suscrito</strong>`;
                contadorf = false;
            }
        });
    } else {
        console.error("Elementos del DOM no encontrados");
    }
}

initializeFooterButton();

function cerrarSesion() {
// borrar email de localStorage
localStorage.removeItem('email');
localStorage.removeItem('token');
}

