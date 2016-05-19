package br.com.sge.dao;

import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;

import br.com.sge.util.JPAUtil;

public class MetodoEntity {

	@Produces
	public EntityManager getEM(){
		return new JPAUtil().getEntityManager();
	}
	
	
	public void fecha(@Disposes EntityManager em){
		this.getEM().close();
	}
	
}
