package br.com.simulados.modelo;

import java.util.List;

public class Questao {

	private long id;
	private List<Pergunta> pergunta;
	private boolean resposta;
	private Disciplina disciplina;
	private int tipo;

	public Disciplina getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}

	public void setPergunta(List<Pergunta> pergunta) {
		this.pergunta = pergunta;
	}

	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public boolean getResposta() {
		return resposta;
	}

	public void setResposta(boolean resposta) {
		this.resposta = resposta;
	}

	public List<Pergunta> getPergunta() {
		return pergunta;
	}

}
