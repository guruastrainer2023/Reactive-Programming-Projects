package com.training.demo.hr.securityconfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.training.demo.hr.service.appuser.AppUserService;
import com.training.demo.hr.service.appuser.AppUserServiceImpl;

@Configuration
@EnableWebSecurity
public class SecutityConfigurer extends WebSecurityConfigurerAdapter{

	
	@Autowired
	JwtAuthFilter jwtAuthFilter;
	
	@Autowired
	AppUserServiceImpl appUserService;

	/*@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}*/
	
	@Bean
	public PasswordEncoder passwordEncoder() {
	    return NoOpPasswordEncoder.getInstance();
	}
	
	@Bean
	public AuthenticationManager authenticationManager(
	        AuthenticationConfiguration authConfig) throws Exception {
		
	    return authConfig.getAuthenticationManager();
	}
	
	/*@Override
	@Bean
	public AuthenticationManager authenticationManagerBean() throws Exception {
		
		return super.authenticationManagerBean();
	}*/
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		    auth.authenticationProvider(authenticationProvider());
			auth.userDetailsService(this.appUserService);
	}
	
	@Bean
	public DaoAuthenticationProvider authenticationProvider() {
	    DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
	     
	    authProvider.setUserDetailsService(this.appUserService);
	    authProvider.setPasswordEncoder(passwordEncoder());
	 
	    return authProvider;
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		System.out.println("This code runss....");
		String[] allowedURLS= {
				"/appusers/add",
				"/appusers/login",
				"/departments/**", 
				"/employees/all", 
				"/employees/find/**",
				"/employees/update",
				"employees/delete"
			};
		http
		.headers().frameOptions().disable().and()
		.cors().and()
        .csrf().disable()
	    .authorizeRequests()
	    	.antMatchers(allowedURLS).permitAll()
            .anyRequest().authenticated();
		http.addFilterBefore(this.jwtAuthFilter, UsernamePasswordAuthenticationFilter.class);
		//return http.build();
	}
	/*@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		/*http.cors().and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
				.authorizeRequests().antMatchers("/appusers/**").permitAll().anyRequest().authenticated();
		//http.authenticationProvider(authenticationProvider());
		 * 
		
		System.out.println("This code runss....");
		String[] allowedURLS= {
				"/appusers/add",
				"/appusers/login",
				"/departments/**", 
				"/employees/all", 
				"/employees/find/**",
				"/employees/update",
				"employees/delete"
			};
		http
		.cors().and()
        .csrf().disable()
	    .authorizeRequests()
	    	.antMatchers(allowedURLS).permitAll()
            .anyRequest().authenticated();
		return http.build();
		
	
	
		
		
	}*/

}
