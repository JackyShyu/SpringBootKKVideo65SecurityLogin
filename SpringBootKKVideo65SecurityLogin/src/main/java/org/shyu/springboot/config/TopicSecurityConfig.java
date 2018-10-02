package org.shyu.springboot.config;

import org.shyu.springboot.service.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

//@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled=true)
public class TopicSecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	private UserDetailsServiceImpl userDetailsServiceImpl;
	
	public void configure(HttpSecurity http) throws Exception {
		/*http.authorizeRequests()
				.antMatchers("/user/topics/**").hasAnyRole("admin", "user")
				.and()
				.authorizeRequests()
				.antMatchers("/user/users/**").hasAnyRole("admin", "user")
				.and()
				.formLogin();*/
		http.authorizeRequests()
				.antMatchers("/user/secure/**")
				.hasAnyRole("ADMIN", "USER")
			.and().formLogin()
				.loginPage("/user/login")
				.loginProcessingUrl("/app-login")
				.usernameParameter("app_username")
				.passwordParameter("app_password")
				.defaultSuccessUrl("/user/secure/topic-details")
			.and().logout()
				.logoutUrl("/app-logout")
				.logoutSuccessUrl("/user/login")
			.and().exceptionHandling()
				.accessDeniedPage("/user/error");
	}
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
		auth.userDetailsService(userDetailsServiceImpl).passwordEncoder(bCryptPasswordEncoder);
	}
}
