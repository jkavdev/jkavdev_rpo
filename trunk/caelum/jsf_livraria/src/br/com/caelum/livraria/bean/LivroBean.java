package br.com.caelum.livraria.bean;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;

import br.com.caelum.livraria.dao.DAO;
import br.com.caelum.livraria.modelo.Autor;
import br.com.caelum.livraria.modelo.Livro;

@ManagedBean
@ViewScoped
public class LivroBean {

	private Livro livro = new Livro();
	private Autor autor = new Autor();

	public void gravar() {
		System.out.println("Livro Gravado : " + this.livro.getTitulo());

		if (livro.getAutores().isEmpty()) {
			// throw new RuntimeException("O Livro deve ter pelo menos um
			// Autor!");
			FacesContext.getCurrentInstance().addMessage("autor", new FacesMessage("O Livro deve ter pelo menos um Autor!"));
		}
		new DAO<Livro>(Livro.class).adiciona(this.livro);
		this.livro = new Livro();
	}

	public void gravarAutor() {
		autor = new DAO<Autor>(Autor.class).buscaPorId(autor.getId());
		this.livro.adicionaAutor(autor);
	}

	// autores do livro a ser cadastrado
	public List<Autor> getAutoresDoLivro() {
		return this.livro.getAutores();
	}

	// todos os livros ja cadastrados
	public List<Livro> getLivros() {
		return new DAO<Livro>(Livro.class).listaTodos();
	}

	// validando isbn comecao com 1
	public void comecaComDigitoUm(FacesContext context, UIComponent component, Object value) throws ValidatorException {
		String valor = value.toString();
		if (!valor.startsWith("1")) {
			throw new ValidatorException(new FacesMessage("Deveria começar com 1"));
		}
	}

	public Livro getLivro() {
		return livro;
	}

	public Autor getAutor() {
		return autor;
	}

	// listando todos os autores do banco
	// o jsf automaticante criara o atributo autores
	public List<Autor> getAutores() {
		return new DAO<Autor>(Autor.class).listaTodos();
	}

}
