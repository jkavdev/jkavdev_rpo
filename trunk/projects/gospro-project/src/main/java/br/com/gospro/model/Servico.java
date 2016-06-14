package br.com.gospro.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

import br.com.gospro.util.jpa.BaseEntity;

@Entity
@Table(name = "servicos")
public class Servico extends BaseEntity {

	private static final long serialVersionUID = 1L;

	private String descricao;
	private BigDecimal valor;
	private Status statusServico;

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	@Column(name = "status_servico")
	@Enumerated(EnumType.STRING)
	public Status getStatusServico() {
		return statusServico;
	}

	public void setStatusServico(Status statusServico) {
		this.statusServico = statusServico;
	}

}
