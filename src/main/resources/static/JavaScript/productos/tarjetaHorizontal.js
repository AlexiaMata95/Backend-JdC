let isMobile = false; // Variables para identificar si el tamaño de pantalla corresponde a mobile o tablet
let isTablet = false;
let products = []; // Arreglo que almacenará los productos
let carouselsConfig = [
    { id: 'carousel-container', conditionForRender: product => product.descuento > 0, tituloH1: 'Nuestros Descuentos' },
    { id: 'carousel-containerBS', conditionForRender: product => product.descuento == 0, tituloH1: 'Los más vendidos' }
];

const debouncedUpdateSize = debounce(updateSize, 200); // Esta función evita que la función updateSize cambie los booleanos de mobile y tablet muchas veces
window.addEventListener('resize', debouncedUpdateSize); // EventListener para cada vez que se ajuste el tamaño de pantalla

function debounce(func, wait) { // Función debounce espera una función y una cantidad en milisegundos como argumentos
    let timeout; // Se declara el almacenador del setTimeout
    return function (...args) { // Se devuelve una nueva función que encapsula el funcionamiento del debounce
        const context = this; // Preserva el valor de this
        clearTimeout(timeout); // Limpia el timeout en caso de que vuelva a ejecutarse uno nuevo antes de finalizar el anterior
        timeout = setTimeout(() => { // Función timeout para retrasar la ejecución de la función hasta que el evento resize finalice
            func.apply(context, args); // Llama a la función original dentro de su contexto y sus argumentos originales
        }, wait);
    };
}

function updateSize() { // Función para actualizar los booleanos de mobile o tablet
    isMobile = window.innerWidth <= 576;
    isTablet = window.innerWidth <= 991 && window.innerWidth >= 577;
    renderAllCarousels(); // Volver a renderizar los items del carrusel
}

function getData(carouselConfig) { // Obtener datos del JSON
    fetch('/api/productos/', { method: 'GET' })
        .then(response => {
            if (!response.ok) {
                throw new Error('Network response was not ok ' + response.statusText);
            }
            return response.json();
        })
        .then(productList => {
            console.log('Response JSON:', productList); // Utiliza console.log para ver la respuesta completa
            if (!Array.isArray(productList)) {
                throw new Error('Expected an array but got ' + typeof productList);
            }
            products = productList;
            renderCarouselItems(carouselConfig.id, products, carouselConfig.conditionForRender, carouselConfig.tituloH1);
        })
        .catch(error => {
            console.log('Hubo un problema con el JSON ' + error);
        });
}

function renderAllCarousels() {
    carouselsConfig.forEach(config => getData(config));
}

function renderCarouselItems(carouselId, productList, condition, title) {
    console.log('Renderizando carrusel:', carouselId, productList, condition, title); // Depuración
    const carouselContainer = document.getElementById(carouselId);
    if (!document.getElementById(`${carouselId}-title`)) {
        carouselContainer.insertAdjacentHTML('beforebegin', `
            <h1 id="${carouselId}-title" class="m-4 text-center">${title}</h1>
        `);
    }
    carouselContainer.innerHTML = ''; // Limpiar el contenido anterior
    let carouselItem = null;
    let containerItem = null;
    let rowItem = null;
    let indexCounter = 0;

    function createNewCarouselItem() {
        carouselItem = document.createElement('div');
        carouselItem.classList.add('carousel-item');
        if (indexCounter === 0) {
            carouselItem.classList.add('active');
        }

        containerItem = document.createElement('div');
        containerItem.classList.add('container');
        rowItem = document.createElement('div');
        rowItem.classList.add('row', 'justify-content-center');

        containerItem.appendChild(rowItem);
        carouselItem.appendChild(containerItem);
        carouselContainer.appendChild(carouselItem);
    }

    productList.filter(product => {
        console.log('Condición de filtro:', condition(product), product); // Depuración
        return condition(product);
    }).forEach((product, i) => {
        console.log('Producto después del filtro:', product); // Depuración
        const itemsPerSlide = isMobile ? 1 : isTablet ? 2 : 3;
        if (!carouselItem || (indexCounter % itemsPerSlide === 0 && i !== 0)) {
            createNewCarouselItem();
        }
        indexCounter++;
        rowItem.insertAdjacentHTML('beforeend', `
            <div class="col-sm-12 col-md-6 col-lg-4">
                <div class="card mb-7 my-4 rounded-4 justify-content-center" style="width: 100%; height: 320px;">
                    <div class="row g-0 align-items-center h-100">
                        <div class="col-7 h-100 rounded-4 bg-cover" style="background-image:url(${product.imagen}) !important; background-size: cover; background-position: center;">
                            <span class="position-absolute top-0 start-0 badge text-bg-danger" style="margin-top: 2rem; ${product.descuento == 0 ? "display: none;" : " "}">
                                -${product.descuento*100}%
                            </span>
                        </div>
                        <div class="col-5">
                            <div class="card-body">
                                <h5 class="card-title fs-4">${product.nombre}</h5>
                                <p class="card-text price mt-md-5 mt-sm-1">$${Math.floor(product.precio - (product.precio * product.descuento ))}  <span class="badge text-bg-danger" style="${product.descuento == 0.0 ? "display: none;" : " "}">-${product.descuento*100}%</span></p>
                                <p class="card-text priceWithoutDiscount" style="text-decoration: line-through;${product.descuento == 0 ? "display: none;" : " "}">$ ${product.precio}.00</p>
                                <p class="card-text mt-5" style="display: flex;justify-content: flex-end;">
                                    <a href="#"><img src="./src/assets/shopCart.png" alt="Carrito de compras" style="width: 2rem; margin: 0.2rem 0.4rem;"></a>
                                    <a href="#"><img src="./src/assets/whiteHeart.png" alt="Favorito" style="width: 2rem; margin: 0.2rem 0.4rem;"></a>
                                </p>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        `);
    });

    const firstCarouselItem = document.querySelector(`#${carouselId} .carousel-item`);
    if (firstCarouselItem) {
        firstCarouselItem.classList.add('active');
    }
}

updateSize();
