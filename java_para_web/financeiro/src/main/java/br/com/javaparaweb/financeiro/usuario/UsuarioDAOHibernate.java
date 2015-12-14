package br.com.javaparaweb.financeiro.usuario;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

public class UsuarioDAOHibernate implements UsuarioDAO {

	private Session sessao;

	public void setSessao(Session sessao) {
		this.sessao = sessao;
	}

	@Override
	public void salvar(Usuario usuario) {
		this.sessao.save(usuario);
	}

	@Override
	public void atualizar(Usuario usuario) {
		this.sessao.update(usuario);
	}

	@Override
	public void excluir(Usuario usuario) {
		this.sessao.delete(usuario);
	}

	@Override
	public Usuario carregar(Integer codigo) {
		return (Usuario) this.sessao.get(Usuario.class, codigo);
	}

	@Override
	public Usuario buscarPorLogin(String login) {
		String hql = "select u from Usuario u ehere u.login = :login";
		Query consulta = this.sessao.createQuery(hql);
		consulta.setString("login", login);
		return (Usuario) consulta.uniqueResult();
	}

	@Override
	public List<Usuario> listar() {
		return this.sessao.createCriteria(Usuario.class).list();
	}

}
