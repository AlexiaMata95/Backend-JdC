package org.generation.joyaDelCaribe;

import org.generation.joyaDelCaribe.config.UserJwtFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class JoyaDelCaribeApplication {

	public static void main(String[] args) {
		SpringApplication.run(JoyaDelCaribeApplication.class, args);
	}
	
	@Bean
	public FilterRegistrationBean<UserJwtFilter> UserJwtFilter(){
		FilterRegistrationBean<UserJwtFilter> registrationBean = new FilterRegistrationBean<UserJwtFilter>();
		registrationBean.setFilter(new UserJwtFilter());
		registrationBean.addUrlPatterns("/api/productos/*");
		registrationBean.addUrlPatterns("/api/usuarios/*");
		registrationBean.addUrlPatterns("/api/ordenes/*");
		registrationBean.addUrlPatterns("/api/orden-tiene-productos/*");
		return registrationBean;
	} 

}
