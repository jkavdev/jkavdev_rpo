package escola.musica.dao;

import java.util.List;

import javax.persistence.EntityManager;

import escola.musica.modelo.Curso;

public class CursoDAO {

	public void salvar(Curso curso) {
		EntityManager manager = JPAUtil.getEntityManager();
		manager.getTransaction().begin();
		manager.merge(curso);
		manager.getTransaction().commit();
		manager.close();
	}

	@SuppressWarnings("unchecked")
	public List<Curso> listarTodos() {
		EntityManager manager = JPAUtil.getEntityManager();
		return manager.createQuery("from Curso").getResultList();
	}

	public void excluir(Curso curso) {
		EntityManager manager = JPAUtil.getEntityManager();
		curso = manager.merge(curso);
		manager.getTransaction().begin();
		manager.remove(curso);
		manager.getTransaction().commit();
		manager.close();
	}

	@SuppressWarnings("unchecked")
	public static List<Curso> listarCursosAccordion() {
		EntityManager manager = JPAUtil.getEntityManager();
		return manager.createQuery("from Curso where nome "
				+ "in('Violino', 'Bateria', 'Clarinete', 'Flauta', 'Guitarra', 'Violão', 'Oboé') "
				+ "order by nome").getResultList();
	}

}
