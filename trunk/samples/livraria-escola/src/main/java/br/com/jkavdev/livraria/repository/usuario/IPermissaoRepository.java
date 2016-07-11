package br.com.jkavdev.livraria.repository.usuario;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.jkavdev.livraria.model.usuario.Permissao;

public interface IPermissaoRepository extends JpaRepository<Permissao, Long> {
	
	public Permissao findByName(String name);

}
