package com.example.springsecurityoauthgithub1.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// TODO Auto-generated method stub
		http
		.antMatcher("/**") //Indica que estás reglas se apliquen a todas las rutas.
		.authorizeRequests()//Se usa para definir las reglas
		.antMatchers("/","/media/images/**") //Permite a todos acceder a esas rutas y/o directorio
		.permitAll() // Indica que cualquiera puede acceder a las rutas este o no autenticado.
		.anyRequest().authenticated() //Indica que cualquier otra solicitud estará disponible al usuario loggeado
		.and() //Sirve para concatenar configuraciones
		.oauth2Login(); //Habilita el soporte de inicio de sesión de OAuth 2.0
		
		}

}
