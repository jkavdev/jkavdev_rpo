package br.com.jkavdev.frameworks.jsf.primefaces.support.product;

import java.util.ResourceBundle;

import javax.faces.application.Application;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.context.annotation.Scope;
import org.springframework.web.context.WebApplicationContext;

import br.com.jkavdev.frameworks.jsf.primefaces.model.ProductEntity;
import br.com.jkavdev.frameworks.jsf.primefaces.model.repositories.IProductRepository;
import br.com.jkavdev.frameworks.jsf.primefaces.model.utils.BaseBeans;

@Scope(value = WebApplicationContext.SCOPE_REQUEST)
@Named(value = "productAddEditBean")
public class ProductAddEditBean extends BaseBeans {

	private static final long serialVersionUID = 1L;

	@Inject
	private FacesContext context;
	@Inject
	private ProductBean productBean;
	@Inject
	private IProductRepository productRepository;
	private ProductEntity product;
	private String title;

	public ProductAddEditBean() {
		this.product = new ProductEntity();
	}

	public void add() {
		this.title = this.getResourceProperty("labels", "product_add");
	}

	public void update() {
		this.title = this.getResourceProperty("labels", "product_update");
		this.product = this.productBean.getSelectedProduct();
	}

	public void save() {
		if (this.product != null) {
			if (this.product.getId() == null) {
				// o spring reconhece quando a entidade tem ou nao um id

				// add ou
				this.productRepository.save(this.product);
			} else {
				// update
				this.productRepository.save(this.product);
			}
		}
	}

	public void cancel() {
		this.productBean.unselectProduct();
	}

	private String getResourceProperty(String resource, String label) {
		Application application = this.context.getApplication();
		ResourceBundle bundle = application.getResourceBundle(this.context,
				resource);

		return bundle.getString(label);
	}

	public ProductEntity getProduct() {
		return product;
	}

	public void setProduct(ProductEntity product) {
		this.product = product;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

}
