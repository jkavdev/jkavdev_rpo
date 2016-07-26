package br.com.jkavdev.k19.jpa_hibernate.model;

import java.util.Collection;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

@Entity
public class Funcionario {

	private Long id;
	private String nome;
	private Collection<String> telefone;

	@Id
	@GeneratedValue
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@ElementCollection
	@CollectionTable(
			name = "telefones_dos_usuarios",
			joinColumns = @JoinColumn(name = "usuario_id"))
	@Column(name = "telefone")
	public Collection<String> getTelefone() {
		return telefone;
	}

	public void setTelefone(Collection<String> telefone) {
		this.telefone = telefone;
	}

}
