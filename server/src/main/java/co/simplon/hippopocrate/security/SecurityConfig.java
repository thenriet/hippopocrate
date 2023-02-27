package co.simplon.hippopocrate.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	@Autowired
	private UserDetailsService userDetailsService;

	@Bean
	public static PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.csrf().disable()
		.authorizeHttpRequests((authorize) -> authorize.requestMatchers("/register/**").permitAll()
				.requestMatchers("/api/login").permitAll()
				.requestMatchers("/api/patients").hasRole("infirmier")
				.requestMatchers("/api/patients/{id}").hasRole("infirmier")
				.requestMatchers("/api/addpatient").hasRole("secretaire")
				.requestMatchers("/api/users").hasRole("admin")
				.requestMatchers("/api/users/{id}").hasRole("admin")
				.requestMatchers("/api/users/roles").hasRole("admin"))
		.logout(logout -> logout.logoutRequestMatcher(new AntPathRequestMatcher("/logout")).permitAll());;
//						.requestMatchers("/addClient").hasRole("ADMIN")
//						.requestMatchers("/formUpdateClient/{id}").hasRole("ADMIN")
//						.requestMatchers("/deleteClient/{id}").hasRole("ADMIN"))

		return http.build();
	}

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
	}
}