package br.com.jkavdev.financeiro.util;

import br.com.jkavdev.financeiro.usuario.UsuarioDao;
import br.com.jkavdev.financeiro.usuario.UsuarioDaoHibernate;

public class DAOFactory {

	public static UsuarioDao criarUsuarioDAO() {
		// cria implementacao do dao
		UsuarioDaoHibernate usuarioDaoHibernate = new UsuarioDaoHibernate();
		// seta a sessao atual do hibernate
		usuarioDaoHibernate.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
		// retorna implementacao
		return usuarioDaoHibernate;
	}
}
