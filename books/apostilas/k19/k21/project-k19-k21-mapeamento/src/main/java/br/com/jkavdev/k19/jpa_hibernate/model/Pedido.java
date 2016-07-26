package br.com.jkavdev.k19.jpa_hibernate.model;

import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Pedido extends BaseEntity {

	private static final long serialVersionUID = 1L;

	private Calendar data;
	private Cliente cliente;

	@Temporal(TemporalType.DATE)
	public Calendar getData() {
		return data;
	}

	public void setData(Calendar data) {
		this.data = data;
	}

	@ManyToOne(optional = false)
	@JoinColumn(name = "cliente_id")
	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

}
