package br.com.jkavdev.livraria.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.jkavdev.livraria.model.Livro;

public interface ILivroRepository extends JpaRepository<Livro, Long> {

}
