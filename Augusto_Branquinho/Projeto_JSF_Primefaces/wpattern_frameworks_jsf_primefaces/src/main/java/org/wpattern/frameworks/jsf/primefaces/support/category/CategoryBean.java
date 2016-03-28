package org.wpattern.frameworks.jsf.primefaces.support.category;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Named;

import org.springframework.context.annotation.Scope;
import org.springframework.web.context.WebApplicationContext;
import org.wpattern.frameworks.jsf.primefaces.model.CategoryEntity;
import org.wpattern.frameworks.jsf.primefaces.model.utils.BaseBeans;

@Scope(value = WebApplicationContext.SCOPE_SESSION)
@Named(value = "categoryBean")
public class CategoryBean extends BaseBeans {

	private static final long serialVersionUID = 1L;

	private List<CategoryEntity> categories;

	public void onLoad() {
		this.categories = new ArrayList<>();
		categories.add(new CategoryEntity(1L, "Category Name 1", "Description 1", null));
		categories.add(new CategoryEntity(2L, "Category Name 2", "Description 2", null));
		categories.add(new CategoryEntity(3L, "Category Name 3", "Description 3", null));
		categories.add(new CategoryEntity(4L, "Category Name 4", "Description 4", null));
		categories.add(new CategoryEntity(5L, "Category Name 5", "Description 5", null));
	}

	public List<CategoryEntity> getCategories() {
		return categories;
	}

	public void setCategories(List<CategoryEntity> categories) {
		this.categories = categories;
	}

}
