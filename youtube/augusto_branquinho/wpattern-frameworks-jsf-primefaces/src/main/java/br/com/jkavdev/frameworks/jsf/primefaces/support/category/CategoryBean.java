package br.com.jkavdev.frameworks.jsf.primefaces.support.category;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.apache.log4j.Logger;
import org.primefaces.event.SelectEvent;
import org.springframework.context.annotation.Scope;
import org.springframework.web.context.WebApplicationContext;

import br.com.jkavdev.frameworks.jsf.primefaces.model.CategoryEntity;
import br.com.jkavdev.frameworks.jsf.primefaces.model.repositories.ICategoryRepository;
import br.com.jkavdev.frameworks.jsf.primefaces.model.utils.BaseBeans;

@Scope(value = WebApplicationContext.SCOPE_SESSION)
@Named(value = "categoryBean")
public class CategoryBean extends BaseBeans {

	private static final long serialVersionUID = 1L;
	private Logger logger = Logger.getLogger(getClass());

	private List<CategoryEntity> categories;
	@Inject
	private ICategoryRepository categoryRepository;
	private CategoryEntity categorySelected;
	private Long id;

	public CategoryBean() {
	}

	public void onLoad() {
		categories = categoryRepository.findAll();
	}

	public void unselecteCategory() {

	}

	public void delete() {
		if (this.categorySelected != null) {
			this.categoryRepository.delete(this.categorySelected.getId());
		}
	}

	public void selectCategory(SelectEvent event) {
		try {
			if (event.getObject() != null) {
				this.categorySelected = (CategoryEntity) event.getObject();
			} else {
				this.unselectCategory();
			}
		} catch (Exception e) {
			this.unselectCategory();

			logger.error(e.getMessage(), e);
		}
	}

	public void unselectCategory() {
		this.categorySelected = null;
	}

	public List<CategoryEntity> getCategories() {
		return categories;
	}

	public void setCategories(List<CategoryEntity> categories) {
		this.categories = categories;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public CategoryEntity getCategorySelected() {
		return categorySelected;
	}

	public void setCategorySelected(CategoryEntity categorySelected) {
		this.categorySelected = categorySelected;
	}

}
