package br.com.jkavdev.algaworks.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.jkavdev.algaworks.spring.model.Vinho;

public interface Vinhos extends JpaRepository<Vinho, Long> {

}
