package br.com.jkavdev.northwind.database.entities;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import br.com.jkavdev.northwind.database.entities.keys.CustomerCustomerDemoKeyEntity;
import br.com.jkavdev.northwind.database.utils.BaseEntity;

@Entity
@Table(name="CustomerCustomerDemo")
public class CustomerCustomerDemoEntity extends BaseEntity {

	private static final long serialVersionUID = -16240817663243274L;

	@EmbeddedId
	private CustomerCustomerDemoKeyEntity customerCustomerDemoKey;

	public CustomerCustomerDemoKeyEntity getCustomerCustomerDemoKey() {
		return this.customerCustomerDemoKey;
	}

	public void setCustomerCustomerDemoKey(CustomerCustomerDemoKeyEntity customerCustomerDemoKey) {
		this.customerCustomerDemoKey = customerCustomerDemoKey;
	}

}
