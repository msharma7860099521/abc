package com.example.demo.securityConfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class SpringSecurityConfig {
    @Bean
 	public PasswordEncoder passwordencoder() {
		return new BCryptPasswordEncoder();
	}
    @Bean
	public UserDetailsService userDetailsService() {
		
		UserDetails adminUser=org.springframework.security.core.userdetails.User.builder().username("admin").password(this.passwordencoder().encode("user")).roles("ADMIN").build();
		UserDetails normalUser=org.springframework.security.core.userdetails.User.builder().username("user").password(this.passwordencoder().encode("user")).roles("NORMAL").build();
		return new InMemoryUserDetailsManager(adminUser,normalUser);
	}
	
    @Bean
	public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
		return configuration.getAuthenticationManager();
	}
	
}
