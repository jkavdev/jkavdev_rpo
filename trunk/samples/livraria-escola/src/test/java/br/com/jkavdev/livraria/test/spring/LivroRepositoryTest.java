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

	private static final Logger logger = Logger.getLogger(EmprestimoRepositoryTest.class);

	@Autowired
	private IGeneroRepository generoRepository;
	@Autowired
	private ILivroRepository livroRepository;

	@Test
	public void insertLivro() {

		List<Genero> generos = generoRepository.findAll();

		for (Genero genero : generos) {
			if (genero.getNomeGenero().equalsIgnoreCase("Romance")) {
				Livro john = criaLivro("321654", "Querido John", genero, 1500, BigDecimal.valueOf(100L));

				livroRepository.save(john);
			} else if (genero.getNomeGenero().equalsIgnoreCase("Drama")) {
				Livro garota = criaLivro("321512", "A Garota Que Você Deixou Para Trás", genero, 1500, BigDecimal.valueOf(100L));

				livroRepository.save(garota);
			} else if (genero.getNomeGenero().equalsIgnoreCase("Policial")) {
				Livro garota = criaLivro("213215", "Reconstruindo Amelia", genero, 1500, BigDecimal.valueOf(100L));

				livroRepository.save(garota);
			} else if (genero.getNomeGenero().equalsIgnoreCase("Chick-Lit")) {
				Livro garota = criaLivro("789", "Um Amor de Cinema", genero, 1500, BigDecimal.valueOf(100L));

				livroRepository.save(garota);
			} else if (genero.getNomeGenero().equalsIgnoreCase("Distopia")) {
				Livro garota = criaLivro("987", "Divergente", genero, 1500, BigDecimal.valueOf(100L));

				livroRepository.save(garota);
			} else if (genero.getNomeGenero().equalsIgnoreCase("Comédia")) {
				Livro garota = criaLivro("456", "Malas, Memórias e Marshmallows", genero, 1500, BigDecimal.valueOf(100L));

				livroRepository.save(garota);
			} else if (genero.getNomeGenero().equalsIgnoreCase("Jovem Adulto")) {
				Livro garota = criaLivro("654", "Bela Distração", genero, 1500, BigDecimal.valueOf(100L));

				livroRepository.save(garota);
			} else if (genero.getNomeGenero().equalsIgnoreCase("Sick-lit")) {
				Livro garota = criaLivro("321", "A Culpa é das Estrelas", genero, 1500, BigDecimal.valueOf(100L));

				livroRepository.save(garota);
			} else if (genero.getNomeGenero().equalsIgnoreCase("Fantasia")) {
				Livro garota = criaLivro("123", "Cemitérios de Dragões", genero, 1500, BigDecimal.valueOf(100L));

				livroRepository.save(garota);
			}
		}

		logger.info("Livros salvos com Sucesso!");

	}

	public Livro criaLivro(String isbn, String titulo, Genero genero, Integer numeroDeCopias, BigDecimal preco) {

		return new Livro(isbn, titulo, genero, numeroDeCopias, preco, Calendar.getInstance());
	}

}
