package br.com.caelum.livraria.bean;

import javax.faces.bean.ManagedBean;

import br.com.caelum.livraria.dao.DAO;
import br.com.caelum.livraria.modelo.Autor;

@ManagedBean
public class AutorBean {

	private Autor autor = new Autor();
	
	public void gravar(){
		System.out.println("Gravando autor : " + autor.getNome());
		new DAO<Autor>(Autor.class).adiciona(autor);
		//depois de salvar limpar o formulario
		this.autor = new Autor();
	}

	public Autor getAutor() {
		return autor;
	}

	public void setAutor(Autor autor) {
		this.autor = autor;
	}

}
