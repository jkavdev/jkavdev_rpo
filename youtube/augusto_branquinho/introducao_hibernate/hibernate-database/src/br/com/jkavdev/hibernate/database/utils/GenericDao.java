package br.com.jkavdev.hibernate.database.utils;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;

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
	@Override
	public T findById(ID id) {
		return null;
	}

	// lista todos os registros
	@Override
	public List<T> findAll() {
		return null;
	}

	// salva um registro
	@Override
	public ID save(T entity) {
		return null;
	}

	// atualiza registro
	@Override
	public void update(T entity) {
	}

	// deleta registro
	@Override
	public void delete(T entity) {
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
	@SuppressWarnings({ "unchecked", "unused" })
	private List<T> findByCriteria(Criterion... criterion) {
		// no caso usaremos sempre os criterios da classe persistente
		Criteria criteria = getSession().createCriteria(getPersistentClass());

		// adicionando os criterios passados a minha consulta
		for (Criterion criterios : criterion) {
			criteria.add(criterios);
		}

		return criteria.list();
	}

}
