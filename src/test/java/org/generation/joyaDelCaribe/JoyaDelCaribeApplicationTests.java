package org.generation.joyaDelCaribe;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.generation.joyaDelCaribe.model.Producto;
import org.generation.joyaDelCaribe.model.Rol;
import org.generation.joyaDelCaribe.model.Usuario;
import org.generation.joyaDelCaribe.model.ChangePassword;



@SpringBootTest
@AutoConfigureMockMvc
class JoyaDelCaribeApplicationTests {
	@Autowired 
	private MockMvc mockMvc; //Autogenerar Mvc
	
	private final String token = "Bearer: eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJwYXNzQGdtYWlsLmNvbSIsInJvbGUiOiJBRE1JTklTVFJBRE9SIiwiaWF0IjoxNzIwNDY0NjU0LCJleHAiOjE3MjA1MDA2NTR9.Bpeh5Z_fZ0TM1sdW3OkUrx5QCrnRchQKX7UoErHtoxU";

	// Test productos ------------------------------------------------------------------
	@Test
	@DisplayName("Se prueba el GET del endpoint http://localhost:8080/api/productos/1")
	@Disabled("Probado una vez, deshabilitado porque ya no existe el producto id 4")
	void pruebaGET() throws Exception {
		this.mockMvc.perform(get("/api/productos/1"))
		.andDo(print())
		.andExpect(status().isOk())
		.andExpect(content().string(containsString("Frescura Marina")));
	}

	@Test
	@DisplayName("Se prueba el Delete del endpoint http://localhost:8080/api/productos/3")
	@Disabled("Probado una vez, deshabilitado porque ya no existe el producto id 4")
	void pruebaDELETE() throws Exception {
		this.mockMvc.perform(delete("/api/productos/3")
				.header("Authorization", token))
		.andDo(print())
		.andExpect(status().isOk())
		.andExpect(content().string(containsString("Esencia Citrus")));
	}//pruebaDelete
	
	@Test
	@DisplayName("Se prueba el Post del endpoint http://localhost:8080/api/usuarios/")
	@Disabled("Probado una vez, deshabilitado porque ya existe el usuario id 7")
	void pruebaUsuariosPOST() throws Exception {
		Producto p=new Producto();
		p.setNombre("Base44");
		p.setProducto("Prueba");
		p.setPrecio(500.95);
		p.setImagen("crema.png");
		p.setCategoria("Skincare");
		p.setDescripcion("Prueba");
		p.setDescuento(0.5);

		this.mockMvc.perform(post("/api/productos/")
				.contentType(MediaType.APPLICATION_JSON)
				.content(asJsonString(p))
				.header("Authorization", token))
		.andDo(print())
		.andExpect(status().isOk())
		.andExpect(content().string(containsString("Base44")));
	}//pruebaPost
	
	private static String asJsonString(final Object obj) {
	    try {
	      return new ObjectMapper().writeValueAsString(obj);
	    } catch (Exception e) {
	      throw new RuntimeException(e);
	    }//catch
	 } // asJsonString
	
	@Test
	@DisplayName("Se prueba el Put del endpoint http://localhost:8080/api/productos/9")
	@Disabled("Probado una vez, deshabilitado porque ya no existe el producto id 1")
	void pruebaPUT() throws Exception {
		this.mockMvc.perform(put("/api/productos/9")
				.queryParam("precio", "666.66")
				.queryParam("imagen", "crema666.png")
				.header("Authorization", token))
		.andDo(print())
		.andExpect(status().isOk())
		.andExpect(content().string(containsString("666.66")));
	}//pruebaPut
	
	// Test usuarios ------------------------------------------------------------------
		@Test
		@DisplayName("Se prueba el GET del endpoint http://localhost:8080/api/usuarios/1")
		@Disabled("Probado una vez, deshabilitado porque ya no existe el producto id 4")
		void pruebaUsuariosGET() throws Exception {
			this.mockMvc.perform(get("/api/usuarios/1")
					.header("Authorization", token))
			.andDo(print())
			.andExpect(status().isOk())
			.andExpect(content().string(containsString("Juan")));
		}

		@Test
		@DisplayName("Se prueba el Delete del endpoint http://localhost:8080/api/usuarios/3")
		@Disabled("Probado una vez, deshabilitado porque ya no existe el usuario id 3")
		void pruebaUsuariosDELETE() throws Exception {
			this.mockMvc.perform(delete("/api/usuarios/7")
					.header("Authorization", token))
			.andDo(print())
			.andExpect(status().isOk())
			.andExpect(content().string(containsString("Alan")));
		}//pruebaDelete
		
		@Test
		@DisplayName("Se prueba el Post del endpoint http://localhost:8080/api/usuarios/")
		@Disabled("Probado una vez, deshabilitado porque ya existe el usuario id 7")
		void pruebaPOST() throws Exception {
			Usuario p=new Usuario();
			p.setNombre("Alan");
			p.setApellido("Prueba");
			p.setTelefono("0123456789");
			p.setCorreo("a@gmail.com");
			p.setContrasena("Skincare");
			p.setRol(Rol.CLIENTE);

			this.mockMvc.perform(post("/api/usuarios/")
					.contentType(MediaType.APPLICATION_JSON)
					.content(asJsonString(p))
					.header("Authorization", token))
			.andDo(print())
			.andExpect(status().isOk())
			.andExpect(content().string(containsString("Alan")));
		}//pruebaPost
		
		@Test
		@DisplayName("Se prueba el PUT del endpoint http://localhost:8080/api/usuarios/9")
		@Disabled("Probado una vez, deshabilitado porque ya existe el usuario id 7")
		void pruebaUsuariosPUT() throws Exception {
			ChangePassword p=new ChangePassword();
			p.setPassword("abc");
			p.setNpassword("123");

			this.mockMvc.perform(put("/api/usuarios/9")
					.contentType(MediaType.APPLICATION_JSON)
					.content(asJsonString(p))
					.header("Authorization", token))
			.andDo(print())
			.andExpect(status().isOk())
			.andExpect(content().string(containsString("Alan")));
		}//pruebaPut
		
		// Test ordenes ------------------------------------------------------------------
		@Test
		@DisplayName("Se prueba el GET del endpoint http://localhost:8080/api/ordenes/1")
		@Disabled("Probado una vez, deshabilitado porque ya no existe el producto id 4")
		void pruebaOrdenesGET() throws Exception {
			this.mockMvc.perform(get("/api/ordenes/1")
					.header("Authorization", token))
			.andDo(print())
			.andExpect(status().isOk())
			.andExpect(content().string(containsString("2024-05-28")));
		}
}
