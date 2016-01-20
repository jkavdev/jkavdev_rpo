package org.wpattern.frameworks.hibernate4.entites;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.wpattern.frameworks.hibernate4.utils.BaseBean;

@Entity
@Table(name = "products")
public class ProductEntity extends BaseBean {

	private static final long serialVersionUID = 1L;

	private Long id;
	private String productName;
	private Long supplierId;
	private String quantityPerUnit;
	private BigDecimal unitPrice;
	private Short unitsInStock;
	private Short unitsOnOrder;
	private Short reorderLevel;
	private boolean discontinued;
	private Long categoryId;

	public ProductEntity() {
	}

	public ProductEntity(Long id, String productName, Long supplierId, String quantityPerUnit, BigDecimal unitPrice,
			Short unitsInStock, Short unitsOnOrder, Short reorderLevel, boolean discontinued, Long categoryId) {
		super();
		this.id = id;
		this.productName = productName;
		this.supplierId = supplierId;
		this.quantityPerUnit = quantityPerUnit;
		this.unitPrice = unitPrice;
		this.unitsInStock = unitsInStock;
		this.unitsOnOrder = unitsOnOrder;
		this.reorderLevel = reorderLevel;
		this.discontinued = discontinued;
		this.categoryId = categoryId;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ProductID")
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "ProductName")
	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	@Column(name = "SupplierID")
	public Long getSupplierId() {
		return supplierId;
	}

	public void setSupplierId(Long supplierId) {
		this.supplierId = supplierId;
	}

	@Column(name = "QuantityPerUnit")
	public String getQuantityPerUnit() {
		return quantityPerUnit;
	}

	public void setQuantityPerUnit(String quantityPerUnit) {
		this.quantityPerUnit = quantityPerUnit;
	}

	@Column(name = "UnitPrice")
	public BigDecimal getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(BigDecimal unitPrice) {
		this.unitPrice = unitPrice;
	}

	@Column(name = "UnitsInStock")
	public Short getUnitsInStock() {
		return unitsInStock;
	}

	public void setUnitsInStock(Short unitsInStock) {
		this.unitsInStock = unitsInStock;
	}

	@Column(name = "UnitsOnOrder")
	public Short getUnitsOnOrder() {
		return unitsOnOrder;
	}

	public void setUnitsOnOrder(Short unitsOnOrder) {
		this.unitsOnOrder = unitsOnOrder;
	}

	@Column(name = "ReorderLevel")
	public Short getReorderLevel() {
		return reorderLevel;
	}

	public void setReorderLevel(Short reorderLevel) {
		this.reorderLevel = reorderLevel;
	}

	@Column(name = "Discontinued")
	public boolean isDiscontinued() {
		return discontinued;
	}

	public void setDiscontinued(boolean discontinued) {
		this.discontinued = discontinued;
	}

	@Column(name = "CategoryID")
	public Long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

}
