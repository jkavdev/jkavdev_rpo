package br.com.jkavdev.models.dpj.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

import br.com.jkavdev.models.dpj.util.jpa.BaseEntity;

@Entity
@Table(name = "cargos")
public class Cargo extends BaseEntity {

	private static final long serialVersionUID = 1L;

	private String cargoDescricao;
	private Corporacao corporacao;

	@Column(name = "cargo_descricao", nullable = false, length = 32)
	public String getCargoDescricao() {
		return cargoDescricao;
	}

	public void setCargoDescricao(String cargoDescricao) {
		this.cargoDescricao = cargoDescricao;
	}

	@Column(nullable = false, length = 3)
	@Enumerated(EnumType.STRING)
	public Corporacao getCorporacao() {
		return corporacao;
	}

	public void setCorporacao(Corporacao corporacao) {
		this.corporacao = corporacao;
	}

}
