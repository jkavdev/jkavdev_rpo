package br.com.javaparaweb.financeiro.web;

import java.util.List;

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
	private String confirmaSenha;
	private List<Usuario> lista;
	private String destinoSalvar;

	//setando o destino para usuario sucesso
	public String novo() {
		this.destinoSalvar = "usuarioSucesso";
		this.usuario = new Usuario();
		this.usuario.setAtivo(true);
		return "/publico/usuario";
	}

	public String salvar() {
		FacesContext context = FacesContext.getCurrentInstance();
		if (!usuario.getSenha().equals(confirmaSenha)) {
			FacesMessage message = new FacesMessage("A Senha nao foi confirmada corretamente!");
			context.addMessage(null, message);
			return null;
		}
		new UsuarioRN().salvar(this.usuario);
		return this.destinoSalvar;
	}

	//excluindo usuario
	//retorna null pois nao mudara de pagina
	public String excluir() {
		new UsuarioRN().excluir(this.usuario);
		this.lista = null;
		return null;
	}

	//altera estado do usuario para ativo ou desativado
	//depois salva as configuracoes no banco
	//retorna null pois nao mudara de pagina
	public String ativar() {
		if (this.usuario.isAtivo())
			this.usuario.setAtivo(false);
		else
			this.usuario.setAtivo(true);

		new UsuarioRN().salvar(usuario);
		return null;
	}

	//seta confimar senha com a senha do usuario
	//e manda para pagina de cadastro
	public String editar() {
		this.confirmaSenha = this.usuario.getSenha();
		return "/publico/usuario";
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getConfirmaSenha() {
		return confirmaSenha;
	}

	public void setConfirmaSenha(String confirmaSenha) {
		this.confirmaSenha = confirmaSenha;
	}

	//busca registro do banco
	//se a lista de fo nula, busca do banco
	//ira buscar do banco quando iniciar a pagina ou quando excluir um registro
	public List<Usuario> getLista() {
		if (this.lista == null) {
			this.lista = new UsuarioRN().listar();
		}
		return this.lista;
	}

	public void setLista(List<Usuario> lista) {
		this.lista = lista;
	}

	public String getDestinoSalvar() {
		return destinoSalvar;
	}

	public void setDestinoSalvar(String destinoSalvar) {
		this.destinoSalvar = destinoSalvar;
	}

}
