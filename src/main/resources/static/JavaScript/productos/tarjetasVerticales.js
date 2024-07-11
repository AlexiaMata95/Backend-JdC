const tarjetas = document.getElementById("tarjetas-verticales");
const mostrarTodo = document.getElementById("mostrar-todo");

// verificar si existe productos en el localStorage
// if (!localStorage.getItem('productos')) {
//     getData();
// } else {
//     listarProductos(JSON.parse(localStorage.getItem('productos')));
// }

mostrarTodo.addEventListener('click', () => {
    tarjetas.innerHTML = '';
    const requestOptions = {
        method: "GET",
        redirect: "follow"
    };

    fetch("/api/productos/", requestOptions)
        .then((response) => response.text())
        .then((result) => {
            listarProductos(JSON.parse(result));
        })
        .catch((error) => console.error(error));
});

function getData() {
    const requestOptions = {
        method: "GET",
        redirect: "follow"
    };

    fetch("/api/productos/", requestOptions)
        .then((response) => response.text())
        .then((result) => {
            listarProductos(JSON.parse(result));
        })
        .catch((error) => console.error(error));
}

getData();

function listarProductos(productos) {
    productos.forEach(product => {
        tarjetas.insertAdjacentHTML("beforeend", ` 
            <div class="card shadow rounded-bottom-5 p-0" style="width: 16rem;">
                <img src="${product.imagen}" class="card-img-top" alt="">
                <div class=" card-body p-4">
                    <p class="card-title text-end" style="color: gray;">${product.categoria}</p>
                    <h5 class="card-title">${product.nombre}</h5>
                    <div class="d-flex align-items-center mt-3">
                        <span class="h6 mb-0">${descuentoTotal(product.descuento, product.precio)}</span>
                        <span class="badge bg-danger me-2 ms-2">${descuento(product.descuento)}</span>
                    </div>
                    <div class="d-flex align-items-center justify-content-between flex-row-reverse mt-2">
                        <button type="button" class="btn btn-dark btnDetalles rounded-4" data-bs-toggle="modal" data-bs-target="#${product.idproductos}">Detalles</button>    
                        <span class="h6 mb-0 text-decoration-line-through" style="color: gray;">${costoTotal(product.descuento, product.precio)}</span>
                        
                        <div class="modal fade" id="${product.idproductos}" tabindex="-1" aria-labelledby="${product.idproductos}" aria-hidden="true">
                            <div class="modal-dialog modal-dialog-centered">
                                <div class="modal-content">
                                    <div class="modal-header">
                                        <h1 class="modal-title fs-5" id="${product.idproductos}">${product.nombre}</h1>
                                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                                    </div>
                                    <div class="modal-body">${product.descripcion}</div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
`);
    });
}

document.querySelectorAll('.categoria-btn').forEach(btn => {
    btn.addEventListener('click', function () {
        const categoria = this.getAttribute('data-categoria');
        const requestOptions = {
            method: "GET",
            redirect: "follow"
        };

        fetch("/api/productos/", requestOptions)
            .then((response) => response.text())
            .then((result) => {
                result = JSON.parse(result);
                const productosFiltrados = result.filter(productos => productos.categoria === categoria);
                tarjetas.innerHTML = '';
                listarProductos(productosFiltrados);
            })
            .catch((error) => console.error(error));

        // hacer filtrado desde local storage
        //const productos = JSON.parse(localStorage.getItem('productos'));



        // fetch('../JSONS/productosURL.json')
        //     .then(response => response.json())
        //     .then(productos => {
        //         console.log(productos);
        //         const productosFiltrados = productos.productos.filter(productos => productos.category === categoria);
        //         console.log(productosFiltrados);
        //         tarjetas.innerHTML = '';
        //         listarProductos(productosFiltrados);
        //     });
    });
});

function descuento(discount) {
    if (discount === 0) {
        return '';
    } else {
        return (discount * 100) + '%';
    }
}

function costoTotal(discount, precio) {
    if (discount === 0) {
        return '';
    } else {
        return '$' + precio;
    }
}

function descuentoTotal(discount, precio) {
    if (discount === 0) {
        return '$' + precio;
    } else {
        let operation = precio - (precio * discount);
        return '$' + operation.toFixed(2);
    }
}