package br.com.jkavdev.livraria.test.spring;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.jkavdev.livraria.model.Genero;
import br.com.jkavdev.livraria.repository.IGeneroRepository;

public class GeneroRepositoryTest extends AbstractDatabaseTest {

	private static final Logger logger = Logger.getLogger(GeneroRepositoryTest.class);

	@Autowired
	private IGeneroRepository generoRepository;

	@Test
	public void insertGenero() {

		Genero biografia = criaGenero("Biografias e Memórias");
		Genero conto = criaGenero("Contos");
		Genero cordel = criaGenero("Cordel");
		Genero comedia = criaGenero("Comédia");
		Genero cronica = criaGenero("Crônica");
		Genero ensaio = criaGenero("Ensaios");
		Genero erotico = criaGenero("Erótico");
		Genero ficcao = criaGenero("Ficção científica");
		Genero novela = criaGenero("Novela");
		Genero poesia = criaGenero("Poesia");
		Genero policial = criaGenero("Policial");
		Genero romance = criaGenero("Romance");
		Genero rAuto = criaGenero("Romance autobiográfico");
		Genero rHist = criaGenero("Romance histórico");
		Genero teatro = criaGenero("Teatro");
		Genero terror = criaGenero("Terror");
		Genero tragedia = criaGenero("Tragédia");
		Genero real = criaGenero("Baseado em fatos reais");
		Genero reportagem = criaGenero("Livro-reportagem");
		Genero quadrinhos = criaGenero("Quadrinhos");
		Genero chick = criaGenero("Chick-Lit");
		Genero jovem = criaGenero("Jovem Adulto");
		Genero sick = criaGenero("Sick-lit");
		Genero fantasia = criaGenero("Fantasia");
		Genero distopia = criaGenero("Distopia");
		Genero drama = criaGenero("Drama");

		generoRepository.save(biografia);
		generoRepository.save(conto);
		generoRepository.save(cordel);
		generoRepository.save(comedia);
		generoRepository.save(cronica);
		generoRepository.save(ensaio);
		generoRepository.save(erotico);
		generoRepository.save(ficcao);
		generoRepository.save(novela);
		generoRepository.save(poesia);
		generoRepository.save(policial);
		generoRepository.save(romance);
		generoRepository.save(rAuto);
		generoRepository.save(rHist);
		generoRepository.save(teatro);
		generoRepository.save(terror);
		generoRepository.save(tragedia);
		generoRepository.save(real);
		generoRepository.save(reportagem);
		generoRepository.save(quadrinhos);
		generoRepository.save(chick);
		generoRepository.save(jovem);
		generoRepository.save(sick);
		generoRepository.save(fantasia);
		generoRepository.save(distopia);
		generoRepository.save(drama);

		logger.info("Generos salvos com Sucesso!");

	}

	public Genero criaGenero(String nomeGenero) {
		Genero genero = new Genero();
		genero.setNomeGenero(nomeGenero);

		return genero;
	}

}
