package com.training.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		/*http
			.authorizeHttpRequests((requests) -> requests
					.requestMatchers("/","/welcome").permitAll().anyRequest().authenticated()
			)
			.logout((logout) -> logout.permitAll());*/
		
		 http.csrf(AbstractHttpConfigurer::disable)
	      .authorizeHttpRequests(authorizationManagerRequestMatcherRegistry ->
	              authorizationManagerRequestMatcherRegistry.requestMatchers(HttpMethod.DELETE).hasRole("ADMIN")
	                      .requestMatchers("/welcome").hasAnyRole("USER")
	                      .requestMatchers("/greet").hasAnyRole("USER", "ADMIN")
	                      .requestMatchers("/login/").permitAll()
	                      .anyRequest().authenticated()).formLogin(Customizer.withDefaults())
		 .sessionManagement(httpSecuritySessionManagementConfigurer -> httpSecuritySessionManagementConfigurer.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
	     // .httpBasic(Customizer.withDefaults())
	     
		 
        return http.build();
		
		
		

		
	}

	@Bean
	public UserDetailsService userDetailsService() {
		UserDetails user = User.withUsername("user")
	            .password(passwordEncoder().encode("password"))
	            .roles("USER")
	            .build();

	        UserDetails admin = User.withUsername("admin")
	            .password(passwordEncoder().encode("admin"))
	            .roles("USER", "ADMIN")
	            .build();

	        return new InMemoryUserDetailsManager(user, admin);
	}
	
	@Bean
    public PasswordEncoder passwordEncoder() {
        PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        return encoder;
    }

}
