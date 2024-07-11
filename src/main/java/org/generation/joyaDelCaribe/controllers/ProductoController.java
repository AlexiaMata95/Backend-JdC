package org.generation.joyaDelCaribe.controllers;

import java.util.List;

import org.generation.joyaDelCaribe.model.Producto;
import org.generation.joyaDelCaribe.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
@CrossOrigin(origins = {"http://127.0.0.1:5501/", "https://baomasu.github.io/JoyaDelCaribe/"})
@RestController
@RequestMapping(path = "/api/productos/")
public class ProductoController {
    private final ProductoService productoService;
    
    @Autowired
    public ProductoController(ProductoService productoService) {
        this.productoService = productoService;
    }   
    
    @GetMapping
    public List<Producto> getProductos(){
        return productoService.getAllProductos();
    }
    
    @GetMapping(path = "{productoId}")
    public Producto getProducto(@PathVariable("productoId") Long id) {
        return productoService.getProducto(id);
    }
    
    @DeleteMapping(path = "{productoId}")
    public Producto deleteProducto(@PathVariable("productoId") Long id) {
        return productoService.deleteProducto(id);
    }
    
    @PostMapping
    public Producto addProducto(@RequestBody Producto producto) {
        return productoService.addProducto(producto);
    }
    
    @PutMapping(path = "{productoId}")
    public Producto updateProducto(@PathVariable("productoId") Long id,
			@RequestParam(required = false) String nombre,
			@RequestParam(required = false) String producto,
			@RequestParam(required = false) Double precio,
			@RequestParam(required = false) String imagen,
			@RequestParam(required = false) String categoria,
			@RequestParam(required = false) String descripcion,
			@RequestParam(required = false) Double descuento){
        return productoService.updateProducto(id, nombre,producto,precio, imagen, categoria, descripcion,
    			descuento);
    };
   
}

