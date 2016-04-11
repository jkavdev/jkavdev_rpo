package br.com.jkavdev.financeiro.web;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import br.com.jkavdev.financeiro.usuario.Usuario;
import br.com.jkavdev.financeiro.usuario.UsuarioService;

@ManagedBean
@RequestScoped
public class UsuarioBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Usuario usuario = new Usuario();
	private String confirmarSenha;
	private List<Usuario> lista;
	private String destinoSalvar;

	public String novo() {
		// quando for um novo usuario, destinoSalvar vai para usuario cadastrado
		// com sucesso
		this.destinoSalvar = "usuarioSucesso";
		this.usuario = new Usuario();
		this.usuario.setAtivo(true);
		return "/publico/usuario";
	}

	public String editar() {
		// pega a senha do usuario que esta vindo do formulario e seta em
		// confirmarSenha
		this.confirmarSenha = this.usuario.getSenha();
		return "/publico/usuario";
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

		return this.destinoSalvar;
	}

	public String excluir() {
		UsuarioService usuarioService = new UsuarioService();
		usuarioService.excluir(this.usuario);
		// forca o carregamento da lista
		this.lista = null;
		// refresh para mesma pagina
		return null;
	}

	public String ativar() {
		// ativa usuario
		if (this.usuario.isAtivo()) {
			this.usuario.setAtivo(false);
		} else {
			this.usuario.setAtivo(true);
		}

		UsuarioService usuarioService = new UsuarioService();
		usuarioService.salvar(this.usuario);
		// refresh para mesma pagina
		return null;
	}

	public List<Usuario> getLista() {
		// verifica se a lista ja existe
		if (this.lista == null) {
			UsuarioService usuarioService = new UsuarioService();
			lista = usuarioService.listar();
		}
		return this.lista;
	}

	public String atribuirPermissao(Usuario usuario, String permissao) {
		this.usuario = usuario;
		Set<String> permissoes = this.usuario.getPermissoes();
		if (permissoes.contains(permissao)) {
			permissoes.remove(permissao);
		} else {
			permissoes.add(permissao);
		}
		return null;
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

	public String getDestinoSalvar() {
		return destinoSalvar;
	}

	public void setDestinoSalvar(String destinoSalvar) {
		this.destinoSalvar = destinoSalvar;
	}

}
