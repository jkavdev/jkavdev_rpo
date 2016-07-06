package br.com.jkavdev.livraria.test.spring;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.jkavdev.livraria.model.Genero;
import br.com.jkavdev.livraria.repository.IGeneroRepository;
import br.com.jkavdev.livraria.test.AbstractDatabaseTest;

public class GeneroRepositoryTest extends AbstractDatabaseTest {

	private static final Logger logger = Logger.getLogger(GeneroRepositoryTest.class);

	@Autowired
	private IGeneroRepository generoRepository;

	@Test
	public void insertGenero() {

		Genero terror = criaGenero("Terror");
		Genero acao = criaGenero("Ação");
		Genero romance = criaGenero("Romance");
		Genero comedia = criaGenero("Comédia");
		Genero drama = criaGenero("Drama");

		generoRepository.save(terror);
		generoRepository.save(acao);
		generoRepository.save(romance);
		generoRepository.save(comedia);
		generoRepository.save(drama);

		logger.info("Generos salvos com Sucesso!");

	}

	public Genero criaGenero(String nomeGenero) {
		Genero genero = new Genero();
		genero.setNomeGenero(nomeGenero);
		return genero;
	}

}
