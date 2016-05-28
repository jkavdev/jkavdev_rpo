package br.com.simulados.dao;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.simulados.modelo.Instituicao;

@RequestScoped
public class InstituicaoDao {

	@Inject
	private EntityManager manager;

	public void salvar(Instituicao instituicao) {
		if (instituicao == null || instituicao.getNome().equals("") || instituicao.getNome().isEmpty()) {
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_WARN, "Alerta! ", "Todos os campos devem ser preenchidos!"));
		} else {
			this.manager.getTransaction().begin();
			this.manager.persist(instituicao);
			this.manager.getTransaction().commit();
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Sucesso! ", "Instituição cadastrada!"));
		}
	}

}
