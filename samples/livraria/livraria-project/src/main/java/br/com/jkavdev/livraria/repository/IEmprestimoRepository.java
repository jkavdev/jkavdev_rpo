package br.com.jkavdev.livraria.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.jkavdev.livraria.model.Emprestimo;

public interface IEmprestimoRepository extends JpaRepository<Emprestimo, Long> {

}
