package br.com.jkavdev.financeiro.usuario;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@RequestScoped
public class UsuarioBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Usuario usuario = new Usuario();
	private String confirmarSenha;

	public String novo() {
		this.usuario = new Usuario();
		this.usuario.setAtivo(true);
		return "/publico/usuario.xhtml";
	}

	public String salvar() {
		FacesContext context = FacesContext.getCurrentInstance();

		if (!this.usuario.getSenha().equals(this.confirmarSenha)) {
			FacesMessage message = new FacesMessage("A senha não foi confirmada corretamente!");
			context.addMessage(null, message);

			return null;
		}
		UsuarioService usuarioService = new UsuarioService();
		usuarioService.salvar(this.usuario);

		return "usuarioSucesso";
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getConfirmarSenha() {
		return confirmarSenha;
	}

	public void setConfirmarSenha(String confirmarSenha) {
		this.confirmarSenha = confirmarSenha;
	}

}
