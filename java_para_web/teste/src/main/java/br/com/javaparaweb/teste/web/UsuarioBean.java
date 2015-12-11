package br.com.javaparaweb.teste.web;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

@ManagedBean(name = "usuarioBean")
@RequestScoped
public class UsuarioBean {

	private String nome;
	private String email;
	private String senha;
	private String confirmaSenha;
	
	//retorna a pagina de novo usuario
	public String novo(){
		return "usuario";
	}
	
	public String salvar(){
		//pega o contexto atual
		FacesContext context = FacesContext.getCurrentInstance();
		//se a senha nao for igual a confirmaSenha
		if(!this.senha.equalsIgnoreCase(confirmaSenha)){
			//apresenta messagem de erro
			context.addMessage(null, new FacesMessage("Senha Confirmada incorretamente", ""));
			//e retorna a mesma pagina de cadastro 
			return "usuario";
		}
		//se tudo tiver certo vai para tela de mostra usuario
		return "mostrausuario";
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

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getConfirmaSenha() {
		return confirmaSenha;
	}

	public void setConfirmaSenha(String confirmaSenha) {
		this.confirmaSenha = confirmaSenha;
	}

}
