package br.com.jkavdev.livraria.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import br.com.jkavdev.livraria.security.UserDetailService;

@Configuration
@EnableWebSecurity
public class AppSecConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private UserDetailService usuarioService;

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {

		auth.inMemoryAuthentication().withUser("user").password("password").roles("USER");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.authorizeRequests()
			.antMatchers("/resources/**").permitAll()
			.anyRequest().authenticated()
			.and()
			.formLogin()
				.loginPage("/login")
				.permitAll()
				.defaultSuccessUrl("/index")
				.failureUrl("/login?error=true")
				.and()
				.logout()
				.logoutSuccessUrl("/login")
					.permitAll();
			

	}
}

//.anyRequest().authenticated()
//.antMatchers("/login").anonymous()
//.antMatchers("/admin/**").access("hasRole('ADMINISTRADOR')")
//.antMatchers("/usuario/**").access("hasRole('USUARIO')")
//.antMatchers("/livro/**").access("hasRole('USUARIO') or hasRole('ADMINISTRADOR')")
//.antMatchers("/**").denyAll()
//.and()
//.formLogin()
//	.loginPage("/login")
//	.defaultSuccessUrl("/index")
//	.failureUrl("/login?error=true")
//	.and()
//	.logout()
//	.logoutSuccessUrl("/login");
