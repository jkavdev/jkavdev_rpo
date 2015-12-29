package br.com.javaparaweb.financeiro.usuario;

import java.util.List;

import br.com.javaparaweb.financeiro.util.DAOFactory;

public class UsuarioRN {

	private UsuarioDAO usuarioDAO;

	public UsuarioRN() {
		this.usuarioDAO = DAOFactory.criaUsuarioDAO();
	}

	public void salvar(Usuario usuario) {
		//se o codigo estiver null ou zero
		//significa que o usuario e novo
		if (usuario.getCodigo() == null || usuario.getCodigo() == 0) {
			this.usuarioDAO.salvar(usuario);
		} else {
			//senao o usuario ja existe
			//ai e feito um update
			this.usuarioDAO.atualizar(usuario);
		}
	}

	public void excluir(Usuario usuario) {
		this.usuarioDAO.excluir(usuario);
	}

	public Usuario carregar(Integer codigo) {
		return this.carregar(codigo);
	}

	public Usuario buscarPorLogin(String login) {
		return this.buscarPorLogin(login);
	}

	public List<Usuario> listar() {
		return this.usuarioDAO.listar();
	}

}
