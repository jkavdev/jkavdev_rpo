package com.algaworks.cursojsf2;

import javax.faces.bean.ManagedBean;

//o managed bean sera aonde os comportamento da tela serao processados
//qual acao que deve acontecer
//nao processa regra de negocio ou acesso ao banco de dados
//apenas um controlador da interface com o backend

//para que seja um bean gerenciado pelo jsf usamos uma anotacao
@ManagedBean(name="olaMundoBean")
public class OlaMundoBean {

	private String nome;
	
	public OlaMundoBean() {
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public void enviar(){
		this.setNome(this.getNome().toUpperCase());
	}

}
