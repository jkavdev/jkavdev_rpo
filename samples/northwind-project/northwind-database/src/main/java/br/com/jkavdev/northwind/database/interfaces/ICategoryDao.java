package br.com.jkavdev.northwind.database.interfaces;

import java.util.List;

import br.com.jkavdev.northwind.database.entities.CategoryEntity;
import br.com.jkavdev.northwind.database.utils.interfaces.IGenericDao;

public interface ICategoryDao extends IGenericDao<CategoryEntity, Long> {

	public List<CategoryEntity> findCategoriesByProductName(String productName);

}
