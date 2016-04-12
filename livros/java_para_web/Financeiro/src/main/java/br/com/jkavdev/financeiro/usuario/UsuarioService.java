package br.com.jkavdev.financeiro.usuario;

import java.util.List;

import br.com.jkavdev.financeiro.util.DAOFactory;

public class UsuarioService {
	private UsuarioDao usuarioDAO;

	public UsuarioService() {
		this.usuarioDAO = DAOFactory.criarUsuarioDAO();
	}

	public Usuario carregar(Integer codigo) {
		return this.usuarioDAO.carregar(codigo);
	}

	public Usuario buscarPorLogin(String login) {
		return this.usuarioDAO.buscarPorLogin(login);
	}

	public void salvar(Usuario usuario) {
		if (usuario.getCodigo() == null || usuario.getCodigo() == 0) {
			usuario.getPermissao().add("ROLE_USUARIO");					//todo registro por inicio tera permissao de usuario
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
