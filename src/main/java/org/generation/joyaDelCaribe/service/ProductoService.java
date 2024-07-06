package org.generation.joyaDelCaribe.service;

import java.util.List;
import java.util.Optional;

import org.generation.joyaDelCaribe.model.Producto;
import org.generation.joyaDelCaribe.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductoService {
	public final ProductoRepository productoRepository;
	
	@Autowired
	public ProductoService(ProductoRepository productoRepository) {
		this.productoRepository = productoRepository;
	}

	public List<Producto> getAllProductos() {
		return productoRepository.findAll();
	}

	public Producto getProducto(Long id) {
		return productoRepository.findById(id).orElseThrow(
				()->new IllegalArgumentException("El producto con el id ["+id+"] no existe")
				);
	}

	public Producto deleteProducto(Long id) {
		Producto tmpProd = null;
		if (productoRepository.existsById(id)) {
			tmpProd = productoRepository.findById(id).get();
			productoRepository.deleteById(id);
		}
		return tmpProd;
	}

	public Producto addProducto(Producto producto) {
		Optional<Producto> tmpProd = productoRepository.findByName(producto.getName());
		if(tmpProd.isEmpty()) {
			return productoRepository.save(producto);
		}else {
			System.out.println("El producto con el nombre [] ya existe");
			return null;
		}//else
	}

	public Producto updateProducto(Long id, String name, String product, Double price, String image, String category, String description,
			Double discount, Integer idUser, Integer idOrden) {
		Producto tmpProd = null;
			if(productoRepository.existsById(id)) {
				Producto producto=productoRepository.findById(id).get();
                if (name != null){producto.setName(name);}
                if (product != null){producto.setProduct(product);}
                if (price != null){producto.setPrice(price);}
                if (image != null){producto.setImage(image);}
                if (category != null){producto.setCategory(category);}
                if (description != null){producto.setDescription(description);}
                if (discount != null){producto.setDiscount(discount);}
                //if (idUser != null){producto.setIdUser(idUser);}
                //if (idOrden != null){producto.setIdOrden(idOrden);}
                productoRepository.save(producto);
				tmpProd=producto;
			}
		return tmpProd;
	}
	
}