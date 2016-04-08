package br.com.jkavdev.financeiro.usuario;

import java.util.List;

import br.com.jkavdev.financeiro.util.DaoFactory;

public class UsuarioService {

	private UsuarioDao usuarioDao;

	public UsuarioService() {
		this.usuarioDao = DaoFactory.criarUsuarioDao();
	}

	public Usuario carregar(Integer codigo) {
		return this.usuarioDao.carregar(codigo);
	}

	public Usuario carregarPorLogin(String login) {
		return this.usuarioDao.carregarPorLogin(login);
	}

	public void salvar(Usuario usuario) {
		if (usuario.getCodigo() == null || usuario.getCodigo() == 0) {
			usuario.getPermissoes().add("ROLE_USUARIO");
			this.usuarioDao.salvar(usuario);			
		} else {
			this.usuarioDao.atualizar(usuario);
		}
	}

	public void excluir(Usuario usuario) {
		this.usuarioDao.excluir(usuario);
	}

	public List<Usuario> listar() {
		return this.usuarioDao.listar();
	}

}
