package com.dawes.seguridad;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.dawes.serviciosimpl.ServicioUsuarioImpl;

@Configuration
@EnableWebSecurity
public class SeguridadAplicacion {
	
	@Autowired
	ServicioUsuarioImpl su;
	
	
	@Bean
	public BCryptPasswordEncoder encripta() {
		return new BCryptPasswordEncoder();
	}
	
	
	@Bean
	public SecurityFilterChain filtroCompleto(HttpSecurity http) throws Exception{
		
		// Autentificamos
		http.getSharedObject(AuthenticationManagerBuilder.class)
		.userDetailsService(su).passwordEncoder(encripta());
		
		
		//Autorizamos al user normal el acceso a la carpeta user
		http.authorizeHttpRequests().requestMatchers("/fincas/mostrarfincas",
		"/variedades/mostrarvariedades","/fincas/arbolesfinca","/tratamientos/mostrartratamientos")
		.hasAnyRole("USER","ADMIN").and().exceptionHandling().accessDeniedPage("/403");
		
		
		//Autorizamos al usuario ADMIN a la carpeta admin
		http.authorizeHttpRequests().requestMatchers("/fincas/**").hasRole("ADMIN").and().exceptionHandling()
		.accessDeniedPage("/403");
		
		
		//raiz , index, login, 403 no requieren autentificación
		http.authorizeHttpRequests().requestMatchers("/fincas/mostrarfincas", "/login", "/403").permitAll().anyRequest()
		.authenticated();

		
		//para autenticarse utiliza el formulario de login personalizado
		http.formLogin().loginPage("/login").permitAll();

		
		//programamos el logout
		http.logout().logoutUrl("/logout").permitAll();

		
		return http.build();
	}

}


