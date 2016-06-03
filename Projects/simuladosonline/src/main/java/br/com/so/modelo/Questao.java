package br.com.so.modelo;

import java.io.Serializable;
import java.util.List;

public class Questao implements Serializable {

	private long id;
	private List<Opcao> perguntas;
	private String respostaObjetiva;
	private Disciplina disciplina;
	private String tipo;
	private String enunciado;

	public String getEnunciado() {
		return enunciado;
	}

	public void setEnunciado(String enunciado) {
		this.enunciado = enunciado;
	}

	public Disciplina getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}

	public void setPergunta(List<Opcao> perguntas) {
		this.perguntas = perguntas;
	}

	public List<Opcao> getPerguntas() {
		return perguntas;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getRespostaObjetiva() {
		return respostaObjetiva;
	}

	public void setRespostaObjetiva(String respostaObjetiva) {
		this.respostaObjetiva = respostaObjetiva;
	}

}
