package br.com.jkavdev.javaweb.hibernate.comercio.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import br.com.jkavdev.javaweb.hibernate.comercio.modelo.Contato;
import br.com.jkavdev.javaweb.hibernate.comercio.util.HibernateUtility;

public class ContatoDao {

	Session session;

	public ContatoDao() {
		session = HibernateUtility.getSessionFactory().openSession();
	}

	public void salvar(Contato contato) {
		this.session.save(contato);
	}

	public void atualizar(Contato contato) {
		this.session.update(contato);
	}

	public void excluir(Contato contato) {
		this.session.delete(contato);
		this.session.flush();
	}

	@SuppressWarnings({ "unchecked", "deprecation" })
	public List<Contato> listar() {
		return this.session.createQuery("from Contato").list();
	}

	@SuppressWarnings({ "deprecation", "rawtypes" })
	public Contato buscaContato(int codigo) {
		Query consulta = this.session
				.createQuery("from Contato where codigo = :codigo");
		consulta.setInteger("codigo", codigo);

		return (Contato) consulta.uniqueResult();
	}

	public Session getSession() {
		return session;
	}

}
