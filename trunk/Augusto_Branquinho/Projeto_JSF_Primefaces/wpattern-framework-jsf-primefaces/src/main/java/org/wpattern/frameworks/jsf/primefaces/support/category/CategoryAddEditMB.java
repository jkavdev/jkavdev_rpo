package org.wpattern.frameworks.jsf.primefaces.support.category;

import java.util.ResourceBundle;

import javax.faces.application.Application;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.context.annotation.Scope;
import org.springframework.web.context.WebApplicationContext;
import org.wpattern.frameworks.jsf.primefaces.model.CategoryEntity;
import org.wpattern.frameworks.jsf.primefaces.model.utils.BaseBeans;

//managed bean especializado para adicao e edicao

@Scope(value = WebApplicationContext.SCOPE_REQUEST)
@Named(value = "categoryAddEditMB")
public class CategoryAddEditMB extends BaseBeans {

	private static final long serialVersionUID = 1L;

	@Inject
	private CategoryMB categoryMB;
	//contexto do primefaces
	@Inject
	private FacesContext context;
	private CategoryEntity category;
	//define o tipo de operacao
	private String title;

	//de acordo com o metodo indicaremos qual titulo sera carregado
	//label sera o propriedade no arquivo de idioma
	public void add() {
		this.title = this.getResourceProperty("labels", "category_add");
	}

	public void update() {
		this.title = this.getResourceProperty("labels", "category_update");
	}
	
	public void save(){
		if(this.category != null){
			if(this.category.getId() == null){
				//salva 
//				this.categoryRepository.save(this.category);
				category.setId(this.categoryMB.getCategories().size() + 1L);
				this.categoryMB.getCategories().add(category);
			}else{
				//atualiza
//				this.categoryRepository.update(this.category);
				for (int i = 0; i < this.categoryMB.getCategories().size(); i++) {
					if(this.categoryMB.getCategories().get(i).getId() == this.category.getId()){
						this.categoryMB.getCategories().set(i, category);
					}
				}
			}
		}
	}

	public void cancel(){
		this.categoryMB.unselectedCategory();
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