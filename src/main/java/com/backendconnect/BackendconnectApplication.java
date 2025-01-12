package com.backendconnect;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@SpringBootApplication
public class BackendconnectApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendconnectApplication.class, args);
	}


	@Configuration
	@EnableWebSecurity
	public class WebSecurityConfig {

		@Bean
		public UserDetailsService userDetailsService() {
			UserDetails user = User.withDefaultPasswordEncoder()
					.username("user")
					.password("password")
					.roles("USER")
					.build();

			return new InMemoryUserDetailsManager(user);
		}

		@Bean
		public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
			http
					.authorizeHttpRequests(authorize -> authorize
							.anyRequest().permitAll() // Allow all requests without authentication
					)
					.csrf(csrf -> csrf.disable()); // Disable CSRF protection if not needed

			return http.build();
		}
	}
}
