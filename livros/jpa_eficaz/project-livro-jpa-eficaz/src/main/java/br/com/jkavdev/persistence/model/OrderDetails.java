package br.com.jkavdev.persistence.model;

import java.math.BigDecimal;

import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "order_details")
@AssociationOverrides({ @AssociationOverride(name = "primaryKey.orders", joinColumns = @JoinColumn(name = "order_id")),
		@AssociationOverride(name = "primaryKey.product", joinColumns = @JoinColumn(name = "product_id")) })
public class OrderDetails {
	// composite-id key
	private OrderDetailsId primaryKey = new OrderDetailsId();

	// additional fields
	private BigDecimal unitPrice;
	private Integer quantity;
	private BigDecimal discount;

	@EmbeddedId
	public OrderDetailsId getPrimaryKey() {
		return primaryKey;
	}

	public void setPrimaryKey(OrderDetailsId primaryKey) {
		this.primaryKey = primaryKey;
	}

	@Transient
	public Orders getOrders() {
		return getPrimaryKey().getOrders();
	}

	public void setOrders(Orders order) {
		getPrimaryKey().setOrders(order);
	}

	@Transient
	public Product getProduct() {
		return getPrimaryKey().getProduct();
	}

	public void setProduct(Product product) {
		getPrimaryKey().setProduct(product);
	}

	@Column(name = "unit_price")
	public BigDecimal getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(BigDecimal unitPrice) {
		this.unitPrice = unitPrice;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public BigDecimal getDiscount() {
		return discount;
	}

	public void setDiscount(BigDecimal discount) {
		this.discount = discount;
	}

}
