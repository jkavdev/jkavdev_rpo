package org.wpattern.frameworks.hibernate4.daos;

import java.util.List;

import org.wpattern.frameworks.hibernate4.entites.CategoryEntity;
import org.wpattern.frameworks.hibernate4.utils.GenericDAO;

public class CategoryDAO extends GenericDAO<CategoryEntity, Long> {

	@SuppressWarnings("unchecked")
	public List<CategoryEntity> findByCategoryName(String categoryName) {
		String sql = "select c from CategoryEntity c where c.categoryName = ?0";
		List<CategoryEntity> categories = (List<CategoryEntity>) this.executeQuery(sql, categoryName);
		return categories;
	}

}
