package br.com.jkavdev.fj21.spring.modelo;

import java.util.Calendar;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Tarefa {

	private Long id;
	private String descricao;
	private boolean finalizado;
	private Calendar dataFinalizacao;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	// @NotNull(message = "A descricao deve ser preenchida")
	// @Size(min = 5, message = "Descricao deve ter pelo menos 5 caracteres")
	@NotNull(message = "{tarefa.descricao.vazia}")
	@Size(min = 5, message = "{tarefa.descricao.pequena}")
	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public boolean isFinalizado() {
		return finalizado;
	}

	public void setFinalizado(boolean finalizado) {
		this.finalizado = finalizado;
	}

	public Calendar getDataFinalizacao() {
		return dataFinalizacao;
	}

	public void setDataFinalizacao(Calendar dataFinalizacao) {
		this.dataFinalizacao = dataFinalizacao;
	}

}
