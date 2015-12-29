package br.com.javaparaweb.financeiro.util;

import br.com.javaparaweb.financeiro.usuario.UsuarioDAO;
import br.com.javaparaweb.financeiro.usuario.UsuarioDAOHibernate;

public class DAOFactory {

	public static UsuarioDAO criaUsuarioDAO() {
		UsuarioDAOHibernate usuarioDAOHibernate = new UsuarioDAOHibernate();
		usuarioDAOHibernate.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
		return usuarioDAOHibernate;
	}

}
