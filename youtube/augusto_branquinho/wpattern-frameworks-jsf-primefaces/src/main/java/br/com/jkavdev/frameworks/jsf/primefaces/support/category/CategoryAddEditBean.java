package br.com.jkavdev.frameworks.jsf.primefaces.support.category;

import java.util.ResourceBundle;

import javax.faces.application.Application;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.context.annotation.Scope;
import org.springframework.web.context.WebApplicationContext;

import br.com.jkavdev.frameworks.jsf.primefaces.model.CategoryEntity;
import br.com.jkavdev.frameworks.jsf.primefaces.model.utils.BaseBeans;

@Scope(value = WebApplicationContext.SCOPE_REQUEST)
@Named(value = "categoryAddEditBean")
public class CategoryAddEditBean extends BaseBeans {

	private static final long serialVersionUID = 1L;

	// contexto do primefaces
	@Inject
	private FacesContext context;
	@Inject
	private CategoryBean categoryBean;
	private CategoryEntity category;
	private String title;

	public CategoryAddEditBean() {
		this.category = new CategoryEntity();
	}

	public void add() {
		this.title = this.getResourceProperty("labels", "category_add");
		this.title = this.getResourceProperty("labels", "category_add");
	}

	public void update() {
		this.title = this.getResourceProperty("labels", "category_update");
	}

	public void save() {
		if (this.category != null) {
			if (this.category.getId() == null) {
				category.setId(this.categoryBean.getCategories().size() + 1L);
				this.categoryBean.getCategories().add(category);
			} else {
				for (int i = 0; i < categoryBean.getCategories().size(); i++) {
					if (this.categoryBean.getCategories().get(i).getId() == this.category.getId()) {
						this.categoryBean.getCategories().set(i, category);
					}
				}
			}
		}
	}

	public void cancel() {
		this.categoryBean.unselecteCategory();
	}

	private String getResourceProperty(String resource, String label) {
		Application application = this.context.getApplication();
		ResourceBundle bundle = application.getResourceBundle(this.context, resource);

		return bundle.getString(label);
	}

	public CategoryEntity getCategory() {
		return category;
	}

	public void setCategory(CategoryEntity category) {
		this.category = category;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

}
