package br.com.jkavdev.livraria.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.jkavdev.livraria.model.Autor;

public interface IAutorRepository extends JpaRepository<Autor, Long> {
	
	public Autor findAutorByNome(String nome);

}
