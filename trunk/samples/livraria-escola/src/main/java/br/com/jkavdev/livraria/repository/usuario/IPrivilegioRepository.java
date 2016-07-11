package br.com.jkavdev.livraria.repository.usuario;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.jkavdev.livraria.model.usuario.Privilegio;

public interface IPrivilegioRepository extends JpaRepository<Privilegio, Long> {
	
	public Privilegio findByName(String name);

}
