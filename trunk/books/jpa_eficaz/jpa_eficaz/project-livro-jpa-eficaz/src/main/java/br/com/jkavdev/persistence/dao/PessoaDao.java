package br.com.jkavdev.persistence.dao;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.jkavdev.persistence.model.inherite.Pessoa;
import br.com.jkavdev.persistence.util.jpa.JpaUtil;

public class PessoaDao {

	private EntityManager manager = JpaUtil.geEntityManager();
	
	public Pessoa buscaPorTitloComEmailsEager(String nome){
		String sql = "select c from Pessoa c"
				+ "		join fetch c;emails e "
				+ "		where e.titulo = :titulo";
		
		TypedQuery<Pessoa> query = this.manager.createQuery(sql, Pessoa.class);
		
		query.setParameter("titulo", nome);
		
		Pessoa pessoa = query.getSingleResult();
		
		return pessoa;
	}

}
