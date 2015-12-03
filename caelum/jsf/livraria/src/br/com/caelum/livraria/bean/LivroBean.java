package br.com.caelum.livraria.bean;

import java.io.Serializable;
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

@ViewScoped
@ManagedBean
public class LivroBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Livro livro = new Livro();
	private Integer autorId;

	public List<Livro> getLivros() {
		return new DAO<Livro>(Livro.class).listaTodos();
	}

	public Integer getAutorId() {
		return autorId;
	}

	public void setAutorId(Integer autorId) {
		this.autorId = autorId;
	}

	public List<Autor> getAutores() {
		return new DAO<Autor>(Autor.class).listaTodos();
	}

	public List<Autor> getAutoresDoLivro() {
		return this.livro.getAutores();
	}

	public Livro getLivro() {
		return livro;
	}

	public void gravarAutor() {
		Autor autor = new DAO<Autor>(Autor.class).buscaPorId(this.autorId);
		this.livro.adicionaAutor(autor);
	}

	public void gravar() {
		System.out.println("Gravando livro " + this.livro.getTitulo());

		if (livro.getAutores().isEmpty()) {
//			throw new RuntimeException("Livro deve ter pelo menos um Autor.");
			FacesContext.getCurrentInstance().addMessage("autor", new FacesMessage("Livro deve ter pelo menos um Autor."));
			return;
		}

		new DAO<Livro>(Livro.class).adiciona(this.livro);
		this.livro = new Livro();
	}
	
	public void comecaComDigitoUm(FacesContext context, UIComponent component, Object value)throws ValidatorException{
		String valor = value.toString();
		if(!valor.startsWith("1")){
			throw new ValidatorException(new FacesMessage("Deveria come�ar com 1"));
		}
	}

}
