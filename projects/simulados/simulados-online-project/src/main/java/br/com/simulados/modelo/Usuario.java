package br.com.simulados.modelo;

import br.com.simulados.util.jpa.PersistenceObject;

public class Usuario extends PersistenceObject<Long> {

	private static final long serialVersionUID = 1L;
	
	private String nome;
	private String sexo;
	private int idade;
	private String telefone;
	private String ocupacao;
	private String endereco;
	private String email;
	private int tipoConta;

	// Informacoes externas
	private Caderno caderno;
	private InformacoesEstudo informacoes;

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getOcupacao() {
		return ocupacao;
	}

	public void setOcupacao(String ocupacao) {
		this.ocupacao = ocupacao;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public Caderno getCaderno() {
		return caderno;
	}

	public void setCaderno(Caderno caderno) {
		this.caderno = caderno;
	}

	public InformacoesEstudo getInformacoes() {
		return informacoes;
	}

	public void setInformacoes(InformacoesEstudo informacoes) {
		this.informacoes = informacoes;
	}

	public int getTipoConta() {
		return tipoConta;
	}

	public void setTipoConta(int tipoConta) {
		this.tipoConta = tipoConta;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
