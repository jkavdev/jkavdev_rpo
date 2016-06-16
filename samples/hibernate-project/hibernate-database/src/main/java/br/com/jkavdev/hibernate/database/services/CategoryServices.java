package br.com.jkavdev.hibernate.database.services;

import java.util.List;

import br.com.jkavdev.hibernate.database.interfaces.ICategoryDao;
import br.com.jkavdev.hibernate.database.interfaces.IDaoFactory;
import br.com.jkavdev.hibernate.database.utils.ParserDatabase;
import br.com.jkavdev.hibernate.utils.database.beans.CategoryBean;
import br.com.jkavdev.hibernate.utils.database.interfaces.ICategoryServices;

public class CategoryServices implements ICategoryServices {

	private final ICategoryDao categoryDao;

	public CategoryServices(IDaoFactory daoFactory) {
		this.categoryDao = daoFactory.getCategoryDao();
	}

	@Override
	public CategoryBean findById(Long id) {
		return ParserDatabase.parserEntityToBean(this.categoryDao.findById(id));
	}

	@Override
	public List<CategoryBean> findAllCategories() {
		return ParserDatabase.parseCategoryEntitiesToBeans(this.categoryDao.findAll());
	}

	@Override
	public Long insert(CategoryBean category) {
		return this.categoryDao.save(ParserDatabase.parserBeanToEntity(category));
	}

	@Override
	public void update(CategoryBean category) {
		this.categoryDao.update(ParserDatabase.parserBeanToEntity(category));
	}

	@Override
	public void delete(CategoryBean category) {
		this.categoryDao.delete(ParserDatabase.parserBeanToEntity(category));
	}

}
