package br.com.jkavdev.northwind.database.utils;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import org.apache.log4j.Logger;

import br.com.jkavdev.northwind.database.utils.interfaces.IGenericDao;
import br.com.jkavdev.northwind.utils.beans.BaseBeans;
import br.com.jkavdev.northwind.utils.database.interfaces.IServiceBase;

public abstract class GenericServiceWithKey<
	T extends BaseBeans,							//recebe um bean
	K extends BaseEntity,							//recebe uma entity
	IDB extends Serializable,					//chave do bean
	IDE extends Serializable>					//chave da entity
	implements IServiceBase<T, IDB>{	//devolve um bean com sua chave

	private final Logger logger = Logger.getLogger(this.getClass());

	private final Class<T> typeOfBean;
	private final Class<K> typeOfEntity;
	private final Class<IDE> typeOfKeyEntity;
	private final Class<IDB> typeOfKeyBean;

	@SuppressWarnings("unchecked")
	public GenericServiceWithKey() {
		try {
			ParameterizedType parameterizedType = (ParameterizedType)this.getClass().getGenericSuperclass();
			Type[] genericTypes = parameterizedType.getActualTypeArguments();

			this.logger.debug(genericTypes[0].getClass().getName());
			this.typeOfBean = (Class<T>)genericTypes[0];
			this.typeOfEntity = (Class<K>)genericTypes[1];
			this.typeOfKeyEntity = (Class<IDE>)genericTypes[2];
			this.typeOfKeyBean = (Class<IDB>)genericTypes[(genericTypes.length == 4) ? 3 : 2];
		} catch (RuntimeException e) {
			this.logger.error(e.getMessage(), e);
			// Re-throw the exception.
			throw e;
		}

		if (this.logger.isInfoEnabled()) {
			this.logger.info(String.format("Creating a service with the bean [%s], entity [%s], key bean [%s] and key entity [%s].",
					getTypeOfBean(), getTypeOfEntity(), getTypeOfKeyBean(), getTypeOfKeyEntity()));
		}
	}

	protected abstract IGenericDao<K, IDE> getConcreteDao();

	@Override
	public T findById(IDB id) {
		return parserEntity(getConcreteDao().findById(parserKeyBean(id)));
	}

	@Override
	public List<T> findAll() {
		return parserEntity(getConcreteDao().findAll());
	}

	@Override
	public IDB insert(T bean) {
		return parserKeyEntity(getConcreteDao().save(parserBean(bean)));
	}

	@Override
	public void update(T bean) {
		getConcreteDao().update(parserBean(bean));
	}

	@Override
	public void delete(T bean) {
		getConcreteDao().delete(parserBean(bean));
	}

	public final Class<T> getTypeOfBean() {
		return this.typeOfBean;
	}

	public final Class<K> getTypeOfEntity() {
		return this.typeOfEntity;
	}

	public final Class<IDE> getTypeOfKeyEntity() {
		return this.typeOfKeyEntity;
	}

	public final Class<IDB> getTypeOfKeyBean() {
		return this.typeOfKeyBean;
	}

	public final T parserEntity(K entity) {
		return ParserDatabase.parserEntityToBean(entity, getTypeOfBean());
	}

	public final K parserBean(T bean) {
		return ParserDatabase.parserBeanToEntity(bean, getTypeOfEntity());
	}

	public final IDB parserKeyEntity(IDE idEntity) {
		return ParserDatabase.parserKeyEntityToKeyBean(idEntity, getTypeOfKeyBean());
	}

	public final IDE parserKeyBean(IDB idBean) {
		return ParserDatabase.parserKeyBeanToKeyEntity(idBean, getTypeOfKeyEntity());
	}

	public final List<T> parserEntity(List<K> entities) {
		return ParserDatabase.parserListEntitiesToBeans(entities, getTypeOfBean());
	}

	public final List<K> parserBean(List<T> beans) {
		return ParserDatabase.parserListBeansToEntities(beans, getTypeOfEntity());
	}

}
