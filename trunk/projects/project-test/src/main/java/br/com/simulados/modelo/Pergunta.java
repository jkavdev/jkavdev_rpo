package br.com.simulados.modelo;

public class Pergunta {

	private long idPergunta;
	private String opcao;
	private boolean verdadeira;

	public long getIdPergunta() {
		return idPergunta;
	}

	public void setIdPergunta(long idPergunta) {
		this.idPergunta = idPergunta;
	}

	public String getOpcao() {
		return opcao;
	}

	public void setOpcao(String opcao) {
		this.opcao = opcao;
	}

	public boolean isVerdadeira() {
		return verdadeira;
	}

	public void setVerdadeira(boolean verdadeira) {
		this.verdadeira = verdadeira;
	}

}
