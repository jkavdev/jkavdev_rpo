package br.com.jkavdev.hibernate.database.utils;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;

import br.com.jkavdev.hibernate.database.interfaces.IGenericDao;

//classe que recebe genericos
//recebe uma classe, entidade do banco
//e uma chave 

public abstract class GenericDao<T, ID extends Serializable> implements IGenericDao<T, ID> {

	private final Logger logger = Logger.getLogger(this.getClass());

	// classe que representa entidade que sera persistida
	private final Class<T> persistentClass;
	private Session session;

	@SuppressWarnings("unchecked")
	public GenericDao() {
		// retornando a tipo que extende esta classe
		this.persistentClass = (Class<T>) ((ParameterizedType) getClass() // indicando
																			// esta
																			// classe
				.getGenericSuperclass()) // indicando a classe que extender esta
											// classe
						.getActualTypeArguments()[0]; // pega o parametro que
														// informados pela
														// classe, no caso
														// pegara o primeiro
														// parametro que indica
														// o tipo da classe
	}

	// encontrar um elementro pelo id
	@SuppressWarnings("unchecked")
	@Override
	public T findById(ID id) {
		return (T) getSession().load(getPersistentClass(), id);
	}

	// lista todos os registros
	@Override
	public List<T> findAll() {
		// usando findbycriteria, sem argumentros, criterios
		// no qual retornara todos os registro do tipo passado no metodo
		// sem fazer nenhum filtro
		return findByCriteria();
	}

	// salva um registro
	@SuppressWarnings("unchecked")
	@Override
	public ID save(T entity) {
		// abrindo sessao no banco para salvar registro
		Transaction transaction = getSession().beginTransaction();
		// retornando a chave do objeto salvo
		Serializable id = getSession().save(entity);
		transaction.commit();
		return (ID) id;
	}

	// atualiza registro
	@Override
	public void update(T entity) {
		Transaction transaction = getSession().beginTransaction();
		getSession().update(entity);
		transaction.commit();
	}

	// deleta registro
	@Override
	public void delete(T entity) {
		Transaction transaction = getSession().beginTransaction();
		getSession().delete(entity);
		transaction.commit();
	}

	public void setSession(Session session) {
		this.session = session;
	}

	public Session getSession() {
		// verifico se a sessao esta nula
		// caso sim, lanco excecao
		if (this.session == null) {
			this.logger.error("Session not founde.");

			throw new IllegalStateException("Session has not been set Dao before usage");
		}
		return this.session;
	}

	private Class<T> getPersistentClass() {
		return this.persistentClass;
	}

	// metodo que retornar registro de acordo criterios
	// podendo ser um, varios ou nenhum criterio
	@SuppressWarnings({ "unchecked" })
	private List<T> findByCriteria(Criterion... criterion) {
		// no caso usaremos sempre os criterios da classe persistente
		// qual tipo sera retornado
		Criteria criteria = getSession().createCriteria(getPersistentClass());

		// adicionando os criterios passados a minha consulta
		for (Criterion criterios : criterion) {
			criteria.add(criterios);
		}

		return criteria.list();
	}
	
}
