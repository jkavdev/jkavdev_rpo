package org.wpattern.frameworks.hibernate4.keys;

import javax.persistence.Embeddable;

import org.wpattern.frameworks.hibernate4.utils.BaseBean;

@Embeddable
public class OrderDetailKey extends BaseBean {

	private static final long serialVersionUID = 1L;

	private Long orderId;
	private Long productId;

	public OrderDetailKey() {
	}

	public OrderDetailKey(Long orderId, Long productId) {
		super();
		this.orderId = orderId;
		this.productId = productId;
	}

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

}
