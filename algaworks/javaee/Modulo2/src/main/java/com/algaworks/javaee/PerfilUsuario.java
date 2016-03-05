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

	public void atualizar() {
		System.out.println("Data de Nascimento: " + this.dataNascimento);

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
	
	

}
