package com.algaworks.javaee;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@ViewScoped
public class PerfilUsuario implements Serializable {

	private static final long serialVersionUID = 1L;

	private String login;
	private String senha;
	private String nome;
	private String sobre;
	private Date dataNascimento;
	private String profissao;
	private Interesse interesse;
	
	public static final List<Interesse> INTERESSES = new ArrayList<>();
	
	//inicializando lista de interesses
	static{		
		INTERESSES.add(new Interesse("Esportes", "esportes"));
		INTERESSES.add(new Interesse("Computação", "computacao"));
		INTERESSES.add(new Interesse("Cinema", "cinema"));
		INTERESSES.add(new Interesse("Leitura", "leitura"));
	}

	public void atualizar() {
		System.out.println("Interesse: " + this.interesse.getDescricao());

		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Perfil Atualizado"));
	}
	
	public List<String> completarTexto(String consulta){
		List<String> resultados = new ArrayList<String>();
		
		if(consulta.startsWith("Thi")){
			resultados.add("Thiago");
			resultados.add("Thiago Faria");
			resultados.add("Thiago Faria de Andrade");
			resultados.add("Thiago da Algaworks");
		}
		
		return resultados;
	}
	
	//retorna a data atual
	public Date getDataHoje(){
		return new Date();
	}
	
	public List<Interesse> getInteresses(){
		return INTERESSES;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getSobre() {
		return sobre;
	}

	public void setSobre(String sobre) {
		this.sobre = sobre;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getProfissao() {
		return profissao;
	}

	public void setProfissao(String profissao) {
		this.profissao = profissao;
	}

	public Interesse getInteresse() {
		return interesse;
	}

	public void setInteresse(Interesse interesse) {
		this.interesse = interesse;
	}
	
	

}
