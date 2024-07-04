package org.generation.joyaDelCaribe.service;

import java.util.ArrayList;
import java.util.Date;

import org.generation.joyaDelCaribe.model.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductoService {
	ArrayList<Producto> listaProducto = new ArrayList<Producto>();
	
	@Autowired
	public ProductoService() { // Va a agregarle datos a la lista 
		listaProducto.add( new Producto("Frescura Marina", "Tónico Facial con Ácido Hialurónico", 499.00,
				"frescuraMarina.webp","SkinCare","Revitaliza tu piel con cada lavada gracias a "
				+ "nuestro limpiador Frescura Marina, que limpia profundamente mientras mantiene "
				+ "la hidratación natural de tu piel.",0.0,5,8));
		listaProducto.add(  new Producto("Bruma de Cenote", "Limpiador facial suave", 559.00,
				"brumaCenote.webp","SkinCare","Refresca y prepara tu piel con la hidratación del "
				+ "ácido hialurónico inspirado en las aguas cristalinas de los cenotes del "
				+ "Caribe.",0.0,3,7));
		listaProducto.add(  new Producto("Cobertura de Coral", "Corrector", 129.00,
				"coberturaDeCoral.webp","Maquillaje","Cubre imperfecciones y ojeras eficazmente"
				+ " con nuestro corrector inspirado en la robustez y belleza del coral.",0.15,4,7));
		
	}

	public ArrayList<Producto> getAllProductos() {
		return listaProducto;
	}

	public Producto getProducto(int id) {
		Producto tmpProducto = null;
		for (Producto producto : listaProducto) {
			if(producto.getIdProducto() == id) {
				tmpProducto = producto;
				break;
			}
		}
		return tmpProducto;
	}

	public Producto deleteProducto(int id) {
		Producto tmpProducto = null;
		for (Producto producto : listaProducto) {
			if(producto.getIdProducto() == id) {
				tmpProducto = producto;
				listaProducto.remove(listaProducto.indexOf(producto));
				break;
			}
		}
		return tmpProducto;
	}

	public Producto addProducto(Producto producto) {
		Producto tmpProducto = null;
		boolean productoExists = false;
		for (Producto ord : listaProducto) {
			if(ord.getIdProducto() == producto.getIdProducto()) {
				productoExists = true;
				break;
			}
		}
		if(!productoExists) {
			listaProducto.add(producto);
			tmpProducto = producto;
		}
		return tmpProducto;
	}

	public Producto updateProducto(int id, String name, String product, Double price, String image, String category, String description,
			Double discount, Integer idUser, Integer idOrden) {
		Producto tmpProducto = null;
		for (Producto producto : listaProducto) {
			if(producto.getIdProducto() == id) {
                if (name != null){producto.setName(name);}
                if (product != null){producto.setProduct(product);}
                if (price != null){producto.setPrice(price);}
                if (image != null){producto.setImage(image);}
                if (category != null){producto.setCategory(category);}
                if (description != null){producto.setDescription(description);}
                if (discount != null){producto.setDiscount(discount);}
                if (idUser != null){producto.setIdUser(idUser);}
                if (idOrden != null){producto.setIdOrden(idOrden);}
				tmpProducto = producto;
				break;
			}
		}
		return tmpProducto;
	}
}

