package br.com.jkavdev.livraria.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import br.com.jkavdev.livraria.repository.IUsuarioRepository;
import br.com.jkavdev.livraria.security.CustomUserDetailsService;

@Configuration
@EnableWebSecurity
@ComponentScan(basePackageClasses = {CustomUserDetailsService.class, IUsuarioRepository.class}, basePackages = {"br.com.jkavdev.livraria.security"})
public class AppSecConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private CustomUserDetailsService userService;

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {

		auth.userDetailsService(userService);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.authorizeRequests()
			.antMatchers("/resources/**", "/cadastro", "/").permitAll()
			.antMatchers("/admin/**").hasRole("ADMIN")
			.anyRequest().authenticated()
				.and()
			.formLogin()
				.loginPage("/login").permitAll()
				.defaultSuccessUrl("/index")
				.failureUrl("/login?error=true")
				.usernameParameter("username")
				.passwordParameter("password")
					.and()
				.logout()
					.logoutSuccessUrl("/login").permitAll();
	}
}
