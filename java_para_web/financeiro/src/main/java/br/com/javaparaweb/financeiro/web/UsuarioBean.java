package br.com.javaparaweb.financeiro.web;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import br.com.javaparaweb.financeiro.usuario.Usuario;
import br.com.javaparaweb.financeiro.usuario.UsuarioRN;

@ManagedBean(name = "usuarioBean")
@RequestScoped
public class UsuarioBean {

	private Usuario usuario = new Usuario();
	private String confimaSenha;
	private List<Usuario> lista;
	private String destinoSalvar;

	@PostConstruct
	public void init() {

	}

	public String novo() {
		this.destinoSalvar = "usuariosucesso";
		this.usuario = new Usuario();
		this.usuario.setAtivo(true);
		return "/publico/usuario";
	}

	public String salvar() {
		FacesContext context = FacesContext.getCurrentInstance();

		if (!usuario.getSenha().equals(confimaSenha)) {
			context.addMessage(null, new FacesMessage("A senha n�o foi confirmada corretamente!", ""));
			return null;
		}
		new UsuarioRN().salvar(usuario);

		return destinoSalvar;
	}

	public String editar() {
		this.confimaSenha = this.usuario.getSenha();
		return "/publico/usuario";
	}

	public String excluir() {
		UsuarioRN usuarioRN = new UsuarioRN();
		usuarioRN.excluir(this.usuario);
		this.lista = null;
		return null;
	}

	public String ativar() {
		if (this.usuario.isAtivo()) {
			this.usuario.setAtivo(false);
		} else {
			this.usuario.setAtivo(true);
		}
		UsuarioRN usuarioRN = new UsuarioRN();
		usuarioRN.salvar(this.usuario);
		return null;
	}

	public List<Usuario> getLista() {
		if (this.lista == null) {
			UsuarioRN usuarioRN = new UsuarioRN();
			this.lista = usuarioRN.listar();
		}
		return this.lista;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getConfimaSenha() {
		return confimaSenha;
	}

	public void setConfimaSenha(String confimaSenha) {
		this.confimaSenha = confimaSenha;
	}

	public String getDestinoSalvar() {
		return destinoSalvar;
	}

	public void setDestinoSalvar(String destinoSalvar) {
		this.destinoSalvar = destinoSalvar;
	}

}
