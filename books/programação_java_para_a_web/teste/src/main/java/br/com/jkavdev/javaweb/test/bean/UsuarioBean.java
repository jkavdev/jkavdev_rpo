package br.com.jkavdev.javaweb.test.bean;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@RequestScoped
public class UsuarioBean {

	private String nome;
	private String email;
	private String senha;
	private String confirmaSenha;
	
	public String novo(){
		
		return "usuario/usuario";
	}
	
	public String salvar(){
		
		FacesContext context = FacesContext.getCurrentInstance();
		
		if(!this.confirmaSenha.equalsIgnoreCase(senha)){
			context.addMessage(null, 
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Senhas não conferem", ""));
			
			return "usuario";
		}
		
		return "mostra-usuario";
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
