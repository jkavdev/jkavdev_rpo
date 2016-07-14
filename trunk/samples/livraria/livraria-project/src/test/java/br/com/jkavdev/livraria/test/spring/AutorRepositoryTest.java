package br.com.jkavdev.livraria.test.spring;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.jkavdev.livraria.model.Autor;
import br.com.jkavdev.livraria.model.Livro;
import br.com.jkavdev.livraria.repository.IAutorRepository;
import br.com.jkavdev.livraria.repository.ILivroRepository;

public class AutorRepositoryTest extends AbstractDatabaseTest {

	private static final Logger logger = Logger.getLogger(AutorRepositoryTest.class);

	@Autowired
	private IAutorRepository autorRepository;
	@Autowired
	private ILivroRepository livroRepository;

	@Test
	public void insereAutor() {

		Autor nicholas = criaAutor("Nicholas", "Sparks");
		Autor jojo = criaAutor("Jojo", "Moyes");
		Autor kimberly = criaAutor("Kimberly", "McCreight");
		Autor victoria = criaAutor("Victoria", "Van Tiem");
		Autor veronica = criaAutor("Veronica", "Roth");
		Autor fernanda = criaAutor("Fernanda", "França");
		Autor jamie = criaAutor("Jamie", "McGuire");
		Autor john = criaAutor("John", "Green");
		Autor raphael = criaAutor("Raphael", "Draccon");

		autorRepository.save(nicholas);
		autorRepository.save(jojo);
		autorRepository.save(kimberly);
		autorRepository.save(victoria);
		autorRepository.save(veronica);
		autorRepository.save(fernanda);
		autorRepository.save(jamie);
		autorRepository.save(john);
		autorRepository.save(raphael);

		logger.info("Autores salvos com Sucesso!");

	}

	@Test
	public void listaLivros() {

		List<Livro> livros = livroRepository.findAll();

		for (Livro livro : livros) {
			System.out.println(livro.getIsbn() + " - " + livro.getGenero());
		}

	}

	@Test
	public void selectInfo() {
		List<Livro> livros = livroRepository.findAll();
		List<Autor> autores = autorRepository.findAll();

		for (Autor autor : autores) {
			System.out.println("Autor: " + autor.getNome());
		}

		for (Livro livro : livros) {
			System.out.println("Livro: " + livro.getTitulo());
		}
	}

	@Test
	public void insereLivroEscritos() {

		Livro livro = livroRepository.findLivroByIsbn("456");
		Autor rapahel = autorRepository.findAutorByNome("Raphael");
		// rapahel.adicionaLivro(livro);

		List<Livro> livros = new ArrayList<>();
		livros.add(livro);

		rapahel.setLivrosEscritos(livros);

		// Livro livro2 = livroRepository.findLivroByIsbn("321654");
		// Autor nicholas = autorRepository.findAutorByNome("Nicholas");
		// nicholas.adicionaLivro(livro2);

		// Livro livro3 = livroRepository.findLivroByIsbn("789");
		// Autor victoria = autorRepository.findAutorByNome("Victoria");
		// victoria.adicionaLivro(livro3);

		// Livro livro4 = livroRepository.findLivroByIsbn("654");
		// Autor jamie = autorRepository.findAutorByNome("Jamie");
		// jamie.adicionaLivro(livro4);

		// Livro livro5 = livroRepository.findLivroByIsbn("321");
		// Autor john = autorRepository.findAutorByNome("John");
		// john.adicionaLivro(livro5);

		autorRepository.save(rapahel);
		// autorRepository.save(nicholas);
		// autorRepository.save(victoria);
		// autorRepository.save(jamie);
		// autorRepository.save(john);

	}

	public Autor criaAutor(String nome, String sobrenome) {

		return new Autor(nome, sobrenome);
	}

}
