package com.profile.Configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity

public class SecurityConfiguration {

	
	/*
	 * private final AuthenticationProvider authenticationProvider ;
	 * 
	 * 
	 * 
	 * public SecurityConfiguration(AuthenticationProvider authenticationProvider) {
	 * super(); this.authenticationProvider = authenticationProvider; }
	 */



	@Bean
	 SecurityFilterChain securityfilterchain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf
                        .disable())
                .authorizeHttpRequests(requests -> requests
                        .requestMatchers("/api/signup","/api/privateapi")
                        .permitAll()
                        .anyRequest()
                        .authenticated())
                .sessionManagement(management -> management
                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS))
               
               ;
		
		
		return http.build();
	}

}
