package br.com.jkavdev.livraria.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.jkavdev.livraria.model.Curso;
import br.com.jkavdev.livraria.model.Usuario;

public interface IUsuarioRepository extends JpaRepository<Curso, Long> {

	Usuario porEmail(String email);

}
