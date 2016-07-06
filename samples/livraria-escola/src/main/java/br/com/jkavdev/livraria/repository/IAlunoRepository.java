package br.com.jkavdev.livraria.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.jkavdev.livraria.model.Aluno;

public interface IAlunoRepository extends JpaRepository<Aluno, Long> {

}
