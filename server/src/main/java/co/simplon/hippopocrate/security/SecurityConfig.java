package co.simplon.hippopocrate.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

/**
 * @author Caroline, Ondine
 * File used to manage our website Security' Configuration
 *
 */
@Configuration
@EnableMethodSecurity
public class SecurityConfig {

	@Autowired
	private UserDetailsService userDetailsService;

	/**
	 * Method to encrypt passwords through PasswordEncoder
	 * @return
	 */
	@Bean
	public static PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	/**
	 * Security method to allow certain requests
	 * @param http
	 * @return
	 * @throws Exception
	 */
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.csrf().disable().authorizeHttpRequests((authorize) -> authorize.requestMatchers("/api/**").permitAll().requestMatchers("/api/users/{id}").permitAll());
//		http.headers().frameOptions().disable();;
//						.requestMatchers("/addClient").hasRole("ADMIN")
//						.requestMatchers("/formUpdateClient/{id}").hasRole("ADMIN")
//						.requestMatchers("/deleteClient/{id}").hasRole("ADMIN"))
//		.requestMatchers("/api/patients").permitAll().requestMatchers("/api/patients/{id}").permitAll()
//		.requestMatchers("/api/addpatient").permitAll().requestMatchers("/api/users").permitAll()
//		.requestMatchers("/api/usersDto").permitAll().requestMatchers("/api/users/{id}").permitAll()
//		.requestMatchers("/api/updateUser/{id}").permitAll().requestMatchers("/api/users/roles").permitAll()
//		.requestMatchers("/api/users/roles/{id}").permitAll().requestMatchers("/api/users/role/{name}")
//		.permitAll().requestMatchers("/api/services").permitAll().requestMatchers("/api/services/{id}")
//		.permitAll().requestMatchers("/api/services/{id}/patients").permitAll()
//		.requestMatchers("/api/services/{id}/rooms").permitAll().requestMatchers("/api/rooms/{id}/beds")
//		.permitAll().requestMatchers("/api/suivipatient/{id}").permitAll().requestMatchers("/api/suivipatient").permitAll())
//		.logout(logout -> logout.logoutRequestMatcher(new AntPathRequestMatcher("/logout")).permitAll());

		return http.build();
	}
//	
//    @Bean
//    public AuthenticationManager authenticationManager(
//                                 AuthenticationConfiguration configuration) throws Exception {
//        return configuration.getAuthenticationManager();
//    }

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
	}
}