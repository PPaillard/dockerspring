package com.wcs.dockerspring.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	/**
	 * Permet de gérer les requêtes envoyées vers l'API
	 * On autorise toutes requêtes pour l'instant.
	 */
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		// désactivation des csrf && activation des CORS
		http.cors().and().csrf().disable();
		// on autorise tout
		http.authorizeRequests().anyRequest().permitAll();		
	}
}
