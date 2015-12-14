package br.com.javaparaweb.financeiro.usuario;

import java.util.List;

import br.com.javaparaweb.financeiro.util.DAOFactory;

public class UsuarioRN {

	private UsuarioDAO usuarioDAO;

	public UsuarioRN() {
		this.usuarioDAO = DAOFactory.criaUsuariDAO();
	}

	public Usuario carregar(Integer codigo) {
		return this.usuarioDAO.carregar(codigo);
	}

	public Usuario buscarPoLogin(String login) {
		return this.usuarioDAO.buscarPorLogin(login);
	}

	public void salvar(Usuario usuario) {
		if (usuario.getCodigo() == null || usuario.getCodigo() == 0) {
			this.usuarioDAO.salvar(usuario);
		} else {
			this.usuarioDAO.atualizar(usuario);
		}
	}

	public void excluir(Usuario usuario) {
		this.usuarioDAO.excluir(usuario);
	}

	public List<Usuario> listar() {
		return this.usuarioDAO.listar();
	}

}
