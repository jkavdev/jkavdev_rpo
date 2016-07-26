package br.com.jkavdev.k19.jpa_hibernate.model;

import java.util.Collection;
import java.util.LinkedList;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Livro extends BaseEntity {

	private static final long serialVersionUID = 1L;

	private String titulo;
	private Collection<Autor> autores;

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	@ManyToMany
	@JoinTable(
			name = "livro_autor", 
			joinColumns = @JoinColumn(name = "livro_id"),
			inverseJoinColumns = @JoinColumn(name = "autor_id"))
	public Collection<Autor> getAutores() {
		return autores;
	}

	public void setAutores(Collection<Autor> autores) {
		this.autores = autores;
	}
	
	public void adicionarAutor(Autor autor){
		if(autores == null){
			autores = new LinkedList<>();
		}
	}

}
