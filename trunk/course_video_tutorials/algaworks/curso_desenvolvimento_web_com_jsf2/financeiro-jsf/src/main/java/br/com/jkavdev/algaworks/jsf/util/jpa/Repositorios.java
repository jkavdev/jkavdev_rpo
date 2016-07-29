package br.com.jkavdev.algaworks.jsf.util.jpa;

import java.io.Serializable;

import org.hibernate.Session;

import br.com.jkavdev.algaworks.jsf.repositories.Lancamentos;
import br.com.jkavdev.algaworks.jsf.repositories.Pessoas;
import br.com.jkavdev.algaworks.jsf.repositories.infra.LancamenstosHibernate;
import br.com.jkavdev.algaworks.jsf.repositories.infra.PessoasHibernate;
import br.com.jkavdev.algaworks.jsf.util.jsf.FacesUtil;

public class Repositorios implements Serializable {

	private static final long serialVersionUID = 1L;

	public Pessoas getPessoas() {

		return new PessoasHibernate(this.getSession());
	}
	
	public Lancamentos getLancamentos(){
		
		return new LancamenstosHibernate(this.getSession());
	}

	public Session getSession() {
		return (Session) FacesUtil.getRequesAttribute("session");
	}

}
