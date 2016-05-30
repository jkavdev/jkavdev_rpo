package br.com.jkavdev.persistence.model;

import java.io.Serializable;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "orders")
public class Orders implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private long id;
	private Employee employee;
	private Customer customer;
	private Calendar orderDate;
	private Calendar requiredDate;
	private Calendar shippedDate;
	private String shipVia;
	private String freight;
	private String shipName;
	private String shipAddress;
	private String shipCity;
	private String shipRegion;
	private String shipPostCode;
	private String shipCountry;

	private Set<OrderDetails> orderDetails = new HashSet<>();
	
	public Orders() {
	}
		
	@Id
	@GeneratedValue
	@Column(name = "order_id")
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	@ManyToOne
	@JoinColumn(name = "employee_id")
	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	@ManyToOne
	@JoinColumn(name = "customer_id")
	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "order_date", nullable = false)
	public Calendar getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Calendar orderDate) {
		this.orderDate = orderDate;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "required_date", nullable = false)
	public Calendar getRequiredDate() {
		return requiredDate;
	}

	public void setRequiredDate(Calendar requiredDate) {
		this.requiredDate = requiredDate;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "shipped_date", nullable = false)
	public Calendar getShippedDate() {
		return shippedDate;
	}

	public void setShippedDate(Calendar shippedDate) {
		this.shippedDate = shippedDate;
	}

	@Column(name = "ship_via")
	public String getShipVia() {
		return shipVia;
	}

	public void setShipVia(String shipVia) {
		this.shipVia = shipVia;
	}

	public String getFreight() {
		return freight;
	}

	public void setFreight(String freight) {
		this.freight = freight;
	}

	@Column(name = "ship_name")
	public String getShipName() {
		return shipName;
	}

	public void setShipName(String shipName) {
		this.shipName = shipName;
	}

	@Column(name = "ship_address")
	public String getShipAddress() {
		return shipAddress;
	}

	public void setShipAddress(String shipAddress) {
		this.shipAddress = shipAddress;
	}

	@Column(name = "ship_city")
	public String getShipCity() {
		return shipCity;
	}

	public void setShipCity(String shipCity) {
		this.shipCity = shipCity;
	}

	@Column(name = "ship_region")
	public String getShipRegion() {
		return shipRegion;
	}

	public void setShipRegion(String shipRegion) {
		this.shipRegion = shipRegion;
	}

	@Column(name = "ship_post_code")
	public String getShipPostCode() {
		return shipPostCode;
	}

	public void setShipPostCode(String shipPostCode) {
		this.shipPostCode = shipPostCode;
	}

	@Column(name = "ship_country")
	public String getShipCountry() {
		return shipCountry;
	}

	public void setShipCountry(String shipCountry) {
		this.shipCountry = shipCountry;
	}

	@OneToMany(mappedBy = "primaryKey.orders",
			cascade = CascadeType.ALL)
	public Set<OrderDetails> getOrderDetails() {
		return orderDetails;
	}

	public void setOrderDetails(Set<OrderDetails> orders) {
		this.orderDetails = orders;
	}
	
	public void addOrderDetails(OrderDetails orderDetails) {
		this.orderDetails.add(orderDetails);
	}

}