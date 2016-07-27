package br.com.jkavdev.k19.jpa_hibernate.model.bid;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

import br.com.jkavdev.k19.jpa_hibernate.model.BaseEntity;

@Entity
public class Governador extends BaseEntity {

	private static final long serialVersionUID = 1L;

	private String nome;
	private Estado estado;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	// indicando quem e o dono do relacionamento
	@OneToOne(mappedBy = "governador")
	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

}
