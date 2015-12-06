package com.algaworks.cursojavaee;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ViewScoped
@ManagedBean
public class CadastroAlunoBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private String nome;
	private String email;
	
	public void cadastrar(){
		System.out.println("Nome " + this.getNome());
		System.out.println("E-mail " + this.getEmail());
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
