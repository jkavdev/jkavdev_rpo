package br.com.jkavdev.livraria.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import br.com.jkavdev.livraria.model.RolesEnum;
import br.com.jkavdev.livraria.security.CustomUserDetailsService;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true)
public class AppSecConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private CustomUserDetailsService userService;

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.authorizeRequests()
			.antMatchers("/resources/**", "/cadastro/**", "/").permitAll()
			
			.antMatchers(RolesEnum.MANTER_USUARIOS.getUrl()).access(RolesEnum.MANTER_USUARIOS.getRoleAcess())
		    .antMatchers(RolesEnum.MANTER_PERFIS.getUrl()).access(RolesEnum.MANTER_PERFIS.getRoleAcess())
		    
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

	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {

		auth.userDetailsService(userService);
	}
}
