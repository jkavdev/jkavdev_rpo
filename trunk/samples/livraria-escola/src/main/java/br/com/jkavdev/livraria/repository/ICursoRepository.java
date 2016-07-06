package br.com.jkavdev.livraria.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.jkavdev.livraria.model.Curso;

public interface ICursoRepository extends JpaRepository<Curso, Long> {

}
