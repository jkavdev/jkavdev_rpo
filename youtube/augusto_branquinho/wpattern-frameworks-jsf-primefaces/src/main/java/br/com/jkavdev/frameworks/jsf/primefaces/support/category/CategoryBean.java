package br.com.jkavdev.frameworks.jsf.primefaces.support.category;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Named;

import org.springframework.context.annotation.Scope;
import org.springframework.web.context.WebApplicationContext;

import br.com.jkavdev.frameworks.jsf.primefaces.model.CategoryEntity;
import br.com.jkavdev.frameworks.jsf.primefaces.model.utils.BaseBeans;

@Scope(value = WebApplicationContext.SCOPE_SESSION)
@Named(value = "categoryBean")
public class CategoryBean extends BaseBeans {

	private static final long serialVersionUID = 1L;

	private List<CategoryEntity> categories;

	public void onLoad() {
		categories = new ArrayList<>();
		categories.add(new CategoryEntity(1L, "Category 1", "Category 1", null));
		categories.add(new CategoryEntity(2L, "Category 2", "Category 2", null));
		categories.add(new CategoryEntity(3L, "Category 3", "Category 3", null));
		categories.add(new CategoryEntity(4L, "Category 4", "Category 4", null));
		categories.add(new CategoryEntity(5L, "Category 5", "Category 5", null));
		categories.add(new CategoryEntity(6L, "Category 6", "Category 6", null));
		categories.add(new CategoryEntity(7L, "Category 7", "Category 7", null));
		categories.add(new CategoryEntity(8L, "Category 8", "Category 8", null));
		categories.add(new CategoryEntity(9L, "Category 9", "Category 9", null));
		categories.add(new CategoryEntity(10L, "Category 10", "Category 10", null));
		categories.add(new CategoryEntity(11L, "Category 11", "Category 11", null));
		categories.add(new CategoryEntity(12L, "Category 12", "Category 12", null));
	}

	public List<CategoryEntity> getCategories() {
		return categories;
	}

	public void setCategories(List<CategoryEntity> categories) {
		this.categories = categories;
	}

}
