package br.com.jkavdev.livraria.repository.usuario;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.jkavdev.livraria.model.usuario.Usuario;

public interface IUsuarioRepository extends JpaRepository<Usuario, Long> {
	
	public Usuario findByUsernameAndPassword(String username, String password);

}
