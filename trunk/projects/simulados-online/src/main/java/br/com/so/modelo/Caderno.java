package br.com.so.modelo;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Caderno {

	private Long id;
	private List<Questao> listaQuestoes;
	private List<Simulado> listaSimulados;
	private List<Anotacoes> listaAnotacoes;

	@Id
	@GeneratedValue
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<Questao> getListaQuestoes() {
		return listaQuestoes;
	}

	public void setListaQuestoes(List<Questao> listaQuestoes) {
		this.listaQuestoes = listaQuestoes;
	}

	public List<Simulado> getListaSimulados() {
		return listaSimulados;
	}

	public void setListaSimulados(List<Simulado> listaSimulados) {
		this.listaSimulados = listaSimulados;
	}

	public List<Anotacoes> getObservacoes() {
		return listaAnotacoes;
	}

	public void setObservacoes(List<Anotacoes> observacoes) {
		this.listaAnotacoes = observacoes;
	}

}
