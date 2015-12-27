package escola.musica.dao;

import java.util.List;

import javax.persistence.EntityManager;

import escola.musica.modelo.Curso;

public class CursoDAO {

	public void salvar(Curso curso) {
		EntityManager manager = JPAUtil.geEntityManager();
		manager.getTransaction().begin();
		manager.merge(curso);
		manager.getTransaction().commit();
		manager.close();
	}

	@SuppressWarnings("unchecked")
	public List<Curso> listarTodos() {
		EntityManager manager = JPAUtil.geEntityManager();
		return manager.createQuery("from Curso").getResultList();
	}

	public void excluir(Curso curso) {
		EntityManager manager = JPAUtil.geEntityManager();
		curso = manager.find(Curso.class, curso.getId());
		manager.getTransaction().begin();
		manager.remove(curso);
		manager.getTransaction().commit();
		manager.close();		
	}

}
