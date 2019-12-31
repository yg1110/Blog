package com.boot.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.boot.service.UserService;


@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	String[] resources = new String[] { "/blog/**", "/chat/**", "/login/**"};

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.authorizeRequests().antMatchers(resources).permitAll()
			.antMatchers("/","/signup","/regi").permitAll()
			.antMatchers("/admin*").access("hasRole('ADMIN')")
			.antMatchers("/user*").access("hasRole('USER')")
			.anyRequest().authenticated()
			.and()
			.formLogin().loginPage("/login").permitAll()
			.defaultSuccessUrl("/list")
			.failureUrl("/fail")
			.usernameParameter("id")
			.passwordParameter("pwd")
			.and()
			.logout().permitAll()
			.logoutSuccessUrl("/login?logout");
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return PasswordEncoderFactories.createDelegatingPasswordEncoder();
	}

}
