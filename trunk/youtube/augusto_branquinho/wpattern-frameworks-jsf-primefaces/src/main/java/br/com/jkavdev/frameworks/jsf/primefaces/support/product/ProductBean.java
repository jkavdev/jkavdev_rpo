package br.com.jkavdev.frameworks.jsf.primefaces.support.product;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.apache.log4j.Logger;
import org.primefaces.event.SelectEvent;
import org.springframework.context.annotation.Scope;
import org.springframework.web.context.WebApplicationContext;

import br.com.jkavdev.frameworks.jsf.primefaces.model.ProductEntity;
import br.com.jkavdev.frameworks.jsf.primefaces.model.repositories.IProductRepository;
import br.com.jkavdev.frameworks.jsf.primefaces.model.utils.BaseBeans;

@Scope(value = WebApplicationContext.SCOPE_SESSION)
@Named(value = "productBean")
public class ProductBean extends BaseBeans {

	private static final long serialVersionUID = 1L;
	private Logger logger = Logger.getLogger(getClass());

	@Inject
	private IProductRepository productRepository;
	private List<ProductEntity> products;
	private ProductEntity selectedProduct;
	private Long id;

	public ProductBean() {
	}

	public void onLoad() {
		this.products = this.productRepository.findAll();
	}

	public void selectProduct(SelectEvent event) {
		try {
			if (event.getObject() != null) {
				this.selectedProduct = (ProductEntity) event.getObject();
			} else {
				this.unselectProduct();
			}
		} catch (Exception e) {
			this.unselectProduct();

			logger.error(e.getMessage(), e);
		}
	}

	public void unselectProduct() {
		this.selectedProduct = null;
	}

	public void delete() {
		if (this.selectedProduct != null) {
			this.productRepository.delete(this.selectedProduct.getId());
		}
	}

	public List<ProductEntity> getProducts() {
		return products;
	}

	public void setProducts(List<ProductEntity> products) {
		this.products = products;
	}

	public ProductEntity getSelectedProduct() {
		return selectedProduct;
	}

	public void setSelectedProduct(ProductEntity selectedProduct) {
		this.selectedProduct = selectedProduct;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
