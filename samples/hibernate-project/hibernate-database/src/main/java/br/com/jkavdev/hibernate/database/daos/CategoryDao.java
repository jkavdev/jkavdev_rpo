package br.com.jkavdev.hibernate.database.daos;

import br.com.jkavdev.hibernate.database.entities.CategoryEntity;
import br.com.jkavdev.hibernate.database.interfaces.ICategoryDao;
import br.com.jkavdev.hibernate.database.utils.GenericDao;

public class CategoryDao extends GenericDao<CategoryEntity, Long> implements ICategoryDao {

}
