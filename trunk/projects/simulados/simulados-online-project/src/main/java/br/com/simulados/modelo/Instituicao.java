package br.com.simulados.modelo;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

import br.com.simulados.util.jpa.PersistenceObject;

@Entity
public class Instituicao extends PersistenceObject<Long> {

	private static final long serialVersionUID = 1L;

	private String nome;
	private List<Prova> provas;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome.toUpperCase();
	}

	@OneToMany(mappedBy = "instituicao")
	public List<Prova> getProvas() {
		return provas;
	}

	public void setProvas(List<Prova> provas) {
		this.provas = provas;
	}

}
