package br.com.so.dao;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.so.modelo.Instituicao;
import br.com.so.modelo.Prova;

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

	public boolean existe(Instituicao instituicao) {
		String sql = "select i from Instituicao i where i.nome = :nome ";
		List lista = this.manager.createQuery(sql).setParameter("nome", instituicao.getNome().toUpperCase())
				.getResultList();
		if (lista.isEmpty()) {
			return false;
		}
		return true;
	}

	public List<Instituicao> buscarTodos() {
		return this.manager.createQuery("from Instituicao", Instituicao.class).getResultList();
	}

	public Instituicao buscarPorId(Long codigo) {
		return this.manager.find(Instituicao.class, codigo);
	}

}
