package br.com.jkavdev.financeiro.usuario;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

public class UsuarioDaoHibernate implements UsuarioDao {

	private Session session;

	public void setSession(Session session) {
		this.session = session;
	}

	@Override
	public void salvar(Usuario usuario) {
		this.session.save(usuario);
	}

	@Override
	public void atualizar(Usuario usuario) {
		if (usuario.getPermissao() == null || usuario.getPermissao().size() == 0) {	//caso a lista de permissao do usuario esteja vazia
			Usuario usuarioPermissao = this.carregar(usuario.getCodigo());			//caregara do banco
			usuario.setPermissao(usuarioPermissao.getPermissao());					//setara no objeto a ser salvo
			this.session.evict(usuarioPermissao);									//tirao o usuarioPermissao do contexto de persistencia
		}
		this.session.update(usuario);
	}

	@Override
	public void excluir(Usuario usuario) {
		this.session.delete(usuario);
	}

	@Override
	public Usuario carregar(Integer codigo) {
		return (Usuario) this.session.get(Usuario.class, codigo);
	}

	@Override
	public Usuario buscarPorLogin(String login) {
		String sql = "select u from Usuario u where u.login = :login";
		Query query = this.session.createQuery(sql);
		query.setString("login", login);
		return (Usuario) query.uniqueResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Usuario> listar() {
		return this.session.createCriteria(Usuario.class).list();
	}

}
