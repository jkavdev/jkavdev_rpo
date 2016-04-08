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
	public Usuario carregarPorLogin(String login) {
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
