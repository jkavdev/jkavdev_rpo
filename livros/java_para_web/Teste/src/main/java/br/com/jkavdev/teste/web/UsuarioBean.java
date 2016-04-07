package br.com.jkavdev.teste.web;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

//backing bean

//nome do bean
@ManagedBean(name = "usuarioBean")
// escopo do bean
@RequestScoped
public class UsuarioBean {

	private String nome;
	private String email;
	private String senha;
	private String confirmaSenha;

	public String novo() {
		// executa operacao

		// retorna resultado, pagina de
		//retorna para pagina usuario
		return "usuario";
	}

	public String salvar() {
		// context para adicionar a mensagem
		FacesContext context = FacesContext.getCurrentInstance();

		// confirmando se a senha e igual ao confirmaSenha
		if (!this.senha.equalsIgnoreCase(this.confirmaSenha)) {
			// adiciona mensagem
			context.addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Senha confirmada incorretamente", null));
			return "usuario";
		}
		return "mostraUsuario";
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
