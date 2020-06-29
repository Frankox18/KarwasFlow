package pe.edu.upc.Karwas.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	private UDetailsService uDetailsService;

	@Autowired
	private LoggingAccessDeniedHandler loggingAccessDeniedHandler;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(authenticationProvider());
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// TODO Auto-generated method stub
		// super.configure(http); 
		http
			.authorizeRequests()
				.antMatchers("/karwas/index.html").permitAll()
				.antMatchers("/karwas/announcement").hasRole("MANAGER")
				.antMatchers("/karwas/role/start").hasAuthority("ACCESS_ADDPERSON")
				.antMatchers("/karwas/payment").authenticated()
			.and()
			.formLogin()
				.loginProcessingUrl("/signin")
				.loginPage("/karwas/login")
				.usernameParameter("inputUsername")
				.passwordParameter("inputPassword");
	}

	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	// Aqui se crea el vinculo entre el Spring security y: el PasswordEncoder y
	// UDetailsService
	DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
		daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
		daoAuthenticationProvider.setUserDetailsService(this.uDetailsService);
		return daoAuthenticationProvider;
	}

}
