package br.com.javaparaweb.financeiro.util;

import br.com.javaparaweb.financeiro.usuario.*;

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
