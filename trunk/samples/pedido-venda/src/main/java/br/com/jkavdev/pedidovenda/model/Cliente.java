package br.com.jkavdev.pedidovenda.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Cliente implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private String nome;
	private String email;
	private String documentoReceitaFederal;
	private TipoPessoa tipoPessoa;
	private List<Endereco> enderecos = new ArrayList<>();

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDocumentoReceitaFederal() {
		return this.documentoReceitaFederal;
	}

	public void setDocumentoReceitaFederal(String documentoReceitaFederal) {
		this.documentoReceitaFederal = documentoReceitaFederal;
	}

	public TipoPessoa getTipoPessoa() {
		return this.tipoPessoa;
	}

	public void setTipoPessoa(TipoPessoa tipoPessoa) {
		this.tipoPessoa = tipoPessoa;
	}

	public List<Endereco> getEnderecos() {
		return this.enderecos;
	}

	public void setEnderecos(List<Endereco> enderecos) {
		this.enderecos = enderecos;
	}

}
