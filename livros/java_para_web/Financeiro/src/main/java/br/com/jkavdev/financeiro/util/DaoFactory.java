package br.com.jkavdev.financeiro.util;

import br.com.jkavdev.financeiro.conta.ContaDao;
import br.com.jkavdev.financeiro.conta.ContaDaoHibernate;
import br.com.jkavdev.financeiro.usuario.UsuarioDao;
import br.com.jkavdev.financeiro.usuario.UsuarioDaoHibernate;

public class DaoFactory {

	public static UsuarioDao criarUsuarioDAO() {
		// cria implementacao do dao
		UsuarioDaoHibernate usuarioDaoHibernate = new UsuarioDaoHibernate();
		// seta a sessao atual do hibernate
		usuarioDaoHibernate.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
		// retorna implementacao
		return usuarioDaoHibernate;
	}

	public static ContaDao criarContaDao() {
		ContaDaoHibernate contaDaoHibernate = new ContaDaoHibernate();
		contaDaoHibernate.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
		return contaDaoHibernate;
	}
}
