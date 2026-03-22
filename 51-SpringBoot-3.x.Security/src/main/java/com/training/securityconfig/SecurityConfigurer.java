package com.training.securityconfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.training.service.AppUserServiceImpl;

@Configuration
@EnableWebSecurity
public class SecurityConfigurer {

	@Autowired
	JwtAuthFilter jwtAuthFilter;

	@Autowired
	AppUserServiceImpl appUserService;

	/*
	 * @Bean public BCryptPasswordEncoder passwordEncoder() { return new
	 * BCryptPasswordEncoder(); }
	 */

	@Bean
	public PasswordEncoder passwordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}

	@Bean
	public AuthenticationManager authenticationManager(AuthenticationConfiguration authConfig) throws Exception {

		return authConfig.getAuthenticationManager();
	}

	/*
	 * @Override
	 * 
	 * @Bean public AuthenticationManager authenticationManagerBean() throws
	 * Exception {
	 * 
	 * return super.authenticationManagerBean(); }
	 */

	
	@Bean
	public SecurityFilterChain f1(HttpSecurity http) throws Exception {
		System.out.println("This code runss....");
		//String[] allowedURLS = { "/appusers/add", "/appusers/login" };
		//http.headers().frameOptions().disable().and().cors().and().csrf().disable().authorizeRequests()
		//		.requestMatchers(allowedURLS).permitAll().anyRequest().authenticated();
		
	/*	http
        .authorizeHttpRequests((authz) -> authz
        	.requestMatchers(allowedURLS).permitAll().anyRequest().authenticated()
        )
        
        .httpBasic(Customizer.withDefaults());
        */
		
		 http
					.authorizeHttpRequests(requests -> requests
                          .anyRequest().authenticated()
	                )
	                .httpBasic(Customizer.withDefaults());
	               
   
		http.addFilterBefore(this.jwtAuthFilter, UsernamePasswordAuthenticationFilter.class);
		return http.build();
		// return http.build();
	}
	
	@Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
		String[] allowedURLS = { "/appusers/add", "/appusers/login" };
        return (web) -> web.ignoring().requestMatchers(allowedURLS);
    }
}
