package br.com.jkavdev.livraria.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.jkavdev.livraria.model.Genero;

public interface IGeneroRepository extends JpaRepository<Genero, Long> {

}
