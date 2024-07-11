let isMobile = false; //Variables para identificar si el tamanio de pantalla corresponde a mobile o tablet
let isTablet = false;
let products = []; //Arreglo que almacenara los productos
let carouselsConfig = [
    {id: 'carousel-container', conditionForRender: product => product.discount > 0, tituloH1 : 'Nuestros Descuentos'},
    {id: 'carousel-containerBS', conditionForRender: product => product.discount == 0, tituloH1 : 'Los más vendidos'}
]

const debouncedUpdateSize = debounce(updateSize, 200); // Esta funcion evita que la funcion updateSize cambie los booleanos de mobile y tablet muchas veces
window.addEventListener('resize', debouncedUpdateSize); //eventListener para cada vez que se ajuste el tamaño de pantalla

function debounce(func, wait) { //Funcion debounce espera una funcion y una cantidad en milisegundos como argumentos
    let timeout; //Se declara el almacenador del setTimeout
    return function(...args) { //Se devuelve una nueva funcion que encapsula el funcionamiento del debounce
                               //esta funcion se ejecuta en lugar de la funcion introducida como argumento
        const context = this; //Preserva el valor de this
        clearTimeout(timeout); //Limpia el timeout en caso de que vuelva a ejecutarse uno nuevo antes de finalizar el anterior
        timeout = setTimeout(() => { //funcion timeout para retrasar la ejecucion de la funcion hasta que el evento resize finalice
            func.apply(context, args); //Llama a la funcion original dentro de su contexto y sus argumentos originales
        }, wait);
    };
}
function updateSize() { //Funcion para actualizar los booleanos de mobile o tablet
    isMobile = window.innerWidth <= 576; 
    isTablet = window.innerWidth <= 991 && window.innerWidth >= 577;
    renderAllCarousels(); //Volver a renderizar los items del carrusel
}

function getData(carouselConfig) { //Obtener datos del JSON
    fetch('../JSONS/productos.json', { method: 'GET' })
        .then((response) => response.json()) //Si existe una respuesta, crea una nueva promesa y convierte la respuesta a JSON
        .then((productObj) => { //Si existe respuesta, llama productObj al nuevo json obtenido
            products = productObj.productos; //Guarda el arreglo productos de productObj en la variable products
            renderCarouselItems(carouselConfig.id,products, carouselConfig.conditionForRender, carouselConfig.tituloH1); //Renderiza los items del carrusel
        })
        .catch((error) => {
            console.log('Hubo un problema con el JSON ' + error); 
        });
}

function renderAllCarousels() {
    carouselsConfig.forEach(config => getData(config));
}

function renderCarouselItems(carouselId, productList, condition, title) {
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


    productList.filter(condition).forEach((product, i) => {
            const itemsPerSlide = isMobile ? 1 : isTablet ? 2 : 3;
            if (!carouselItem || (indexCounter % itemsPerSlide === 0 && i !== 0)) {
                createNewCarouselItem(carouselContainer);
            }
            indexCounter++;
            rowItem.insertAdjacentHTML('beforeend', `
                <div class="col-sm-12 col-md-6 col-lg-4" >
                    <div class="card mb-7 my-4 rounded-4 justify-content-center" style="width: 100%; height: 320px;">
                        <div class="row g-0 align-items-center h-100">
                            <div class="col-7 h-100 rounded-4 bg-cover" style="background-image:url(./src/assets/productssrc/${product.img}) !important; background-size: cover; background-position: center;">
                                <span class="position-absolute top-0 start-0 badge text-bg-danger" style="margin-top: 2rem; ${product.discount == 0 ? "display: none;": " " }">
                                    -${product.discount}%
                                </span>
                            </div>
                            <div class="col-5">
                                <div class="card-body">
                                    <h5 class="card-title fs-4">${product.name}</h5>
                                    <p class="card-text price mt-md-5 mt-sm-1">$${product.price - (product.price * product.discount / 100)}  <span class="badge text-bg-danger" style="${product.discount == 0 ? "display: none;": " " }">-${product.discount}%</span></p>
                                    <p class="card-text priceWithoutDiscount" style="text-decoration: line-through;${product.discount == 0 ? "display: none;": " " }">$ ${product.price}.00</p>
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
        }
    );
    const firstCarouselItem = document.querySelector(`#${carouselId} .carousel-item`);
    if (firstCarouselItem) {
        firstCarouselItem.classList.add('active');
    }

 
}
updateSize();
