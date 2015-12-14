package br.com.javaparaweb.financeiro.util;

import br.com.javaparaweb.financeiro.usuario.UsuarioDAO;
import br.com.javaparaweb.financeiro.usuario.UsuarioDAOHibernate;

public class DAOFactory {

	public static UsuarioDAO criaUsuariDAO() {
		UsuarioDAOHibernate daoHibernate = new UsuarioDAOHibernate();
		daoHibernate.setSessao(HibernateUtil.getSessionFactory().getCurrentSession());
		return daoHibernate;
	}

}
