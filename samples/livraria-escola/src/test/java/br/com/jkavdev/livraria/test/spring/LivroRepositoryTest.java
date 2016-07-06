package br.com.jkavdev.livraria.test.spring;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.jkavdev.livraria.model.Genero;
import br.com.jkavdev.livraria.model.Livro;
import br.com.jkavdev.livraria.repository.IGeneroRepository;
import br.com.jkavdev.livraria.repository.ILivroRepository;
import br.com.jkavdev.livraria.test.AbstractDatabaseTest;

public class LivroRepositoryTest extends AbstractDatabaseTest {

	private static final Logger logger = Logger
			.getLogger(EmprestimoRepositoryTest.class);

	@Autowired
	private IGeneroRepository generoRepository;
	@Autowired
	private ILivroRepository livroRepository;

	@Test
	public void insertLivro() {

		List<Genero> generos = generoRepository.findAll();

		for (Genero genero : generos) {
			if (genero.getNomeGenero().equalsIgnoreCase("ação")) {
				Livro amarrilion = criaLivro("23121", "Amarrilion", genero, 1500, BigDecimal.valueOf(100L));

				livroRepository.save(amarrilion);
			} else if (genero.getNomeGenero().equalsIgnoreCase("romance")) {
				Livro primeiroBeijo = criaLivro("25113", "Primeiro Beijo", genero, 1500, BigDecimal.valueOf(100L));

				livroRepository.save(primeiroBeijo);
			}
		}

		logger.info("Livros salvos com Sucesso!");

	}

	public Livro criaLivro(String isbn, String titulo, Genero genero,
			Integer numeroDeCopias, BigDecimal preco) {
		return new Livro(isbn, titulo, genero, numeroDeCopias, preco,
				Calendar.getInstance());
	}

}
