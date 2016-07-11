package br.com.jkavdev.livraria.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

import br.com.jkavdev.livraria.model.usuario.Usuario;
import br.com.jkavdev.livraria.repository.usuario.IUsuarioRepository;

public class UserAuthentication implements AuthenticationProvider {

	@Autowired
	private IUsuarioRepository userRepository;

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {

		String username = authentication.getName();
		String password = authentication.getCredentials().toString();

		Usuario user = this.userRepository.findByUsernameAndPassword(username, password);

		if (user != null) {
			List<GrantedAuthority> grantedAuthorities = new ArrayList<>();

			grantedAuthorities.add(new SimpleGrantedAuthority(user.getRole()));

			UserDetails userDetails = new User(username, password, grantedAuthorities);
			return new UsernamePasswordAuthenticationToken(userDetails, password, grantedAuthorities);
		} else {
			return null;
		}

		return null;
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return false;
	}

}
