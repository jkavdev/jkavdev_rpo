package org.wpattern.frameworks.hibernate4.entites;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.wpattern.frameworks.hibernate4.keys.OrderDetailKey;
import org.wpattern.frameworks.hibernate4.utils.BaseBean;

@Entity
@Table(name = "\"Order Detail\"")
public class OrderDetailEntity extends BaseBean {

	private static final long serialVersionUID = 1L;

	@Id
	private OrderDetailKey id;
	private BigDecimal unitPrice;
	private Integer quantity;
	private Float discount;

	public OrderDetailEntity() {
	}

	public OrderDetailEntity(OrderDetailKey id, BigDecimal unitPrice, Integer quantity, Float discount) {
		super();
		this.id = id;
		this.unitPrice = unitPrice;
		this.quantity = quantity;
		this.discount = discount;
	}

	public OrderDetailKey getId() {
		return id;
	}

	public void setId(OrderDetailKey id) {
		this.id = id;
	}

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

	public Float getDiscount() {
		return discount;
	}

	public void setDiscount(Float discount) {
		this.discount = discount;
	}

}
