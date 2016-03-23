package org.wpattern.frameworks.hibernate4.entites;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Table;

import org.wpattern.frameworks.hibernate4.utils.BaseBean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Table(name = "orders")
public class OrderEntity extends BaseBean {

	private static final long serialVersionUID = 1L;

	private Long id;
	private String customerId;
	private String employeeId;
	private Date orderDate;
	private Date requiredDate;
	private Date shippedDate;
	private Long shipVia;
	private BigDecimal freight;
	private String shipName;
	private String shipAddress;
	private String shipRegion;
	private String shipPostalCode;
	private String shipCountry;

	public OrderEntity() {
	}

	public OrderEntity(Long id, String customerId, String employeeId, Date orderDate, Date requiredDate,
			Date shippedDate, Long shipVia, BigDecimal freight, String shipName, String shipAddress, String shipRegion,
			String shipPostalCode, String shipCountry) {
		super();
		this.id = id;
		this.customerId = customerId;
		this.employeeId = employeeId;
		this.orderDate = orderDate;
		this.requiredDate = requiredDate;
		this.shippedDate = shippedDate;
		this.shipVia = shipVia;
		this.freight = freight;
		this.shipName = shipName;
		this.shipAddress = shipAddress;
		this.shipRegion = shipRegion;
		this.shipPostalCode = shipPostalCode;
		this.shipCountry = shipCountry;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "OrderID")
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public Date getRequiredDate() {
		return requiredDate;
	}

	public void setRequiredDate(Date requiredDate) {
		this.requiredDate = requiredDate;
	}

	public Date getShippedDate() {
		return shippedDate;
	}

	public void setShippedDate(Date shippedDate) {
		this.shippedDate = shippedDate;
	}

	public Long getShipVia() {
		return shipVia;
	}

	public void setShipVia(Long shipVia) {
		this.shipVia = shipVia;
	}

	public BigDecimal getFreight() {
		return freight;
	}

	public void setFreight(BigDecimal freight) {
		this.freight = freight;
	}

	public String getShipName() {
		return shipName;
	}

	public void setShipName(String shipName) {
		this.shipName = shipName;
	}

	public String getShipAddress() {
		return shipAddress;
	}

	public void setShipAddress(String shipAddress) {
		this.shipAddress = shipAddress;
	}

	public String getShipRegion() {
		return shipRegion;
	}

	public void setShipRegion(String shipRegion) {
		this.shipRegion = shipRegion;
	}

	public String getShipPostalCode() {
		return shipPostalCode;
	}

	public void setShipPostalCode(String shipPostalCode) {
		this.shipPostalCode = shipPostalCode;
	}

	public String getShipCountry() {
		return shipCountry;
	}

	public void setShipCountry(String shipCountry) {
		this.shipCountry = shipCountry;
	}

}