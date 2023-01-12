package com.acheron.mobilestore.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig {

	

	 
	@Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		
        http.cors()
        .and()
        .authorizeRequests()
        .antMatchers("/unsecured").permitAll()
        .anyRequest()
        .authenticated()
        .and()
        .oauth2ResourceServer()
        .jwt()
        .jwtAuthenticationConverter(jwtAuthenticationConverter());
        return http.build();
        
    }
		
//		http
//		.authorizeExchange()
//		.pathMatchers("/actuator/**", "/","/logout.html")
//		.permitAll()
//	.and()
//		.authorizeExchange()
//		.anyExchange()
//		.authenticated()
//	.and()
//		.oauth2Login() // to redirect to oauth2 login page.
//	.and()
//		.logout()
//		.logoutSuccessHandler(handler)
//;

//return http.build();


	    JwtAuthenticationConverter jwtAuthenticationConverter() {
	        final JwtAuthenticationConverter jwtAuthenticationConverter = new JwtAuthenticationConverter();
	        jwtAuthenticationConverter.setJwtGrantedAuthoritiesConverter(new KeycloakRoleConverter());

	        return jwtAuthenticationConverter;
	    }
	
}
