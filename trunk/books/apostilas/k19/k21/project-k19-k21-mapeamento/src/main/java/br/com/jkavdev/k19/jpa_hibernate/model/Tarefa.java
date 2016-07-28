package br.com.jkavdev.k19.jpa_hibernate.model;

import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.Lob;

import br.com.jkavdev.k19.jpa_hibernate.model.converters.TarefaStatusConverter;

@Entity
public class Tarefa extends BaseEntity {

	private static final long serialVersionUID = 1L;

	private String titulo;
	private String descricao;
	private TarefaStatus status;

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	@Lob
	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	@Convert(converter = TarefaStatusConverter.class)
	public TarefaStatus getStatus() {
		return status;
	}

	public void setStatus(TarefaStatus status) {
		this.status = status;
	}

}
