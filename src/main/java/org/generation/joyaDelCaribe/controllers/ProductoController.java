package org.generation.joyaDelCaribe.controllers;

import java.util.ArrayList;
import java.util.Date;

import org.generation.joyaDelCaribe.model.Producto;
import org.generation.joyaDelCaribe.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/productos/")
public class ProductoController {
    private final ProductoService productoService;
    
    @Autowired
    public ProductoController(ProductoService productoService) {
        this.productoService = productoService;
    }   
    
    @GetMapping
    public ArrayList<Producto> getProductos(){
        return productoService.getAllProductos();
    }
    
    @GetMapping(path = "{productoId}")
    public Producto getProducto(@PathVariable("productoId") int id) {
        return productoService.getProducto(id);
    }
    
    @DeleteMapping(path = "{productoId}")
    public Producto deleteProducto(@PathVariable("productoId") int id) {
        return productoService.deleteProducto(id);
    }
    
    @PostMapping
    public Producto addProducto(@RequestBody Producto producto) {
        return productoService.addProducto(producto);
    }
    
    @PutMapping(path = "{productoId}")
    public Producto updateProducto(@PathVariable("productoId") int id,
			@RequestParam(required = false) String name,
			@RequestParam(required = false) String product,
			@RequestParam(required = false) Double price,
			@RequestParam(required = false) String image,
			@RequestParam(required = false) String category,
			@RequestParam(required = false) String description,
			@RequestParam(required = false) Double discount,
			@RequestParam(required = false) Integer idUser,
			@RequestParam(required = false) Integer idOrden){
        return productoService.updateProducto(id, name,product,price, image, category, description,
    			discount, idUser,idOrden);
    }
    
}

